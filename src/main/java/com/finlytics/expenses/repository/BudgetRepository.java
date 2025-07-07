package com.finlytics.expenses.repository;

import com.finlytics.expenses.entity.BudgetEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BudgetRepository extends MongoRepository<BudgetEntity, String> {
    List<BudgetEntity> findByUserId(String userId);
}
