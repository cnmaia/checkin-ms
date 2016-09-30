package br.mack.controller.dto;

import java.io.Serializable;

/**
 * Created by cmaia on 30/09/16
 */
public class ServerResponse <T> implements Serializable {
    private static final long serialVersionUID = 4260895451552710208L;

    private T payload;
    private boolean success;

    public ServerResponse() {}

    public ServerResponse(T payload) {
        this.payload = payload;
    }

    public ServerResponse(T payload, boolean success) {
        this.payload = payload;
        this.success = success;
    }

    public T getPayload() {
        return payload;
    }

    public ServerResponse setPayload(T payload) {
        this.payload = payload;
        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public ServerResponse setSuccess(boolean success) {
        this.success = success;
        return this;
    }
}
