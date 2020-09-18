package ir.ac.kntu;

import java.util.Objects;

public class Customer extends Thing implements Cloneable{
    private String nationalCode;

    public Customer(String name, String nationalCode) {
        super(name);
        setNationalCode(nationalCode);
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        if (Validator.checkIranianNationalCode(nationalCode)){
            this.nationalCode = nationalCode;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        if (!super.equals(o)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(getNationalCode(), customer.getNationalCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getNationalCode());
    }

    @Override
    protected Customer clone() throws CloneNotSupportedException {
        Customer customer = (Customer)super.clone();
        customer.setNationalCode(new String(getNationalCode()));
        return customer;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "nationalCode='" + nationalCode + '\'' +
                '}';
    }
}
