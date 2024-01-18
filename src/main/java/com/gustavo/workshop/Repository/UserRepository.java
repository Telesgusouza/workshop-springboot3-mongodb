package com.gustavo.workshop.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gustavo.workshop.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
