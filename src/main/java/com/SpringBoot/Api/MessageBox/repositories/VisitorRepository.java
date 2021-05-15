package com.SpringBoot.Api.MessageBox.repositories;

import com.SpringBoot.Api.MessageBox.entites.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitorRepository extends JpaRepository<Visitor,Long> {
}
