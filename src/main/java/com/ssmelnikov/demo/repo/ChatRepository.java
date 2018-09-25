package com.ssmelnikov.demo.repo;

import com.ssmelnikov.demo.entity.Chat;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Melnikov_S on 22.09.2017.
 */
@Repository
public interface ChatRepository extends MongoRepository<Chat, String> {
}
