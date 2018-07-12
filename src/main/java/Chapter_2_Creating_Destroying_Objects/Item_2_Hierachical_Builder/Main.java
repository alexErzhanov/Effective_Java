package Chapter_2_Creating_Destroying_Objects.Item_2_Hierachical_Builder;

import static Chapter_2_Creating_Destroying_Objects.Item_2_Hierachical_Builder.Size.SMALL;

public class Main {
    public static void main(String[] args) {
        Pizza pizza1 = new PizzaPollo.Builder(SMALL).addTopping(Topping.PEPPER)
                .addTopping(Topping.ONION).build();
        Pizza pizza2 = new PizzaCalzone.Builder().addTopping(Topping.MUSHROOM)
                .addTopping(Topping.HAM).sauceInside().build();
    }
}
