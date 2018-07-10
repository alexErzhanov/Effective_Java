package Chapter_6_Enums_Annotations.Item_36_Use_EnumSet;

import java.util.Set;

// EnumSet - a modern replacement for bit fields
public class TextWithEnumSet {

    public enum Style {BOLD, ITALIC, UNDERLINE, STRIKETHROUGH}

    // Any Set could be passed in, but EnumSet is clearly best
    public void applyStyles(Set<Style> styles) {
        System.out.println(styles);
    }
}
