package prog.lab3;
import java.util.Objects;

public abstract class Human {

    protected MessagePrinter messagePrinter;

    public Human(MessagePrinter messagePrinter) {
        this.messagePrinter = messagePrinter;
    }

    public abstract void cook(FoodSource foodSource);

    @Override
    public String toString() {
        return "Human{" +
                "messagePrinter=" + messagePrinter +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(messagePrinter, human.messagePrinter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messagePrinter);
    }

    public abstract void eat(FoodSource foodSource, Storage storage);

    public abstract void cleanUp(Storage storage);

    public abstract void washTheDishes(Storage storage);

    public abstract String getName();
}
