package prog.lab3;

public class NoDishesException extends RuntimeException {
    public NoDishesException() {
        super("There are no any dishes");
    }
}
