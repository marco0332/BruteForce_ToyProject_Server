package com.ssafy.bruteforce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import com.ssafy.bruteforce.dto.Answer;
import com.ssafy.bruteforce.dto.Comment;
import com.ssafy.bruteforce.dto.Question;
import com.ssafy.bruteforce.dto.ResultJson;
import com.ssafy.bruteforce.repository.AnswerRepository;
import com.ssafy.bruteforce.repository.BoardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository boardDao;

    @Autowired
    private AnswerRepository answerDao;

    @Override
    public ResultJson findAllQuestions() {
        ResultJson resultJson = new ResultJson();
        try {
            resultJson.setContents(boardDao.findByType("question"));
        } catch (NoSuchElementException e) {
            resultJson.setStateFail();
            resultJson.setMessage("No Such Element");
            resultJson.setContents(false);
        } catch (Exception e) {
            resultJson.setStateUnconnect();
            resultJson.setMessage("Server Error");
        }
        return resultJson;
    }

    @Override
    public ResultJson findQuestionByTitle(String title) {
        ResultJson resultJson = new ResultJson();
        try {
            resultJson.setContents(boardDao.findByTitle(title));
        } catch (NoSuchElementException e) {
            resultJson.setStateFail();
            resultJson.setMessage("No Such Element");
            resultJson.setContents(false);
        } catch (Exception e) {
            resultJson.setStateUnconnect();
            resultJson.setMessage("Server Error");
        }
        return resultJson;
    }

    @Override
    public ResultJson findByQid(String qid) {
        ResultJson resultJson = new ResultJson();
        try {
            List<Object> objlist = new ArrayList<>();
            objlist.add(boardDao.findById(qid).get());
            objlist.add(answerDao.findByQid(qid));
            resultJson.setContents(objlist);
        } catch (NoSuchElementException e) {
            resultJson.setStateFail();
            resultJson.setMessage("No Such Element");
            resultJson.setContents(false);
        } catch (Exception e) {
            resultJson.setStateUnconnect();
            resultJson.setMessage("Server Error");
        }
        return resultJson;
    }

    @Override
    public ResultJson findQuestionByTag(int[] tag, int size) {
        ResultJson resultJson = new ResultJson();
        List<Question> list = boardDao.findByType("question");
        List<Question> returnList = new ArrayList<>();
        for(Question q : list){
            int equalCnt = 0;
            for(int i=0; i<q.getTag().length; i++){
                if(tag[q.tag[i]]==1){
                    equalCnt++;
                }
            }
            if(equalCnt==size){
                returnList.add(q);
            }
        }
        if(returnList.isEmpty()){
            resultJson.setStateFail();
            resultJson.setMessage("태그가 존재하지 않습니다.");
        }else{
            resultJson.setContents(returnList);
        }
        return resultJson;
    }

    @Override
    public ResultJson addQuestion(Question question) {
        ResultJson resultJson = new ResultJson();
        try {
            boardDao.insert(question);
            resultJson.setContents(true);
        } catch (Exception e) {
            resultJson.setContents(false);
            resultJson.setStateUnconnect();
            resultJson.setMessage("Server Error");
        }
        return resultJson;
    }

    @Override
    public ResultJson updateQuestion(String qid, String title, String contents, int[] tag){
        ResultJson resultJson = new ResultJson();
        try {
            Question getQ = boardDao.findById(qid).get();
            if(getQ.isbClosed()){
                resultJson.setStateFail();
                resultJson.setMessage("답변이 채택되어 수정할 수 없습니다.");
                resultJson.setContents(false);
            }else{
                getQ.setTitle(title);
                getQ.setTag(tag);
                getQ.setContents(getQ.getContents()+"\n"+contents);
                boardDao.save(getQ);
                resultJson.setContents(true);
            }
        } catch (Exception e) {
            resultJson.setStateUnconnect();
            resultJson.setMessage("Server Error");
        }
        return resultJson;
    }

    @Override
    public ResultJson deleteQuestion(String qid) {
        ResultJson resultJson = new ResultJson();
        try {
            boolean bcheckClosed = boardDao.findById(qid).get().isbClosed();
            if(bcheckClosed){
                resultJson.setStateFail();
                resultJson.setMessage("답변이 채택되었기 때문에 삭제가 불가능합니다.");
                resultJson.setContents(false);
            }else{
                boardDao.deleteById(qid);
                answerDao.deleteByQid(qid);
                resultJson.setContents(true);
            }
        } catch (Exception e) {
            resultJson.setStateUnconnect();
            resultJson.setMessage("Server Error");
        }
        return resultJson;
    }

    @Override
    public ResultJson addAnswer(Answer answer) {
        ResultJson resultJson = new ResultJson();
        try {
            answerDao.insert(answer);
            resultJson.setContents(true);
        } catch (Exception e) {
            resultJson.setContents(false);
            resultJson.setStateUnconnect();
            resultJson.setMessage("Server Error");
        }
        return resultJson;
    }

    @Override
    public ResultJson updateAnswer(String aid, String contents) {
        ResultJson resultJson = new ResultJson();
        try {
            Answer getA = answerDao.findById(aid).get();
            if(getA.isbSelection()){
              resultJson.setStateFail();
              resultJson.setMessage("답변이 채택되어 수정이 불가능합니다.");  
              resultJson.setContents(false);
            }else{
                getA.setContents(getA.getContents()+"\n"+contents);
                answerDao.save(getA);
                resultJson.setContents(true);
            }
        } catch (Exception e) {
            resultJson.setStateUnconnect();
            resultJson.setMessage("Server Error");
        }
        return resultJson;
    }

    @Override
    public ResultJson deleteAnswer(String aid) {
        ResultJson resultJson = new ResultJson();
        try {
            if(answerDao.findById(aid).get().isbSelection()){
                resultJson.setStateFail();
                resultJson.setMessage("채택되었기 때문에 삭제 불가");
                resultJson.setContents(false);
            }else{
                answerDao.deleteById(aid);
                resultJson.setContents(true);
            }
        } catch(Exception e){
            resultJson.setStateUnconnect();
            resultJson.setMessage("Server Error");
        }
        return resultJson;
    }

    @Override
    public ResultJson closedUpdate(String qid, String aid) {
        ResultJson resultJson = new ResultJson();
        try {
            Question getQ = boardDao.findById(qid).get();
            getQ.setbClosed(true);
            boardDao.save(getQ);
            Answer getA = answerDao.findById(aid).get();
            getA.setbSelection(true);
            answerDao.save(getA);
            resultJson.setContents(true);
        } catch(Exception e){
            resultJson.setStateUnconnect();
            resultJson.setMessage("Server Error");
        }
        return resultJson;
    }

    @Override
    public ResultJson addQuestionComment(String qid, Comment comment) {
        ResultJson resultJson = new ResultJson();
        try {            
            Question getQ = boardDao.findById(qid).get();
            getQ.comments.add(comment);
            boardDao.save(getQ);
            resultJson.setContents(true);
        } catch(Exception e){
            resultJson.setStateUnconnect();
            resultJson.setMessage("Server Error");
        }
        return resultJson;
    }

    @Override
    public ResultJson addAnswerComment(String aid, Comment comment) {
        ResultJson resultJson = new ResultJson();
        try {            
            Answer getAns = answerDao.findById(aid).get();
            getAns.comments.add(comment);
            answerDao.save(getAns);
            resultJson.setContents(true);
        } catch(Exception e){
            resultJson.setStateUnconnect();
            resultJson.setMessage("Server Error");
        }
        return resultJson;
    }

    @Override
    public ResultJson updateQuestionComment(String qid, String cid, String contents) {
        ResultJson resultJson = new ResultJson();
        try {
            Question getQ = boardDao.findById(qid).get();
            for (Comment comment : getQ.comments) {
                if (comment.cid.equals(cid)) {
                    comment.setContents(contents);
                    break;
                }
            }
            boardDao.save(getQ);
            resultJson.setContents(true);
        } catch(Exception e){
            resultJson.setStateUnconnect();
            resultJson.setMessage("Server Error");
        }
        return resultJson;
    }

    @Override
    public ResultJson updateAnswerComment(String aid, String cid, String contents) {
        ResultJson resultJson = new ResultJson();
        try {
            Answer getA = answerDao.findById(aid).get();
            for (Comment comment : getA.comments) {
                if (comment.cid.equals(cid)) {
                    comment.setContents(contents);
                    break;
                }
            }
            answerDao.save(getA);
            resultJson.setContents(true);
        } catch(Exception e){
            resultJson.setStateUnconnect();
            resultJson.setMessage("Server Error");
        }
        return resultJson;
    }

    @Override
    public ResultJson deleteQuestionComment(String qid, String cid) {
        ResultJson resultJson = new ResultJson();
        try {
            Question getQ = boardDao.findById(qid).get();
            for (Comment comment : getQ.comments) {
                if (comment.cid.equals(cid)) {
                    getQ.comments.remove(comment);
                    break;
                }
            }
            boardDao.save(getQ);
            resultJson.setContents(true);
        } catch(Exception e){
            resultJson.setStateUnconnect();
            resultJson.setMessage("Server Error");
        }
        return resultJson;
    }

    @Override
    public ResultJson deleteAnswerComment(String aid, String cid) {
        ResultJson resultJson = new ResultJson();
        try {
            Answer getA = answerDao.findById(aid).get();
            for (Comment comment : getA.comments) {
                if (comment.cid.equals(cid)) {
                    getA.comments.remove(comment);
                    break;
                }
            }
            answerDao.save(getA);
            resultJson.setContents(true);
        } catch(Exception e){
            resultJson.setStateUnconnect();
            resultJson.setMessage("Server Error");
        }
        return resultJson;
    }
}