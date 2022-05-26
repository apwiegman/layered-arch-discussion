package bvnk.utils.exceptions;

public class EntityNotFoundException extends RuntimeException {
    private int code;

    public EntityNotFoundException(String message, int code) {
        super(message);
        this.code = code;
    }
}
