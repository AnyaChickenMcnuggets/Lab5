package Exceptions;

public class MyNullException extends Exception {
    private String nameError;

    public MyNullException(String nameError) {
        this.nameError = nameError;
    }

    public String getNameError() {
        return this.nameError;
    }
}
