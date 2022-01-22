package com.example.workflow.mvc.repository;

import com.example.workflow.mvc.entity.UserPizzaTopping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPizzaToppingRepository extends JpaRepository<UserPizzaTopping, Integer> {

}
