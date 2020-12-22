package prog.lab3;
import java.util.Arrays;
import java.util.Objects;

public class Floor implements prog.lab3.Storage {

    Item items[];
    int itemsCount;

    public Floor() {
        itemsCount = 0;
    }


    @Override
    public void addItem(Item item) {

        if (itemsCount == 0)
        {
            items = new Item[1];
            items[0] = item;

            itemsCount = itemsCount + 1;
        }

        else
        {
            Item[] itemsNew = new Item[itemsCount + 1];

            for (int i = 0; i < itemsCount; i++) {
                itemsNew[i] = items[i];
            }
            itemsNew[itemsCount] = item;

            items = itemsNew;

            itemsCount = itemsCount + 1;
        }


    }


    @Override
    public String getStatus() {
        String string = "there are a lot of garbage:\n";

        for(int i = 0; i < itemsCount; i++) {
            string = string + items[i].getName() + '\n';
        }

        return string;
    }


    @Override
    public Item[] getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "items=" + Arrays.toString(items) +
                ", itemsCount=" + itemsCount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Floor floor = (Floor) o;
        return itemsCount == floor.itemsCount &&
                Arrays.equals(items, floor.items);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(itemsCount);
        result = 31 * result + Arrays.hashCode(items);
        return result;
    }
}
