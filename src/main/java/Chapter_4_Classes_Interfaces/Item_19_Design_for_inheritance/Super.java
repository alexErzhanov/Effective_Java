package Chapter_4_Classes_Interfaces.Item_19_Design_for_inheritance;

public class Super {

    // Broken - constructor invokes an overridable method
    public Super() {
        overrideMe();
    }

    public void overrideMe() {
    }
}
