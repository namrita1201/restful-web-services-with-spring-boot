package com.example.rest.webservices.restfulwebservices.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class User {

  private Integer id;
  @Size(min=2,message = "Name should be atleast 2 characters long")
  private String name;
  @Past
  private Date birthDate;

  public User(){}

  public User(final Integer id, final String name, final Date birthDate) {
    this.id = id;
    this.name = name;
    this.birthDate = birthDate;
  }

  public Integer getId() {
    return id;
  }

  public void setId(final Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(final Date birthDate) {
    this.birthDate = birthDate;
  }

  @Override
  public String toString() {
    return "User{" + "id=" + id + ", name='" + name + '\'' + ", birthDate=" + birthDate + '}';
  }
}
