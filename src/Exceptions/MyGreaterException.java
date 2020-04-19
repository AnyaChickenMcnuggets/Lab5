package Exceptions;

public class MyGreaterException extends Exception {
    private String nameError;

    public MyGreaterException(String nameError) {
        this.nameError = nameError;
    }

    public String getNameError() {
        return this.nameError;
    }
}
