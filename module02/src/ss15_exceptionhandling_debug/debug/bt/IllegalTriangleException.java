package ss15_exceptionhandling_debug.debug.bt;

public class IllegalTriangleException extends Exception {
    public String getMessage() {
        return "IllegalTriangleException: your input sides is not a triangle";
    }


}
