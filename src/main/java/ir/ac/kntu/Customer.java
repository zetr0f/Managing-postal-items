package ir.ac.kntu;

import java.util.ArrayList;
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

    public static Customer searchByName(ArrayList<Customer> customers,String name) {
        for (Customer customer : customers) {
            if (customer.getName().equals(name)) {
                return customer;
            }
        }
        return null;
    }

    public static Customer searchByNationalCode(ArrayList<Customer> customers,String nationalCode) {
        for (Customer customer : customers) {
            if (customer.getNationalCode().equals(nationalCode)) {
                return customer;
            }
        }
        return null;
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
