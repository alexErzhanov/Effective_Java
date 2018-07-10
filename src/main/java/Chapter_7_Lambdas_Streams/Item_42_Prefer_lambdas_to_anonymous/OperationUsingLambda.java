package Chapter_7_Lambdas_Streams.Item_42_Prefer_lambdas_to_anonymous;

import java.util.function.DoubleBinaryOperator;

/** Enum with function object fields & constant-specific behavior*/
public enum OperationUsingLambda {
    PLUS ("+", (x, y) -> x + y),
    MINUS ("-", (x, y) -> x - y),
    TIMES ("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    private final String symbol;

    /**Note that we’re using the DoubleBinaryOperator interface for the
     lambdas that represent the enum constant’s behavior. This is one of the many
     predefined functional interfaces in java.util.function (Item 44). It
     represents a function that takes two double arguments and returns a double
     result.*/
    private final DoubleBinaryOperator op;

    OperationUsingLambda(String symbol, DoubleBinaryOperator op) {
        this.symbol = symbol;
        this.op = op;
    }

    @Override public String toString() { return symbol; }
    public double apply(double x, double y) {
        return op.applyAsDouble(x, y);
    }
}
