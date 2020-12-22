package prog.lab3;
import java.util.Objects;

public abstract class House {

    protected MessagePrinter messagePrinter;
    protected Human owner;
    protected Storage storage;
    protected FoodSource foodSource;


    public House(MessagePrinter messagePrinter, Human owner, Storage storage, FoodSource foodSource) {
        this.messagePrinter = messagePrinter;
        this.owner = owner;
        this.storage = storage;
        this.foodSource = foodSource;
    }

    @Override
    public String toString() {
        return "House{" +
                "messagePrinter=" + messagePrinter +
                ", owner=" + owner +
                ", storage=" + storage +
                ", foodSource=" + foodSource +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return Objects.equals(messagePrinter, house.messagePrinter) &&
                Objects.equals(owner, house.owner) &&
                Objects.equals(storage, house.storage) &&
                Objects.equals(foodSource, house.foodSource);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messagePrinter, owner, storage, foodSource);
    }

    public abstract void passDay();
}
