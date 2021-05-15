package com.SpringBoot.Api.MessageBox.repositories;

import com.SpringBoot.Api.MessageBox.entites.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
}
