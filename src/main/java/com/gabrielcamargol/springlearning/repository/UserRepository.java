package com.gabrielcamargol.springlearning.repository;

import java.util.List;

import com.gabrielcamargol.springlearning.Model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends JpaRepository<User, Long> {
  
  @Query("SELECT u from User u where u.id > :id")
  public List<User> findAllMoreThan(@Param("id") Long id);

  // public List<User> findbyIdGreaterThan(Long id);
}
