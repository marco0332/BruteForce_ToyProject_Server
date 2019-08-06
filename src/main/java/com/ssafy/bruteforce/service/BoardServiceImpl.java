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
        return questionRepo.findAll();
    }

    @Override
    public Question findQuestionById(String qid) {
        return questionRepo.findById(qid).get();
    }

    @Override
    public List<Question> findQuestionByTitle(String title) {
        return questionRepo.findByTitle(title);
    }

    @Override
    public List<Question> findQuestionByTag(String[] tag) {
        return questionRepo.findByTag(tag);
    }

    @Override
    public boolean addQuestion(Question question) {
        try {
            questionRepo.insert(question);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean updateQuestion(Question question) {
        try {
            questionRepo.save(question);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteQuestion(String qid) {
        try {
            questionRepo.deleteById(qid);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean closedUpdate(String qid, String aid) {
        Question newQ = questionRepo.findById(qid).get();
        newQ.setbClosed(true);

        
        return false;
    }

    @Override
    public List<Answer> findAnswerById(String writerUid) {
        return null;
    }

    @Override
    public boolean addAnswer(Answer answer, String qid) {
        try {
            Question getQ = questionRepo.findById(qid).get();
            getQ.getAnswers().add(answer);
            questionRepo.save(getQ);
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
    public boolean deleteAnswer(String aid, String qid) {
        try {
            Question getQ = questionRepo.findById(qid).get();
            List<Answer> ansList = getQ.getAnswers();
            for(Answer ans:ansList){
                if(ans.aid.equals(aid)){
                    System.out.println(ans.toString());
                    getQ.getAnswers().remove(ans);
                }
            }        
                
            questionRepo.save(getQ);
        } catch (Exception e) {
            return false;
        }
		return true;
    }

    @Override
    public List<Comment> findByWriterUid(String writerUid) {
        return null;
    }

    @Override
    public boolean addComment(Comment comment, String aid) {
        try {
            Answer ans = answerRepo.findById(aid).get();
            ans.getComments().add(comment);
            answerRepo.save(ans);            
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