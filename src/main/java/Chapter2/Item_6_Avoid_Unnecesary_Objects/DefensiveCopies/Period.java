package Chapter2.Item_6_Avoid_Unnecesary_Objects.DefensiveCopies;

import java.util.Date;

public final class Period {
    private final Date start;
    private final Date end;

//    Broken constructor
//    public Period(Date start, Date end) {
//        if (start.compareTo(end) > 0)
//            throw new IllegalArgumentException(
//                    start + " after " + end);
//        this.start = start;
//        this.end = end;
//    }


    // Repaired constructor - makes defensive copies of parameters
    public Period(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
        if (this.start.compareTo(this.end) > 0)
            throw new IllegalArgumentException(
                    this.start + " after " + this.end);
    }


    public static void main(String[] args) {
        // Attack the internals of a Period instance
        Date start = new Date();
        Date end = new Date();
        Period p = new Period(start, end);
        end.setYear(78); // Modifies internals of p!
    }

}
