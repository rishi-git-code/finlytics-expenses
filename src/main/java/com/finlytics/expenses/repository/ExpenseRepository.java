package com.finlytics.expenses.repository;

import com.finlytics.expenses.entity.ExpensesEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ExpenseRepository extends MongoRepository<ExpensesEntity, String> {
    List<ExpensesEntity> findByUserId(String userId);
}