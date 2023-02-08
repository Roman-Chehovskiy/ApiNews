package test.event.apiNews.exeption_handling;

public class NoSuchNewsException extends RuntimeException {

    public NoSuchNewsException(String message) {
        super(message);
    }
}
