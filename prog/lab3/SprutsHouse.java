package prog.lab3;

public class SprutsHouse extends House {

    private static boolean isExist = false;

    public SprutsHouse(MessagePrinter messagePrinter, Human owner, Storage storage, FoodSource foodSource) throws AlreadyExistsException {
        super(messagePrinter, owner, storage, foodSource);

        if(isExist) {
            throw new AlreadyExistsException();
        }
        isExist = true;

    }


    @Override
    public String toString() {
        return "SprutsHouse{" +
                "messagePrinter=" + messagePrinter +
                ", owner=" + owner +
                ", storage=" + storage +
                ", foodSource=" + foodSource +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public void passDay() {
        //debug
        foodSource.addDish(new Dish("l"));
        foodSource.addDish(new Dish("o"));
        foodSource.addDish(new Dish("k"));
        //breakfast
        messagePrinter.print("Spruts have a breakfast...");
        owner.eat(foodSource, storage);
        owner.eat(foodSource, storage);
        messagePrinter.print("Spruts trying to wash the dishes...");
        owner.washTheDishes(storage);

        //lunch
        messagePrinter.print("Spruts have a lunch...");
        owner.eat(foodSource, storage);
        owner.eat(foodSource, storage);
        owner.eat(foodSource, storage);
        messagePrinter.print("Spruts trying to wash the dishes...");
        owner.washTheDishes(storage);

        //dinner
        messagePrinter.print("Spruts have a dinner...");
        owner.eat(foodSource, storage);
        owner.eat(foodSource, storage);
        messagePrinter.print("Spruts trying to wash the dishes...");
        owner.washTheDishes(storage);

        messagePrinter.print("Spruts trying to clean up...");
        owner.cleanUp(storage);

        messagePrinter.print(storage.getStatus());
    }
}
