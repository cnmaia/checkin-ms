package br.mack.service.impl;

import br.mack.exception.ValidationException;
import br.mack.model.User;
import br.mack.repository.UserRepository;
import br.mack.service.UserService;
import org.apache.commons.validator.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cmaia on 30/09/16
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void create(User user) {
        validate(user);
        userRepository.save(user);
    }

    private void validate(User user) {
        Map<String, String> validationErrors = new HashMap<String, String>();

        if (user.getEmail() == null || user.getEmail().isEmpty() || !EmailValidator.getInstance().isValid(user.getEmail())) {
            validationErrors.put("email", "Email invalid.");
        }

        if(user.getName() == null || user.getEmail().isEmpty()) {
            validationErrors.put("name", "Name invalid.");
        }

        if (validationErrors.size() > 0) {
            throw new ValidationException(validationErrors);
        }
    }
}
