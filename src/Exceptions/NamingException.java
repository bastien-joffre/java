package Exceptions;

public class NamingException extends Exception {
    public NamingException() {
        super("Le nom doit être écrit en lettres.");
    }
}