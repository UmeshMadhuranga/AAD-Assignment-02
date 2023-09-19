package lk.ijse.gdse.springmvc_with_gradle.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}
