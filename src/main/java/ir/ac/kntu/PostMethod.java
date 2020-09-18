package ir.ac.kntu;

public enum PostMethod {
    NORMAL(1d),CUSTOM(2d);
    private double coefficient;

    PostMethod(double coefficient) {
        this.coefficient = coefficient;
    }
}
