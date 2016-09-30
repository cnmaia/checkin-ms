package br.mack.controller.dto;

import java.io.Serializable;

/**
 * Created by cmaia on 30/09/16
 */
public class UserRequest implements Serializable {
    private static final long serialVersionUID = -1160053141841239158L;

    private String name;
    private String email;

    public String getName() {
        return name;
    }

    public UserRequest setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRequest setEmail(String email) {
        this.email = email;
        return this;
    }
}
