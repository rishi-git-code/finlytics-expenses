package com.finlytics.expenses.repository;

import com.finlytics.expenses.entity.UserReference;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReferenceRepository extends MongoRepository<UserReference, String> {
}
