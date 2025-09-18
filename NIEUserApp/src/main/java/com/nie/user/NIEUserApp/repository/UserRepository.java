package com.nie.user.NIEUserApp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.nie.user.NIEUserApp.models.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    
    // Find user by email
    User findByEmail(String email);

    // Find user by username
    User findByUserName(String userName);
}

