package Chapter_6_Enums_Annotations.Item_37_Use_EnumMap;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Plant {
    enum LifeCycle { ANNUAL, PERENNIAL, BIENNIAL }

    final String name;

    final LifeCycle lifeCycle;

    Plant(String name, LifeCycle lifeCycle) {
        this.name = name;
        this.lifeCycle = lifeCycle;
    }
    @Override public String toString() {
        return name;
    }

    /**Now suppose you have an array of plants representing a garden, and you want
     to list these plants organized by life cycle (annual, perennial, or biennial). To do
     this, you construct three sets, one for each life cycle, and iterate through the
     garden, placing each plant in the appropriate set. Some programmers would do
     this by putting the sets into an array indexed by the life cycle’s ordinal:*/
    public void sortPlantsByLifeCycle(Plant [] garden) {
        // Using ordinal() to index into an array - DON'T DO THIS!
        Set<Plant>[] plantsByLifeCycle =
                (Set<Plant>[]) new Set[Plant.LifeCycle.values().length];
        for (int i = 0; i < plantsByLifeCycle.length; i++)
            plantsByLifeCycle[i] = new HashSet<>();
        for (Plant p : garden)
            plantsByLifeCycle[p.lifeCycle.ordinal()].add(p);
        // Print the results
        for (int i = 0; i < plantsByLifeCycle.length; i++) {
            System.out.printf("%s: %s%n",
                    Plant.LifeCycle.values()[i], plantsByLifeCycle[i]);
        }
    }

    public void sortPlantsByLifeCycleWithEnumMap(Plant [] garden) {
        // Using an EnumMap to associate data with an enum
        Map<LifeCycle, Set<Plant>> plantsByLifeCycle =
                new EnumMap<>(Plant.LifeCycle.class);
        for (Plant.LifeCycle lc : Plant.LifeCycle.values())
            plantsByLifeCycle.put(lc, new HashSet<>());
        for (Plant p : garden)
            plantsByLifeCycle.get(p.lifeCycle).add(p);
        System.out.println(plantsByLifeCycle);
    }
}
