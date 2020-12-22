package prog.lab3;
import java.util.Arrays;


public class Cupboard implements prog.lab3.FoodSource {

    protected int countOfNames = 0;

    protected String[] names;

    //protected String[] names = {"pan", "spoon", "fork", "skillet", "pancake pan", "colander", "knife",
    //                            "blender", "multicooker", "plate"};


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cupboard cupboard = (Cupboard) o;
        return Arrays.equals(names, cupboard.names);
    }

    @Override
    public String toString() {
        return "Cupboard{" +
                "names=" + Arrays.toString(names) +
                '}';
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(names);
    }

    private int random(int max) {
        return (int) (( (double) max) * Math.random());
    }


    @Override
    public Item getNewDish() {
        if (countOfNames == 0) {
            throw new NoDishesException();
        }
        return new Dish(names[random(countOfNames)]);
    }

    @Override
    public void addDish(Item item) {
        if (countOfNames == 0) {
            names = new String[1];
            names[0] = item.getName();
            countOfNames = countOfNames + 1;
            return;
        }

        String[] newArray = new String[countOfNames + 1];
        for (int i = 0; i < countOfNames; i++) {
            newArray[i] = names[i];
        }
        newArray[countOfNames] = item.getName();
        names = newArray;
        countOfNames = countOfNames + 1;
    }

}
