package prog.lab3;

public class AlreadyExistsException extends Exception {
    public AlreadyExistsException() {
        super("This class can only have one instance");

    }

}
