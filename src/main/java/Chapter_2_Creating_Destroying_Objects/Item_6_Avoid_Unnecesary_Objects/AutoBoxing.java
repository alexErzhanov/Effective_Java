package Chapter_2_Creating_Destroying_Objects.Item_6_Avoid_Unnecesary_Objects;

public class AutoBoxing {

    // Hideously slow! Can you spot the object creation?
    private static long sum() {
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;  //program creates new Long instance each iteration for i
        return sum;
    }
}
