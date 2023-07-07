package com.packt.cardatabase.domain;

import java.util.List;
import javax.persistence.Column;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface CarRepository extends CrudRepository<Car, Long> {
  @Query("select c from Car c where c.brand = :brand")
  List<Car> findByBrand(@Param("brand") String brand);

  @Query("select c from Car c where c.brand like :brand")
  List<Car> findByBrandEndsWith(@Param("brand") String brand);
  List<Car> findByColor(String color);

  List<Car> findByMadeYear(int madeYear);

  List<Car> findByBrandAndModel(String brand, String model);

  List<Car> findByBrandOrColor(String brand, String color);

  List<Car> findByBrandOrderByMadeYearAsc(String brand);
}
