package br.mack.exception;

/**
 * Created by cmaia on 29/09/16
 */
public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -1703795648885398591L;

    public ResourceNotFoundException() { super(); }

    public ResourceNotFoundException(String message) { super(message); }

    public ResourceNotFoundException(String message, Throwable cause) { super(message, cause); }
}
