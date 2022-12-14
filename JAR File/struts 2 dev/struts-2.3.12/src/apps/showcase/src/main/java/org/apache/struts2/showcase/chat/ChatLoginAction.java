= location;
        }

        if (view.indexOf('?') != -1) {
            view = view.substring(0, view.indexOf('?'));
        }

        return view;
    }

    class TempLink {
        SiteGraphNode node;
        String location;
        int typeResult;
        String label;

        public TempLink(SiteGraphNode node, String location, int typeResult, String label) {
            this.node = node;
            this.location = location;
            this.typeResult = typeResult;
            this.label = label;
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof TempLink)) return false;

            final TempLink tempLink = (TempLink) o;

            if (typeResult != tempLink.typeResult) return false;
            if (label != null ? !label.equals(tempLink.label) : tempLink.label != null) return false;
            if (location != null ? !location.equals(tempLink.location) : tempLink.location != null) return false;
            if (node != null ? !node.equals(tempLink.node) : tempLink.node != null) return false;

            return true;
        }

        public int hashCode() {
            int result;
            result = (node != null ? node.hashCode() : 0);
            result = 29 * result + (location != null ? location.hashCode() : 0);
            result = 29 * result + typeResult;
            result = 29 * result + (label != null ? label.hashCode() : 0);
            return result;
        }
    }
}
                                                                                                                                                                                                                                                                                                                                                                 