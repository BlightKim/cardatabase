package com.packt.cardatabase.domain;

import static javax.persistence.CascadeType.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Owner {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long ownerId;

  private String firstName;

  private String lastName;

  @OneToMany(cascade = ALL, mappedBy = "owner")
  @JsonIgnore
  private List<Car> carList = new ArrayList<>();

  @ManyToMany(cascade = PERSIST)
  @JoinTable(name = "car_owner",
  joinColumns = {@JoinColumn(name = "ownerid") },
      inverseJoinColumns = {@JoinColumn(name = "id")}
  )
  private Set<Car> cars = new HashSet<Car>();
  public Owner() {
  }

  public Owner(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }
}
