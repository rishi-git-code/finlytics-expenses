package com.finlytics.expenses.services;

import com.finlytics.expenses.dto.UserReqDTO;
import com.finlytics.expenses.entity.UserReference;
import com.finlytics.expenses.repository.UserReferenceRepository;
import org.bson.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class UserReferenceService {

    @Autowired
    private UserReferenceRepository userReferenceRepository;

    public void handleCreateUser(UserReqDTO event){
        UserReference user = new UserReference();
        user.setUserId(event.getUserId());
        user.setUsername(event.getUsername());
        user.setEmail(event.getEmail());
        user.setStatus(event.getStatus());
        userReferenceRepository.save(user);
    }

    public void handleUpdateUser(UserReqDTO event) {
        userReferenceRepository.findById(event.getUserId()).ifPresent(user -> {
            user.setEmail(event.getEmail());
            user.setUsername(event.getUsername());
            userReferenceRepository.save(user);
        });
    }
}
