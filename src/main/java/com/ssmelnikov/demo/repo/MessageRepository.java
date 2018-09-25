package com.ssmelnikov.demo.repo;

import com.ssmelnikov.demo.entity.Chat;
import com.ssmelnikov.demo.entity.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends MongoRepository<Message, String> {
   List <Message> findByChatld(String chatld);

}
