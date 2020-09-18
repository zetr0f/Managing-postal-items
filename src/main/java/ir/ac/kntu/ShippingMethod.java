package ir.ac.kntu;

public enum ShippingMethod {
    LAND(1d),AIR(2d),SEA(1.5d);
    private double coefficient;

    ShippingMethod(double coefficient) {
        this.coefficient = coefficient;
    }
}
