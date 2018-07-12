package Chapter_2_Creating_Destroying_Objects.Item_2_Hierachical_Builder;

public class PizzaCalzone extends Pizza {
    private final boolean sauceInside;

    PizzaCalzone(Builder builder) {
        super(builder);
        sauceInside = builder.sauceInside;
    }

    public static class Builder extends Pizza.Builder<Builder> {
        private boolean sauceInside = false;

        public Builder sauceInside() {
            this.sauceInside = true;
            return this;
        }

        @Override
        public Pizza build() {
            return new PizzaCalzone(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }
}
