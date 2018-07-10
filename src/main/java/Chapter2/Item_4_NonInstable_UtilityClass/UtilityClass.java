package Chapter2.Item_4_NonInstable_UtilityClass;

public class UtilityClass {
    //provide nonInstantiability
    private UtilityClass() {
        throw new AssertionError();
    }
    //Utility methods
}
