package ir.ac.kntu;

import java.rmi.UnexpectedException;
import java.util.InputMismatchException;
import java.util.Objects;

public class City extends Thing {
    private int x;
    private int y;

    public City(String name, int x, int y) {
        super(name);
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        try {
            this.x = x;
        } catch (InputMismatchException e){
            System.out.println("wrong input");
            this.x = 0;
        }
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        try {
            this.y = y;
        } catch (InputMismatchException e){
            System.out.println("wrong input");
            this.y = 0;
        }
    }

    public static double dis(City city1,City city2){
        return Math.sqrt(Math.pow(city1.getX()-city2.getX(), 2)+Math.pow(city1.getY()-city2.getY(), 2));
    }

    public double dis(City city1){
        return Math.sqrt(Math.pow(city1.getX()-this.getX(), 2)+Math.pow(city1.getY()-this.getY(), 2));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        if (!super.equals(o)) return false;
        City city = (City) o;
        return getX() == city.getX() &&
                getY() == city.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getX(), getY());
    }

    @Override
    protected City clone() throws CloneNotSupportedException {
        return (City) super.clone();
    }

    @Override
    public String toString() {
        return "City{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
