package com.ssafy.bruteforce.controller;

import java.util.List;


import com.ssafy.bruteforce.dto.Comment;
import com.ssafy.bruteforce.dto.Answer;
import com.ssafy.bruteforce.dto.Question;
import com.ssafy.bruteforce.service.BoardService;
import com.ssafy.bruteforce.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.models.Response;

import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
public class BoardController{
    
    @Autowired
    private BoardService boardService;

    @GetMapping(value = "/findAllQuestions")
	public ResponseEntity<List<Question>> findAllQuestions() throws Exception {
        List<Question> userQnAInfo = boardService.findAllQuestions();
		if (userQnAInfo.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
        return new ResponseEntity<List<Question>>(userQnAInfo, HttpStatus.OK);
    }

    @GetMapping(value="/findQestionById/{qid}")
    public ResponseEntity<Question> findQestionById(@PathVariable String qid) throws Exception {
        Question question = boardService.findQestionById(qid);
		if (question==null) { 
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
        return new ResponseEntity<Question>(question, HttpStatus.OK);
    }
    
    @GetMapping(value="/findQuestionByTitle/{title}")
    public ResponseEntity<List<Question>> findQuestionByTitle(@PathVariable String title) throws Exception {
        List<Question> question = boardService.findQuestionByTitle(title);
		if (question.isEmpty()) { 
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
        return new ResponseEntity<List<Question>>(question, HttpStatus.OK);
    }

    @GetMapping(value="/findQuestionById/{writerUid}")
    public ResponseEntity<List<Question>> findWriterById(@PathVariable String writerUid) throws Exception {
        List<Question> question = boardService.findQuestionById(writerUid);
		if (question.isEmpty()) { 
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
        return new ResponseEntity<List<Question>>(question, HttpStatus.OK);
    }

    @GetMapping(value="/findQuestionByTag/{tag}")
    public ResponseEntity<List<Question>> findQuestionByTag(@PathVariable String[] tag) throws Exception {
        List<Question> question = boardService.findQuestionByTag(tag);
		if (question.isEmpty()) { 
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
        return new ResponseEntity<List<Question>>(question, HttpStatus.OK);
    }

    @PostMapping(value="/addQuestion")
    public ResponseEntity<String> addQuestion(Question question) throws Exception {
        boolean result = boardService.addQuestion(question);
		if (!result) { 
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
        return new ResponseEntity<String>("true", HttpStatus.OK);
    }

    @PutMapping(value="/updateQuestion")
    public ResponseEntity<String> updateQuestion(Question question) throws Exception{
        boolean result = boardService.updateQuestion(question);
        if(!result){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<String>("true",HttpStatus.OK);
    }

    @DeleteMapping(value="/deleteQuestion")
    public ResponseEntity<String> deleteQuestion(String qid) throws Exception{
        boolean result = boardService.deleteAnswer(qid);
        if(!result){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<String>("true",HttpStatus.OK);
    }

    @PutMapping(value="/cloedUpdate")
    public ResponseEntity<String> cloedUpdate(Question question,String aid) throws Exception{
        boolean result = boardService.closedUpdate(question, aid);
        if(!result){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<String>("true",HttpStatus.OK);
    }

    @GetMapping(value="/findAnswerById")
    public ResponseEntity<List<Answer>> findAnswerById(String writerUid) throws Exception{
        List<Answer> answers = boardService.findAnswerById(writerUid);
        if(answers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Answer>>(answers,HttpStatus.OK);
    }

    @PostMapping(value="/addAnswer")
    public ResponseEntity<String> addAnswer(Answer answer, String qid) throws Exception{
        boolean result = boardService.addAnswer(answer, qid);
        if(!result){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<String>("true",HttpStatus.OK);
    }

    @PutMapping(value="/updateAnswer")
    public ResponseEntity<String> updateAnswer(Answer answer, String qid) throws Exception{
        boolean result = boardService.updateAnswer(answer, qid);
        if(!result){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<String>("true",HttpStatus.OK);
    }

    @DeleteMapping(value="/deleteAnswer")
    public ResponseEntity<String> deleteAnswer(String aid, String qid) throws Exception{
        boolean result = boardService.deleteAnswer(aid, qid);
        if(!result){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<String>("true",HttpStatus.OK);
    }

    @GetMapping(value="/findCommentById")
    public ResponseEntity<List<Comment>> findCommentById(String writerUid,String qid) throws Exception{
        List<Comment> comments = boardService.findCommentById(writerUid, qid);
        if(comments.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Comment>>(comments,HttpStatus.OK);
    }

    @PostMapping(value="/addComment")
    public ResponseEntity<String> addComment(Comment comment, String qid) throws Exception{
        boolean result = boardService.addComment(comment, qid);
        if(!result){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<String>("true",HttpStatus.OK);
    }

    @PutMapping(value="/updateComment")
    public ResponseEntity<String> updateComment(Comment comment, String qid) throws Exception{
        boolean result = boardService.updateComment(comment, qid);
        if(!result){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<String>("true",HttpStatus.OK);
    }

    @DeleteMapping(value="/deleteComment")
    public ResponseEntity<String> deleteComment(String cid,String qid) throws Exception{
        boolean result = boardService.deleteAnswer(cid, qid);
        if(!result){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<String>("true",HttpStatus.OK);
    }
    
}