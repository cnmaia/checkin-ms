package br.mack.service;

import br.mack.controller.dto.UserRequest;

/**
 * Created by cmaia on 30/09/16
 */
public interface UserService {

    /**
     * Create.
     *
     * @param user the user
     */
    void create(UserRequest user);
}
