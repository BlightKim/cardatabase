package com.packt.cardatabase.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

@DataJpaTest
class OwnerRepositoryTest {
  @Autowired
  private OwnerRepository ownerRepository;

  @Test
  public void saveOwner() {
    ownerRepository.save(new Owner("Lucy", "Smith"));

    assertThat(ownerRepository.findByFirstName("Lucy").isPresent()).isTrue();
  }
}