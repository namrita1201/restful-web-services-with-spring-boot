package com.example.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

  private static List<User> users = new ArrayList<>();
  private static int userCount = 3;

  static {
    users.add(new User(1, "Anvi", new Date()));
    users.add(new User(2, "Anshul", new Date()));
    users.add(new User(3, "Namrita", new Date()));
  }

  public List<User> findAll() {
    return users;
  }

  public User addUser(User user) {
    if (user.getId() == null) {
      user.setId(++userCount);
    }
    users.add(user);
    return user;
  }

  public User findUser(int id) {
    return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
  }

  public User deleteUserById(int id) {
    final Iterator<User> userIterator = users.iterator();
    while (userIterator.hasNext()) {
      User user = userIterator.next();
      if (user.getId().equals(id)) {
        users.remove(user);
        return user;
      }
    }
    return null;
  }

}
