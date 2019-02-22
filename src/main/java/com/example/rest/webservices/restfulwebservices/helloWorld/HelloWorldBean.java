package com.example.rest.webservices.restfulwebservices.helloWorld;

public class HelloWorldBean {
  private String message;

  public HelloWorldBean(String message){
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(final String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return "HelloWorldBean{" + "message='" + message + '\'' + '}';
  }
}
