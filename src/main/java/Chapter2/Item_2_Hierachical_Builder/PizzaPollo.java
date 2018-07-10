package Chapter2.Item_2_Hierachical_Builder;

import java.util.Objects;

public class PizzaPollo extends Pizza{
    private final Size size;

    private PizzaPollo(Builder builder) {
        super(builder);
        size = builder.size;
    }

    public static class Builder extends Pizza.Builder<Builder> {
        private final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override
        public Pizza build() {
            return new PizzaPollo(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }
}