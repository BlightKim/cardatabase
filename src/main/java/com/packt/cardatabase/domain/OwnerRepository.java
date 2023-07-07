package com.packt.cardatabase.domain;

import java.util.Optional;
import javax.persistence.Column;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
  Optional<Owner> findByFirstName(@Param("firstName") String firstName);
}
