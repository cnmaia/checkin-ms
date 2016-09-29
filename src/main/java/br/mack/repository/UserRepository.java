package br.mack.repository;

import br.mack.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by cmaia on 29/09/16
 */
public interface UserRepository extends MongoRepository<User, Long> {
}
