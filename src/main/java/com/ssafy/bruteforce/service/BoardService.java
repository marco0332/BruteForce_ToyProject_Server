package com.ssafy.bruteforce.service;

import java.util.List;
import com.ssafy.bruteforce.dto.Question;

public interface BoardService {
	/** 모든 질문글 */
	public List<Question> findAllQuestions();
	
	/** qid로 상세 보기*/
	public Question findQestionById(String qid);
	
	/** 제목으로 찾기 */
	public List<Question> findQuestionByTitle(String title);
    
    /** 작성자로 찾기 */
	public List<Question> findQuestionByWriter(String writerUid);
    
    /** 태그로 찾기 */
	public List<Question> findQuestionByTag(String[] tag);
    
    /** 질문 등록 */
    public boolean addQuestion(Question question);
    
    /** 질문 수정 */
	public boolean updateQuestion(Question question);
	
	/** 질문 삭제 */
    public boolean deleteQuestion(int qid);


	
}
