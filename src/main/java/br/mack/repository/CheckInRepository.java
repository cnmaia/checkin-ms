package br.mack.repository;

import br.mack.model.CheckIn;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by cmaia on 29/09/16.
 */
public interface CheckInRepository extends JpaRepository<CheckIn, Long> {
}
