package com.ssafy.bruteforce.service;

import java.util.List;
import java.util.Optional;

import com.ssafy.bruteforce.dto.Answer;
import com.ssafy.bruteforce.dto.Comment;
import com.ssafy.bruteforce.dto.Question;
import com.ssafy.bruteforce.repository.AnswerRepository;
import com.ssafy.bruteforce.repository.CommentRepository;
import com.ssafy.bruteforce.repository.QuestionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    private QuestionRepository questionRepo;
    @Autowired
    private AnswerRepository answerRepo;
    @Autowired
    private CommentRepository commentRepo;

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
    public boolean closedUpdate(String qid, String aid) {
        Optional<Question> optionalQ = questionRepo.findById(qid);
        Question newQ = optionalQ.get();
        newQ.setbClosed(true);
        

        
        return false;
    }

    @Override
    public List<Answer> findAnswerById(String writerUid) {
        return answerRepo.findByWriterUid(writerUid);
    }


    @Override
    public boolean addAnswer(Answer answer) {
        try {
            answerRepo.insert(answer);            
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean updateAnswer(Answer answer) {
        try {
            answerRepo.save(answer);
        } catch (Exception e) {
            return false;
        }
		return true;
    }

    @Override
    public boolean deleteAnswer(String aid) {
        try {
            answerRepo.deleteById("aid");
        } catch (Exception e) {
            return false;
        }
		return true;
    }

    @Override
    public List<Comment> findByWriterUid(String writerUid) {
        return commentRepo.findByWriterUid(writerUid);
    }

    @Override
    public boolean addComment(Comment comment) {
        try {
            commentRepo.insert(comment);            
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean updateComment(Comment comment) {
        try {
            commentRepo.save(comment);            
        } catch (Exception e) {
            return false;
        }
        return true;
	}

	@Override
	public boolean deleteComment(String cid) {
        try {
            commentRepo.deleteById("cid");
        } catch (Exception e) {
            return false;
        }
		return true;
	}
}