package prog.lab3;
import java.util.Objects;

public class Dish implements prog.lab3.Item {

    String name;

    public Dish(String name) {
        this.name = name;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return name.equals(dish.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
