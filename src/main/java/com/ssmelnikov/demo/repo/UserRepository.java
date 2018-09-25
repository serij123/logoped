package com.ssmelnikov.demo.repo;

import com.ssmelnikov.demo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findByLogin(String login);
    User findByLoginAndPassword(String login, String password);
}
