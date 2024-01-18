package com.gustavo.workshop.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gustavo.workshop.domain.Post;
import com.gustavo.workshop.domain.User;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
