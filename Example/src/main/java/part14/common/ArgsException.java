package part14.common;

public class ArgsException extends Exception {
    public ArgsException() {
    }

    public ArgsException(String message) {
        super(message);
    }

    public Object errorMessage() {
        return null;
    }
}
