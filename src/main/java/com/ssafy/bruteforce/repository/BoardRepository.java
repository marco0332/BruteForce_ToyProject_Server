package com.ssafy.bruteforce.repository;

import java.util.List;

import com.ssafy.bruteforce.dto.Question;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository("BoardRepository")
public interface BoardRepository extends MongoRepository<Question, String> {
    public List<Question> findByTitle(String title);
    public List<Question> findByTag(String[] tag);
}