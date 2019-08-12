package com.ssafy.bruteforce.controller;

import com.ssafy.bruteforce.dto.Comment;
import com.ssafy.bruteforce.dto.Answer;
import com.ssafy.bruteforce.dto.Question;
import com.ssafy.bruteforce.dto.ResultJson;
import com.ssafy.bruteforce.service.BoardService;

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

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api")
public class BoardController{
    
    // @Autowired
    // private BoardService boardService;

    // @ApiOperation(value = "모든 질문 가져오기")
    // @GetMapping(value = "/findAllQuestions")
	// public ResponseEntity<ResultJson> findAllQuestions() {
    //     ResultJson resultJson = boardService.findAllQuestions();
    //     return responseFunction(resultJson);
    // }

    // @ApiOperation(value = "질문ID로 상세보기")
    // @GetMapping(value="/findQuestionById/{qid}")
    // public ResponseEntity<ResultJson> findQuestionById(@PathVariable String qid)  {
    //     ResultJson resultJson = boardService.findQuestionById(qid);
    //     return responseFunction(resultJson);
    // }
    
    // @ApiOperation(value = "제목으로 질문 찾기")
    // @GetMapping(value="/findQuestionByTitle/{title}")
    // public ResponseEntity<ResultJson> findQuestionByTitle(@PathVariable String title)  {
    //     ResultJson resultJson = boardService.findQuestionByTitle(title);
    //     return responseFunction(resultJson);
    // }

    // @ApiOperation(value = "태그로 찾아보기")
    // @GetMapping(value="/findQuestionByTag/{tag}")
    // public ResponseEntity<ResultJson> findQuestionByTag(@PathVariable String[] tag)  {
    //     ResultJson resultJson = boardService.findQuestionByTag(tag);
    //     return responseFunction(resultJson);
    // }

    // @ApiOperation(value = "질문 등록")
    // @PostMapping(value="/addQuestion")
    // public ResponseEntity<ResultJson> addQuestion(Question question)  {
    //     ResultJson resultJson = boardService.addQuestion(question);
    //     return responseFunction(resultJson);
    // }

    // @ApiOperation(value = "질문 수정")
    // @PutMapping(value="/updateQuestion")
    // public ResponseEntity<ResultJson> updateQuestion(Question question) {
    //     ResultJson resultJson = boardService.updateQuestion(question);
    //     return responseFunction(resultJson);
    // }

    // @ApiOperation(value = "질문 삭제")
    // @DeleteMapping(value="/deleteQuestion")
    // public ResponseEntity<ResultJson> deleteQuestion(String qid) {
    //     ResultJson resultJson = boardService.deleteQuestion(qid);
    //     return responseFunction(resultJson);
    // }

    // @ApiOperation(value = "답변 채택")
    // @PutMapping(value="/closedUpdate")
    // public ResponseEntity<ResultJson> closedUpdate(String qid, String aid) {
    //     ResultJson resultJson = boardService.closedUpdate(qid,aid);
    //     return responseFunction(resultJson);
    // }

    // @ApiOperation(value = "답변 등록")
    // @PostMapping(value="/addAnswer")
    // public ResponseEntity<ResultJson> addAnswer(String qid, Answer answer) {
    //     ResultJson resultJson = boardService.addAnswer(qid,answer);
    //     return responseFunction(resultJson);
    // }

    // @ApiOperation(value = "답변 수정")
    // @PutMapping(value="/updateAnswer")
    // public ResponseEntity<ResultJson> updateAnswer(String qid, String aid, String contents) {
    //     ResultJson resultJson = boardService.updateAnswer(qid,aid,contents);
    //     return responseFunction(resultJson);
    // }

    // @ApiOperation(value = "답변 삭제")
    // @DeleteMapping(value="/deleteAnswer")
    // public ResponseEntity<ResultJson> deleteAnswer(String qid, String aid) {
    //     ResultJson resultJson = boardService.deleteAnswer(qid,aid);
    //     return responseFunction(resultJson);
    // }

    // @ApiOperation(value = "질문 댓글 등록")
    // @PostMapping(value="/addQuestionComment")
    // public ResponseEntity<ResultJson> addQuestionComment(String qid, Comment comment) {
    //     ResultJson resultJson = boardService.addQuestionComment(qid,comment);
    //     return responseFunction(resultJson);
    // }

    // @ApiOperation(value = "답변 댓글 등록")
    // @PostMapping(value="/addAnswerComment")
    // public ResponseEntity<ResultJson> addAnswerComment(String qid, String aid, Comment comment) {
    //     ResultJson resultJson = boardService.addAnswerComment(qid,aid,comment);
    //     return responseFunction(resultJson);
    // }

    // @ApiOperation(value = "질문 댓글 수정")
    // @PutMapping(value="/updateQuestionComment")
    // public ResponseEntity<ResultJson> updateQuestionComment(String qid, String cid, String contents) {
    //     ResultJson resultJson = boardService.updateQuestionComment(qid,cid,contents);
    //     return responseFunction(resultJson);
    // }

    // @ApiOperation(value = "답변 댓글 수정")
    // @PutMapping(value="/updateAnswerComment")
    // public ResponseEntity<ResultJson> updateAnswerComment(String qid, String aid, String cid, String contents) {
    //     ResultJson resultJson = boardService.updateAnswerComment(qid,aid,cid,contents);
    //     return responseFunction(resultJson);
    // }

    // @ApiOperation(value = "질문 댓글 삭제")
    // @DeleteMapping(value="/deleteQuestionComment")
    // public ResponseEntity<ResultJson> deleteQuestionComment(String qid, String cid) {
    //     ResultJson resultJson = boardService.deleteQuestionComment(qid,cid);
    //     return responseFunction(resultJson);
    // }

    // @ApiOperation(value = "답변 댓글 삭제")
    // @DeleteMapping(value="/deleteAnswerComment")
    // public ResponseEntity<ResultJson> deleteAnswerComment(String qid, String aid, String cid) {
    //     ResultJson resultJson = boardService.deleteAnswerComment(qid,aid,cid);
    //     return responseFunction(resultJson);
    // }

    // private ResponseEntity<ResultJson> responseFunction(ResultJson resultJson) {
	// 	switch(resultJson.getState()){
	// 		case "fail":
	// 			return new ResponseEntity<ResultJson>(resultJson,HttpStatus.NO_CONTENT);
	// 		case "unconnect":
	// 			return new ResponseEntity<ResultJson>(resultJson,HttpStatus.INTERNAL_SERVER_ERROR);
	// 		default:
	// 			return new ResponseEntity<ResultJson>(resultJson,HttpStatus.OK);
	// 	}
	// }
    
}