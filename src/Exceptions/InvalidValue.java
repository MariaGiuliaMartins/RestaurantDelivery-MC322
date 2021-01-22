package Exceptions;

public class InvalidValue extends Exception
{
    public InvalidValue() {}

    public InvalidValue(String message)
    {
        super(message);
    }

    public InvalidValue (Throwable cause) {
        super (cause);
    }

    public InvalidValue (String message, Throwable cause) {
        super (message, cause);
    }
}