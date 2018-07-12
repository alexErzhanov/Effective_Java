package Chapter_5_Generics.Item_28_Prefer_lists_to_arrays;

public class ListOrArrays {
    public static void main(String[] args) {
        // Fails at runtime!
        Object[] objectArray = new Long[1];
        objectArray[0] = "I don't fit in"; // Throws ArrayStoreException

        /** Won't compile!*/
        /*List<Object> ol = new ArrayList<Long>(); // Incompatible types
        ol.add("I don't fit in");*/
    }
}
