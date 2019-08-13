package com.ssafy.bruteforce.repository;

import java.util.List;

import com.ssafy.bruteforce.dto.Question;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("BoardRepository")
public interface BoardRepository extends MongoRepository<Question, String> {
    @Query(value = "{'type':'question','title':?0}")
    public List<Question> findByTitle(String title);
    public List<Question> findByTag(int[] tag);
    public List<Question> findByType(String type);
}