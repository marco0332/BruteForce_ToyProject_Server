package com.ssafy.bruteforce.service;

import java.util.List;

import com.ssafy.bruteforce.dto.Answer;
import com.ssafy.bruteforce.dto.Comment;
import com.ssafy.bruteforce.dto.Question;

import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

    @Override
    public List<Question> findAllQuestions() {
        return null;
    }

    @Override
    public Question findQestionById(String qid) {
        return null;
    }

    @Override
    public List<Question> findQuestionByTitle(String title) {
        return null;
    }

    @Override
    public List<Question> findQuestionById(String writerUid) {
        return null;
    }

    @Override
    public List<Question> findQuestionByTag(String[] tag) {
        return null;
    }

    @Override
    public boolean addQuestion(Question question) {
        return false;
    }

    @Override
    public boolean updateQuestion(Question question) {
        return false;
    }

    @Override
    public boolean deleteQuestion(String qid) {
        return false;
    }

    @Override
    public boolean closedUpdate(Question question, String aid) {
        return false;
    }

    @Override
    public List<Answer> findAnswerById(String writerUid) {
        return null;
    }


    @Override
    public boolean addAnswer(Answer answer) {
        return false;
    }

    @Override
    public boolean updateAnswer(Answer answer) {
        return false;
    }

    @Override
    public boolean deleteAnswer(String aid) {
        return false;
    }

    @Override
    public List<Comment> findCommentById(String writerUid) {
        return null;
    }

    @Override
    public boolean addComment(Comment comment) {
        return false;
    }

    @Override
    public boolean updateComment(Comment comment) {
        return false;
	}

	@Override
	public boolean deleteComment(String cid) {
		return false;
	}
}