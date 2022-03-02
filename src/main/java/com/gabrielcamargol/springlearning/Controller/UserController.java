package com.gabrielcamargol.springlearning.Controller;

import java.util.List;
import java.util.Optional;

import com.gabrielcamargol.springlearning.Model.User;
import com.gabrielcamargol.springlearning.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
  
  @Autowired
  private UserRepository userRepository;

  @GetMapping("/{id}")
  public User user(@PathVariable Long id) {
    Optional<User> userFind = this.userRepository.findById(id);
   
    if (userFind.isPresent()) {
      return userFind.get();
    }
   
    return null;
  }  

  @PostMapping("/")
  public User user(@RequestBody User user) {
    return this.userRepository.save(user);
  }

  @GetMapping("/list")
  public List<User> list() {
    return this.userRepository.findAll();
  }

  @GetMapping("/list/{id}")
  public List<User> listMoreThan(@PathVariable("id") Long id) {
    return this.userRepository.findAllMoreThan(id);
  }
}
