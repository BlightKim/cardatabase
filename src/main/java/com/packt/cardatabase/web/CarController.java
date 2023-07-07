package com.packt.cardatabase.web;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CarController {
  private final CarRepository carRepository;
  @RequestMapping("/cars")
  public Iterable<Car> getCars() {
    return carRepository.findAll();
  }
}
