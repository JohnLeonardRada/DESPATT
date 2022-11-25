          if (viewFile != null) {
                                viewMap.put(view, viewFile);
                            }
                        }
                    } else if (resultClassName.contains("Jasper")) {

                    } else if (resultClassName.contains("XSLT")) {

                    } else if (resultClassName.contains("Redirect")) {
                        // check if the redirect is to an action -- if so, link it
                        String locationConfig = resultConfig.getParams().get("location");
                        if (locationConfig == null) {
                            locationConfig = resultConfig.getParams().get("actionName");
                        }
                        String location = getViewLocation(locationConfig, namespace);
                        //  FIXME: work with new configuration style
                        if (location.endsWith("action")) {
                            addTempLink(action, location, Link.TYPE_REDIRECT, resultConfig.getName());
                        } else {
                            ViewNode view = new ViewNode(stripLocation(location));
                            subGraph.addNode(view);

                            addTempLink(action, location, Link.TYPE_REDIRECT, resultConfig.getName());

                            View viewFile = getView(namespace, actionName, resultName, location);
                            if (viewFile != null) {
                                viewMap.put(view, viewFile);
                            }
                        }
                    }
                }
            }
        }

        // now look for links in the view
        for (Map.Entry<ViewNode, 