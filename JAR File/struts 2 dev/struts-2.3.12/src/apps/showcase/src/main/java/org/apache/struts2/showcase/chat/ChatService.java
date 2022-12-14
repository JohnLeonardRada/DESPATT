ileWriter(output + "/out.dot");
            } catch (IOException e) {
                throw new StrutsException(e);
            }
        }

        StrutsConfigRetriever.setConfiguration(configDir, views.split("[,]+"));
        DOTRenderer renderer = new DOTRenderer(writer);
        renderer.render(namespace);
    }

    /**
     * Invokes the dot command, cause GraphViz to render out.dot in the form of out.gif,
     * located in the specified output directory. If an error occurs during this process,
     * the error is logged and the method completes without throwing an exception.
     */
    public void render() {
        try {
            Runtime.getRuntime().exec("dot -o" + output + "/out.gif -Tgif " + output + "/out.dot");
        } catch (IOException e) {
            LOG.error("Could not invoke dot", e);
        }
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            