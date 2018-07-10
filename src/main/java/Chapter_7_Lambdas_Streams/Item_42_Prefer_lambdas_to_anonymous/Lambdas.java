package Chapter_7_Lambdas_Streams.Item_42_Prefer_lambdas_to_anonymous;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lambdas {

    public void sort(List<String> words) {
        // Anonymous class instance as a function object - obsolete!
        Collections.sort(words, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });
    }

    /**Note that the types of the lambda (Comparator<String>), of its
     parameters (s1 and s2, both String), and of its return value (int) are not
     present in the code. The compiler deduces these types from context, using a
     process known as type inference. In some cases, the compiler won’t be able to
     determine the types, and you’ll have to specify them. The rules for type
     inference are complex: they take up an entire chapter in the JLS [JLS, 18]. Few
     programmers understand these rules in detail, but that’s OK.*/
    public void sortWithLambda(List<String> words) {
        // Lambda expression as function object (replaces anonymous class)
        Collections.sort(words,
                (s1, s2) -> Integer.compare(s1.length(), s2.length()));
    }

    /**One caveat should be added concerning type inference. Item 26 tells you not
     to use raw types, Item 29 tells you to favor generic types, and Item 30 tells you
     to favor generic methods. This advice is doubly important when you’re using
     lambdas, because the compiler obtains most of the type information that allows
     it to perform type inference from generics. If you don’t provide this information,
     the compiler will be unable to do type inference, and you’ll have to specify types
     manually in your lambdas, which will greatly increase their verbosity. By way of
     example, the code snippet above won’t compile if the variable words is
     declared to be of the raw type List instead of the parameterized type
     List<String>.*/
}
