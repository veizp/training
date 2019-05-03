package com.veizp.training.vo;

public class HealthCheckVO {

    private boolean system;

    @SuppressWarnings("unused")
    private boolean db;

    private HealthCheckVO() {

    }

    private HealthCheckVO(Builder builder) {
        this.system = builder.system;
        this.db = builder.db;
    }

    public static Builder newBuilder() {
        return Builder.create();
    }

    public boolean isSystem() {
        return system;
    }

    public static class Builder {

        private boolean system;
        private boolean db;

        private Builder() {

        }

        private static Builder create() {
            return new Builder();
        }

        public Builder system(boolean system) {
            this.system = system;
            return this;
        }

        public Builder db(boolean db) {
            this.db = db;
            return this;
        }

        public HealthCheckVO build() {
            return new HealthCheckVO(this);
        }

    }
}
