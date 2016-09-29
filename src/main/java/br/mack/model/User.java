package br.mack.model;

import org.springframework.data.annotation.Id;

/**
 * Created by cmaia on 29/09/16
 */
public class User {
    @Id
    private final long id;
    private final String name;
    private final String email;

    public User(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
