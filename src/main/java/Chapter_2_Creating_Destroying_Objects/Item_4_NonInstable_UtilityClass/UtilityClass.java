package Chapter_2_Creating_Destroying_Objects.Item_4_NonInstable_UtilityClass;

public class UtilityClass {
    //provide nonInstantiability
    private UtilityClass() {
        throw new AssertionError();
    }
    //Utility methods
}
