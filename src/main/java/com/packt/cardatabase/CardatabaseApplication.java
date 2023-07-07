package com.packt.cardatabase;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepository;
import com.packt.cardatabase.domain.Owner;
import com.packt.cardatabase.domain.OwnerRepository;
import com.packt.cardatabase.domain.User;
import com.packt.cardatabase.domain.UserRepository;
import java.util.Arrays;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
public class CardatabaseApplication implements CommandLineRunner {
  private final UserRepository userRepository;
  private final CarRepository carRepository;
  private final OwnerRepository ownerRepository;

  public static void main(String[] args) {
    SpringApplication.run(CardatabaseApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    Owner owner1 = new Owner("John", "Johnson");
    Owner owner2 = new Owner("Mary", "Robinson");

    ownerRepository.saveAll(Arrays.asList(owner1, owner2));

    Car car1 = new Car("Ford", "Mustang", "Red", "ADF - 1121", 2021, 59000, owner1);
    Car car2 = new Car("Nissan", "Leaf", "White", "SSJ - 3002", 2019, 29000, owner2);
    Car car3 = new Car("Toyota", "Prius", "Silver", "KKO - 0212", 2020, 39000, owner2);

    carRepository.saveAll(Arrays.asList(car1, car2, car3));

    for(Car car : carRepository.findAll()) {
      log.info("brand={}, model={}", car.getBrand(), car.getModel());
    }
    userRepository.save(new User("user", "$2a$10$NVM0n8ElaRgg7zWO1CxUdei7vWoPg91Lz2aYavh9.f9q0e4bRadue","USER"));
    userRepository.save(new User("admin", "$2a$10$8cjz47bjbR4Mn8GMg9IZx.vyjhLXR/SKKMSZ9.mP9vpMu0ssKi8GW", "ADMIN"));
  }
}
