package br.mack.exception;

/**
 * Created by cmaia on 10/10/16
 */
public class IntegrationException extends RuntimeException {
    private static final long serialVersionUID = 4913664658515039065L;

    public IntegrationException (String message) {
        super(message);
    }

    public IntegrationException(String message, Throwable cause) {
        super(message, cause);
    }
}
