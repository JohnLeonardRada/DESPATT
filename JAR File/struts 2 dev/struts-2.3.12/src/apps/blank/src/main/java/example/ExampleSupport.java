     public Builder location(Location loc) {
            target.location = loc;
            return this;
        }

        public InterceptorConfig build() {
            embalmTarget();
            InterceptorConfig result = target;
            target = new InterceptorConfig(target);
            return result;
        }

        protected void embalmTarget() {
            target.params = Collections.unmodifiableMap(target.params);
        }
    }
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    