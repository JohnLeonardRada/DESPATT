Content2HTMLPage(content, request);
            model.put("page", htmlPage);
            model.put("head", htmlPage.getHead());
            model.put("title", htmlPage.getTitle());
            model.put("body", htmlPage.getBody());
            model.put("page.properties", new SimpleHash(htmlPage.getProperties()));

            // finally, render it
            template.process(model, response.getWriter());
        } catch (Exception e) {
            String msg = "Error applying decorator to request: " + request.getRequestURL() + "?" + request.getQueryString() + " with message:" + e.getMessage();
            LOG.error(msg, e);
            throw new ServletException(msg, e);
        } finally {
            UtilTimerStack.pop(timerKey);
        }
    }

}

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             