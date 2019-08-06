package com.ssafy.bruteforce.service;

import java.util.List;

import com.ssafy.bruteforce.dto.Answer;
import com.ssafy.bruteforce.dto.Comment;
import com.ssafy.bruteforce.dto.Question;
import com.ssafy.bruteforce.repository.AnswerRepository;
import com.ssafy.bruteforce.repository.CommentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    private CommentRepository cRepo;
    @Autowired
    private AnswerRepository aRepo;

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
    public boolean closedUpdate(Question question) {
        return false;
    }

    @Override
    public List<Answer> findAnswerById(String writerUid) {
        return aRepo.findByWriterUid(writerUid);
    }


    @Override
    public boolean addAnswer(Answer answer) {
        try {
            aRepo.insert(answer);            
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean updateAnswer(Answer answer) {
        return false;
    }

    @Override
    public boolean deleteAnswer(String aid) {
        try {
            aRepo.deleteById("aid");
        } catch (Exception e) {
            return false;
        }
		return true;
    }

    @Override
    public List<Comment> findCommentById(String writerUid) {
        return cRepo.findByWriterUid(writerUid);
    }

    @Override
    public boolean addComment(Comment comment) {
        try {
            cRepo.insert(comment);            
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean updateComment(Comment comment) {
        try {
            cRepo.save(comment);            
        } catch (Exception e) {
            return false;
        }
        return true;
	}

	@Override
	public boolean deleteComment(String cid) {
        try {
            cRepo.deleteById("cid");
        } catch (Exception e) {
            return false;
        }
		return true;
	}
}