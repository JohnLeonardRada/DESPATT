;
        }

        public Builder(String name, String exceptionClassName, String result) {
            target = new ExceptionMappingConfig(name, exceptionClassName, result);
        }

        public Builder name(String name) {
            target.name = name;
            return this;
        }

        public Builder exceptionClassName(String name) {
            target.exceptionClassName = name;
            return this;
        }

        public Builder result(String result) {
            target.result = result;
            return this;
        }

        public Builder addParam(String name, String value) {
            target.params.put(name, value);
            return this;
        }

        public Builder addParams(Map<String,String> params) {
            target.params.putAll(params);
            return this;
        }

        public Builder location(Location loc) {
            target.location = loc;
            return this;
        }

        public ExceptionMappingConfig build() {
            embalmTarget();
            ExceptionMappingConfig result = target;
            target = new ExceptionMappingConfig(target);
            return result;
        }

        protected void embalmTarget() {
            target.params = Collections.unmodifiableMap(target.params);
        }
    }

}
                                                                                                                                                                                                                                                                                          