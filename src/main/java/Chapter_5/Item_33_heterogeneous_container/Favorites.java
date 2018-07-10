package Chapter_5.Item_33_heterogeneous_container;

import java.util.HashMap;
import java.util.Map;

// Typesafe heterogeneous container pattern - implementation
public class Favorites {
    private Map<Class<?>, Object> favorites = new HashMap<>();

    /**If you try to
     store your favorite List<String>, your program won’t compile. The reason
     is that you can’t get a Class object for List<String>. The class literal
     List<String>.class is a syntax error, and it’s a good thing, too.
     List<String> and List<Integer> share a single Class object, which is
     List.class.*/
    public <T> void putFavorite(Class<T> type, T instance) {
        // Achieving runtime type safety with a dynamic cast
        favorites.put(type, type.cast(instance));
    }

    public <T> T getFavorite(Class<T> type) {
        return type.cast(favorites.get(type));
    }


    public static void main(String[] args) {
        Favorites f = new Favorites();
        f.putFavorite(String.class, "Java");
        f.putFavorite(Integer.class, 0xcafebabe);
        f.putFavorite(Class.class, Favorites.class);
        String favoriteString = f.getFavorite(String.class);
        int favoriteInteger = f.getFavorite(Integer.class);
        Class<?> favoriteClass = f.getFavorite(Class.class);
        System.out.printf("%s %x %s%n", favoriteString,
                favoriteInteger, favoriteClass.getName());
    }
}
