package com.example.mongodb.repository;

import com.example.mongodb.models.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface ExpenseRepository extends MongoRepository<Expense, String> {
    /**
     * Query means name ?0 -> zeroth param, ?1 -> first param
     */
    @Query("{'name' :  ?0}")
    Optional<Expense> findByName(String name);
}
