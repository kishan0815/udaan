package com.example.udaan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.udaan.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
