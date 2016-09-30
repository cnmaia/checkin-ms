package br.mack.controller;

import br.mack.controller.dto.ServerResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Created by cmaia on 30/09/16
 */
public class ResponseHelper {

    public static ResponseEntity ok() {
        ServerResponse response = new ServerResponse();
        response.setSuccess(true);
        return new ResponseEntity<ServerResponse>(HttpStatus.OK);
    }

    public static <T> ResponseEntity ok(T payload, HttpStatus status) {
        ServerResponse<T> response = new ServerResponse<T>();
        response.setPayload(payload);
        response.setSuccess(true);

        return new ResponseEntity<ServerResponse<T>>(response, status);
    }

    public static ResponseEntity fail(HttpStatus status) {
        ServerResponse response = new ServerResponse();
        response.setSuccess(false);
        return new ResponseEntity<ServerResponse>(HttpStatus.OK);
    }

    public static <T> ResponseEntity fail(T payload, HttpStatus status) {
        ServerResponse<T> response = new ServerResponse<T>();
        response.setPayload(payload);
        response.setSuccess(false);

        return new ResponseEntity<ServerResponse<T>>(response, status);
    }
}
