package br.mack.exception;

import java.util.Map;

/**
 * Created by cmaia on 29/09/16
 */
public class ValidationException extends RuntimeException {
    private static final long serialVersionUID = 5259441845882255226L;

    public ValidationException(Map<String, String> errors) { super(); }
}
