mon path
                tools = new File(javaHome, "../Classes/classes.jar");
            }
            if (!tools.exists()) {
                // did the user specify it by hand?
                String prop = System.getProperty("tools");
                if (prop != null) {
                    tools = new File(prop);
                }
            }
            if (!tools.exists()) {
                System.out.println("Error: Could not find tools.jar! Please do one of the following: ");
                System.out.println("");
                System.out.println("        - Use the JDK's JVM (ie: c:\\jdk1.5.0\\bin\\java)");
                System.out.println("        - Specify JAVA_HOME to point to your JDK 1.5 home");
                System.out.println("        - Specify a direct path to tools.jar via, as shown below:");
                System.out.println("");
                System.out.println("       java -Dtools=/path/to/tools.jar -jar struts.jar ...");
                