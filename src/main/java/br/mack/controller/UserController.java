package br.mack.controller;

import br.mack.controller.dto.UserRequest;
import br.mack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cmaia on 30/09/16
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    public ResponseEntity createUser(@RequestBody UserRequest user) {
        userService.create(user);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public ResponseEntity listAllUsers() {
        return new ResponseEntity(userService.list(), HttpStatus.OK);
    }
}
