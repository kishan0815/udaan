package com.example.udaan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.udaan.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
