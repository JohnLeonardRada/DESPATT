d)
                patterns.add(Pattern.compile(pattern));

            classLoader.setAccepClasses(patterns);
        }

        fam = new FilesystemAlterationMonitor();

        //setup stores
        for (String watch : watchList) {
            File file = new File(watch);

            //make it absolute, if it is a relative path
            if (!file.isAbsolute())
                file = new File(servletContext.getRealPath(watch));

            if (watch.endsWith(".jar")) {
                classLoader.addResourceStore(new JarResourceStore(file));
                //register with the fam
                fam.addListener(file, this);
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Watching [#0] for changes", file.getAbsolutePath());
                }
            } else {
                //get all subdirs
                List<File> dirs = new ArrayList<File>();
                getAllPaths(file, dirs);

                classLoader.addResourceStore(new FileResourceStore(file));

                for (File dir : dirs) {
                    //register with the fam
                    fam.addListener(dir, this);
                    if (LOG.isDebugEnabled()) {
                	LOG.debug("Watching [#0] for changes", dir.getAbsolutePath());
                    }
                }
            }
        }
        //setup the bean factory
        beanFactory = new ClassReloadingBeanFactory();
        beanFactory.setInstantiationStrategy(new ClassReloadingInstantiationStrategy());
        beanFactory.setBeanClassLoader(classLoader);

        //start watch thread
        fam.start();
    }

    /**
     * If root is a dir, find al the subdir paths
     */
    private void getAllPaths(File root, List<File> dirs) {
        dirs.add(root);

        if (root.isDirectory()) {
            File[] files = root.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        getAllPaths(file, dirs);
                    }
                }
            }
        }
    }

    public void close() {
        super.close();

        if (fam != null) {
            fam.