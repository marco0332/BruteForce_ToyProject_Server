package com.ssafy.bruteforce.service;

import javax.naming.spi.DirStateFactory.Result;

import com.ssafy.bruteforce.dto.Answer;
import com.ssafy.bruteforce.dto.Comment;
import com.ssafy.bruteforce.dto.Question;
import com.ssafy.bruteforce.dto.ResultJson;

public interface BoardService {    
    // /** 태그로 찾기 */
    // //완료
    // // public List<Question> findQuestionByTag(String[] tag);
    // public ResultJson findQuestionByTag(String[] tag);
    
    // /** 답변 채택 */
    // //완료
    // // public boolean closedUpdate(String qid, String aid);
    // public ResultJson closedUpdate(String qid, String aid);
    
    // /** 답변 수정 */
    // //완료
	// // public void updateAnswer(String qid, String aid, String contents);
	// public ResultJson updateAnswer(String qid, String aid, String contents);
	
    // /** 답변 삭제 */
    // //완료
    // // public void deleteAnswer(String qid, String aid);
    // public ResultJson deleteAnswer(String qid, String aid);

    // /** 질문 댓글 수정 */
    // //완료
    // // public void updateQuestionComment(String qid, String cid, String contents);
    // public ResultJson updateQuestionComment(String qid, String cid, String contents);
    
    // /** 답변 댓글 수정 */
    // //완료
    // // public void updateAnswerComment(String qid, String aid, String cid, String contents);
    // public ResultJson updateAnswerComment(String qid, String aid, String cid, String contents);
    
    // /** 질문 댓글 삭제 */
    // //완료
    // // public void deleteQuestionComment(String qid, String cid);
    // public ResultJson deleteQuestionComment(String qid, String cid);

    // /** 답변 댓글 삭제 */
    // //완료
    // // public void deleteAnswerComment(String qid, String aid, String cid);
    // public ResultJson deleteAnswerComment(String qid, String aid, String cid);
    
    /** 모든 질문글 */
    public ResultJson findAllQuestions();

    // /** 제목으로 찾기 */
    public ResultJson findQuestionByTitle(String title);

    /** 질문 등록 */
    public ResultJson addQuestion(Question question);

    /** 질문 수정 */
    public ResultJson updateQuestion(String qid, String title, String contents, String[] tag);

    /** 질문 삭제 */
    public ResultJson deleteQuestion(String qid);

    /** 답변 등록 */
    public ResultJson addAnswer(Answer answer);

    
    /** 질문에 댓글 등록 */
    public ResultJson addQuestionComment(String qid, Comment comment);
    /** 답변에 댓글 등록 */
    public ResultJson addAnswerComment(String aid, Comment comment);
    /** qid를 이용하여 해당 질문과 답변 리스트 반환 */
    public ResultJson findByQid(String qid);
}
