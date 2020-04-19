package Exceptions;

public class MyEmptyException extends Throwable {
    private String nameError;

    public MyEmptyException(String nameError) {
        this.nameError = nameError;
    }

    public String getNameError() {
        return this.nameError;
    }
}
