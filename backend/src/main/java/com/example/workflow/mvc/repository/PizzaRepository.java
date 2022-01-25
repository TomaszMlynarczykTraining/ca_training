package com.example.workflow.mvc.repository;

import com.example.workflow.mvc.entity.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Integer> {
    List<Pizza> findByName(String name);
}
