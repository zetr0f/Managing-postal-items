package ir.ac.kntu;

import java.util.Objects;

public abstract class Thing implements Cloneable{
    private String name;

    public Thing(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (Validator.checkName(name)){
            this.name = name;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Thing)) return false;
        Thing thing = (Thing) o;
        return Objects.equals(getName(), thing.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    protected Thing clone() throws CloneNotSupportedException {
        Thing thing = (Thing) super.clone();
        thing.setName(new String(getName()));
        return thing;
    }
}
