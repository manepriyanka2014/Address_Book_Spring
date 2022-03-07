package com.bridgelabz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.entity.*;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
