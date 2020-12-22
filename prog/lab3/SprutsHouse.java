package prog.lab3;

public class SprutsHouse extends House {

    public static class SprutsHouseFurnace {
        public void useTheFurnace(MessagePrinter messagePrinter) {
            messagePrinter.print("The firewood has run out. We'll have to heat the furniture");
        }
    }

    SprutsHouseFurnace furnace;


    private static boolean isExist = false;

    public SprutsHouse(MessagePrinter messagePrinter, Human owner, Storage storage, FoodSource foodSource,
                       SprutsHouseFurnace furnace) throws AlreadyExistsException {
        super(messagePrinter, owner, storage, foodSource);
        this.furnace = furnace;

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

        class DishNamer {

            int pointer = 0;
            String names[] = {"stove ", "cup", "bowl", "glass", "saucer", "jug"};


            public String getName() {

                pointer = pointer + 1;
                int lenght = names.length;

                return names[pointer % lenght];

            }
        }

        DishNamer namer = new DishNamer();

        //debug
        foodSource.addDish(new Dish(namer.getName()));
        foodSource.addDish(new Dish(namer.getName()));
        foodSource.addDish(new Dish(namer.getName()));

        //breakfast
        messagePrinter.print("Spruts have a breakfast...");
        foodSource.addDish(new Dish(namer.getName()));
        foodSource.addDish(new Dish(namer.getName()));
        owner.eat(foodSource, storage);
        owner.eat(foodSource, storage);
        owner.eat(foodSource, storage);
        messagePrinter.print("Spruts trying to wash the dishes...");
        owner.washTheDishes(storage);

        //lunch
        messagePrinter.print("Spruts have a lunch...");
        foodSource.addDish(new Dish(namer.getName()));
        foodSource.addDish(new Dish(namer.getName()));
        foodSource.addDish(new Dish(namer.getName()));
        owner.eat(foodSource, storage);
        owner.eat(foodSource, storage);
        owner.eat(foodSource, storage);
        messagePrinter.print("Spruts trying to wash the dishes...");
        owner.washTheDishes(storage);

        //dinner
        messagePrinter.print("Spruts have a dinner...");
        foodSource.addDish(new Dish(namer.getName()));
        foodSource.addDish(new Dish(namer.getName()));
        owner.eat(foodSource, storage);
        owner.eat(foodSource, storage);
        owner.eat(foodSource, storage);
        messagePrinter.print("Spruts trying to wash the dishes...");
        owner.washTheDishes(storage);

        messagePrinter.print("Spruts trying to clean up...");
        owner.cleanUp(storage);

        messagePrinter.print(storage.getStatus());
        furnace.useTheFurnace(messagePrinter);
    }
}
