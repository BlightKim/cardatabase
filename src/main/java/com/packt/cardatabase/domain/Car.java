package com.packt.cardatabase.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
public class Car {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String brand;

  private String model;

  private String color;

  private String registerNumber;

  private Integer productPrice;

  private Integer madeYear;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "owner")
  private Owner owner;

  @ManyToMany(mappedBy = "cars")
  private Set<Owner> owners = new HashSet<Owner>();
  public Car() {
  }

  public Car(String brand, String model, String color, String registerNumber,
      Integer productPrice, Integer madeYear, Owner owner) {
    super();
    this.brand = brand;
    this.model = model;
    this.color = color;
    this.registerNumber = registerNumber;
    this.productPrice = productPrice;
    this.madeYear = madeYear;
    this.owner = owner;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getRegisterNumber() {
    return registerNumber;
  }

  public void setRegisterNumber(String registerNumber) {
    this.registerNumber = registerNumber;
  }

  public Integer getProductPrice() {
    return productPrice;
  }

  public void setProductPrice(Integer productPrice) {
    this.productPrice = productPrice;
  }

  public Integer getMadeYear() {
    return madeYear;
  }

  public void setMadeYear(Integer madeYear) {
    this.madeYear = madeYear;
  }

  public Owner getOwner() {
    return owner;
  }

  public void setOwner(Owner owner) {
    this.owner = owner;
    owner.getCars().add(this);
  }
}
