package com.example.workflow.mvc.repository;

import com.example.workflow.mvc.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ToppingRepository extends JpaRepository<Product, Integer> {

}
