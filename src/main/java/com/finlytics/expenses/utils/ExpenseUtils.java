package com.finlytics.expenses.utils;

import com.finlytics.expenses.entity.UserReference;
import com.finlytics.expenses.repository.UserReferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ExpenseUtils {

    @Autowired
    private UserReferenceRepository userReferenceRepository;

    public boolean isValidUser(String userId){
        Optional<UserReference> user = userReferenceRepository.findById(userId);
        return user.isPresent();
    }
}
