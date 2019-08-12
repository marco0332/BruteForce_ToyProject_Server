package com.ssafy.bruteforce.repository;

import java.util.List;

import com.ssafy.bruteforce.dto.Answer;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository("AnswerRepository")
public interface AnswerRepository extends MongoRepository<Answer, String> {
    List<Answer> findByQid(String qid);
    List<Answer> deleteByQid(String qid);
    
}