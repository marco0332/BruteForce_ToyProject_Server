package com.ssafy.bruteforce.service;

import java.util.List;

import com.ssafy.bruteforce.dto.Answer;
import com.ssafy.bruteforce.dto.Comment;
import com.ssafy.bruteforce.dto.Question;

public interface BoardService {
    /** 모든 질문글 */
    //완료
	public List<Question> findAllQuestions();
	
    /** qid로 상세 보기*/
    //완료
	public Question findQuestionById(String qid);
	
    /** 제목으로 찾기 */
    //완료
	public List<Question> findQuestionByTitle(String title);
    
    /** 태그로 찾기 */
	public List<Question> findQuestionByTag(String[] tag);
    
    /** 질문 등록 */
    //완료
    public boolean addQuestion(Question question);
    
    /** 질문 수정 */
	public boolean updateQuestion(Question question);
	
    /** 질문 삭제 */
    //완료
    public boolean deleteQuestion(String qid);
    
    /** 답변 채택 */
    public boolean closedUpdate(String qid, String aid);
    
    /** id로 답변 찾기 */
    public List<Answer> findAnswerById(String writerUid);

    /** 답변 등록 */
    //완료
    public boolean addAnswer(Answer answer, String qid);
    
    /** 답변 수정 */
	public boolean updateAnswer(Answer answer);
	
	/** 답변 삭제 */
    public boolean deleteAnswer(String aid, String qid);

    /** id로 댓글 찾기 */
    public List<Comment> findByWriterUid(String writerUid);

	/** 댓글 등록 */
    public boolean addComment(Comment comment, String aid);
    
    /** 댓글 수정 */
	public boolean updateComment(Comment comment);
	
	/** 댓글 삭제 */
    public boolean deleteComment(String cid);


}
