package com.ssafy.bruteforce.repository;

import java.util.List;

import com.ssafy.bruteforce.dto.Comment;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository("CommentRepository")
public interface CommentRepository extends MongoRepository<Comment, String> {
    public List<Comment> findByWriterUid(String writerUid);
}