package com.example.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController {

  @Autowired
  private UserDaoService userDaoService;

  @GetMapping("/users")
  public List<User> retrieveAllUsers() {
    return userDaoService.findAll();
  }

  @GetMapping("/users/{id}")
  public User getUser(@PathVariable int id) {
    User returnedUser = userDaoService.findUser(id);
    if (returnedUser == null) {
      throw new UserNotFoundException("User with id " + id + " not found");
    }
    return returnedUser;
  }

  @PostMapping("/users")
  public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
    User savedUser = userDaoService.addUser(user);
    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
        .toUri();

    return ResponseEntity.created(location).build();
  }

  @DeleteMapping("/users/{id}")
  public void deleteUser(@PathVariable int id) {
    User deletedUser = userDaoService.deleteUserById(id);
    if (deletedUser == null) {
      throw new UserNotFoundException("User with id " + id + " not found");
    }
  }
}
