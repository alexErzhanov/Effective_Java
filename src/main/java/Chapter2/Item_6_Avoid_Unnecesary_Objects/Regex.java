package Chapter2.Item_6_Avoid_Unnecesary_Objects;

import java.util.regex.Pattern;

public class Regex {

    // Performance can be greatly improved!
    static boolean isRomanNumeralFirst(String s) {
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})"
                + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }


    // Reusing expensive object for improved performance

        private static final Pattern ROMAN = Pattern.compile(
                "^(?=.)M*(C[MD]|D?C{0,3})"
                        + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

        static boolean isRomanNumeralSecond(String s) {
            return ROMAN.matcher(s).matches();
        }
}
