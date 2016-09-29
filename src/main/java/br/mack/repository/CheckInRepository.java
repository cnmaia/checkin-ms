package br.mack.repository;

import br.mack.model.CheckIn;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by cmaia on 29/09/16.
 */
public interface CheckInRepository extends MongoRepository<CheckIn, Long> {
}
