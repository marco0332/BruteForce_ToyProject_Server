package com.ssafy.bruteforce.service;

import com.ssafy.bruteforce.dto.Answer;
import com.ssafy.bruteforce.dto.Comment;
import com.ssafy.bruteforce.dto.Question;
import com.ssafy.bruteforce.dto.ResultJson;

public interface BoardService {        
    /** 모든 질문글 */
    public ResultJson findAllQuestions();

    // /** 제목으로 찾기 */
    public ResultJson findQuestionByTitle(String title);

    /** qid를 이용하여 해당 질문과 답변 리스트 반환 */
    public ResultJson findByQid(String qid);
    
    /** 태그로 찾기 */
    public ResultJson findQuestionByTag(int[] tag, int size);

    /** 질문 등록 */
    public ResultJson addQuestion(Question question);

    /** 질문 수정 */
    public ResultJson updateQuestion(String qid, String title, String contents, int[] tag);

    /** 질문 삭제 */
    public ResultJson deleteQuestion(String qid);

    /** 답변 등록 */
    public ResultJson addAnswer(Answer answer);

    /** 답변 수정 */
    public ResultJson updateAnswer(String aid, String contents);
    
    /** 답변 삭제 */
    public ResultJson deleteAnswer(String aid);
        
    /** 답변 채택 */
    public ResultJson closedUpdate(String qid, String aid);
	
    /** 질문에 댓글 등록 */
    public ResultJson addQuestionComment(String qid, Comment comment);

    /** 답변에 댓글 등록 */
    public ResultJson addAnswerComment(String aid, Comment comment);    
    
    /** 질문 댓글 수정 */
    public ResultJson updateQuestionComment(String qid, String cid, String contents);
    
    /** 답변 댓글 수정 */
    public ResultJson updateAnswerComment(String aid, String cid, String contents);
    
    /** 질문 댓글 삭제 */
    public ResultJson deleteQuestionComment(String qid, String cid);

    /** 답변 댓글 삭제 */
    public ResultJson deleteAnswerComment(String aid, String cid);

}
