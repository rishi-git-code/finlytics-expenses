package com.finlytics.expenses.repository;

import com.finlytics.expenses.entity.IncomeExpensesEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IncomeExpenseRepository extends MongoRepository<IncomeExpensesEntity, String> {
    List<IncomeExpensesEntity> findByUserId(String userId);
}