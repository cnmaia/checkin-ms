package br.mack.service;

import br.mack.controller.dto.UserRequest;
import br.mack.model.User;

import java.util.List;

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

    /**
     * List list.
     *
     * @return the list
     */
    List<User> list();
}
