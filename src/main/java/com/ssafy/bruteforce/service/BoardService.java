package com.ssafy.bruteforce.service;

import com.ssafy.bruteforce.dto.Answer;
import com.ssafy.bruteforce.dto.Comment;
import com.ssafy.bruteforce.dto.Question;
import com.ssafy.bruteforce.dto.ResultJson;

public interface BoardService {
    /** 모든 질문글 */
    //완료
    // public List<Question> findAllQuestions();
    public ResultJson findAllQuestions();
	
    /** qid로 상세 보기*/
    //완료
    // public Question findQuestionById(String qid);
    public ResultJson findQuestionById(String qid);
	
    /** 제목으로 찾기 */
    //완료
    // public List<Question> findQuestionByTitle(String title);
    public ResultJson findQuestionByTitle(String title);
    
    /** 태그로 찾기 */
    //완료
    // public List<Question> findQuestionByTag(String[] tag);
    public ResultJson findQuestionByTag(String[] tag);
    
    /** 질문 등록 */
    //완료
    // public void addQuestion(Question question);
    public ResultJson addQuestion(Question question);
    
    /** 질문 수정 */
    //완료
	// public void updateQuestion(Question question);
    public ResultJson updateQuestion(Question question);
    
    /** 질문 삭제 */
    //완료
    // public void deleteQuestion(String qid);
    public ResultJson deleteQuestion(String qid);
    
    /** 답변 채택 */
    //완료
    // public boolean closedUpdate(String qid, String aid);
    public ResultJson closedUpdate(String qid, String aid);

    /** 답변 등록 */
    //완료
    // public void addAnswer(String qid, Answer answer);
    public ResultJson addAnswer(String qid, Answer answer);
    
    /** 답변 수정 */
    //완료
	// public void updateAnswer(String qid, String aid, String contents);
	public ResultJson updateAnswer(String qid, String aid, String contents);
	
    /** 답변 삭제 */
    //완료
    // public void deleteAnswer(String qid, String aid);
    public ResultJson deleteAnswer(String qid, String aid);
    
    /** 질문 댓글 등록 */
    //완료
    // public void addQuestionComment(String qid, Comment comment);
    public ResultJson addQuestionComment(String qid, Comment comment);

    /** 답변 댓글 등록 */
    //완료
    // public void addAnswerComment(String qid, String aid, Comment comment);
    public ResultJson addAnswerComment(String qid, String aid, Comment comment);

    /** 질문 댓글 수정 */
    //완료
    // public void updateQuestionComment(String qid, String cid, String contents);
    public ResultJson updateQuestionComment(String qid, String cid, String contents);
    
    /** 답변 댓글 수정 */
    //완료
    // public void updateAnswerComment(String qid, String aid, String cid, String contents);
    public ResultJson updateAnswerComment(String qid, String aid, String cid, String contents);
    
    /** 질문 댓글 삭제 */
    //완료
    // public void deleteQuestionComment(String qid, String cid);
    public ResultJson deleteQuestionComment(String qid, String cid);

    /** 답변 댓글 삭제 */
    //완료
    // public void deleteAnswerComment(String qid, String aid, String cid);
    public ResultJson deleteAnswerComment(String qid, String aid, String cid);


}
