package com.ssafy.bruteforce.repository;
import com.ssafy.bruteforce.dto.Question;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository("QuestionRepository")
public interface QuestionRepository extends MongoRepository<Question, String> {

}