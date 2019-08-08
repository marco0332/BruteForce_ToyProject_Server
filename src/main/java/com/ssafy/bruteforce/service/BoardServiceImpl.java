package com.ssafy.bruteforce.service;

import java.util.NoSuchElementException;

import com.ssafy.bruteforce.dto.Answer;
import com.ssafy.bruteforce.dto.Comment;
import com.ssafy.bruteforce.dto.Question;
import com.ssafy.bruteforce.dto.ResultJson;
import com.ssafy.bruteforce.repository.BoardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository boardDao;

    @Override
    public ResultJson findAllQuestions() {
        ResultJson resultJson = new ResultJson();
        try {
            resultJson.setContents(boardDao.findAll());
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
    public ResultJson findQuestionById(String qid) {
        ResultJson resultJson = new ResultJson();
        try {
            resultJson.setContents(boardDao.findById(qid).get());
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
    public ResultJson findQuestionByTag(String[] tag) {
        ResultJson resultJson = new ResultJson();
        try {
            resultJson.setContents(boardDao.findByTag(tag));
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
    public ResultJson addQuestion(Question question) {
        ResultJson resultJson = new ResultJson();
        try {
            boardDao.insert(question);
            resultJson.setContents(true);
        } catch (Exception e) {
            resultJson.setStateUnconnect();
            resultJson.setMessage("Server Error");
        }
        return resultJson;
    }

    @Override
    public ResultJson updateQuestion(Question question) {
        ResultJson resultJson = new ResultJson();
        try {
            boardDao.save(question);
            resultJson.setContents(true);
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
                resultJson.setMessage("채택되었기 때문에 삭제 불가");
                resultJson.setContents(false);
            }else{
                boardDao.deleteById(qid);
                resultJson.setContents(true);
            }
        } catch (Exception e) {
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
            for (Answer answer : getQ.answers) {
                if (answer.aid.equals(aid)) {
                    answer.setbSelection(true);
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

    public ResultJson addAnswer(String qid, Answer answer) {
        ResultJson resultJson = new ResultJson();
        try {
            Question getQ = boardDao.findById(qid).get();
            getQ.answers.add(answer);
            boardDao.save(getQ);
            resultJson.setContents(true);
        } catch(Exception e){
            resultJson.setStateUnconnect();
            resultJson.setMessage("Server Error");
        }
        return resultJson;
    }

    @Override
    public ResultJson updateAnswer(String qid, String aid, String contents) {
        ResultJson resultJson = new ResultJson();
        try {
            Question getQ = boardDao.findById(qid).get();
            for (Answer answer : getQ.answers) {
                if (answer.aid.equals(aid)) {
                    answer.setContents(contents);
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
    public ResultJson deleteAnswer(String qid, String aid) {
        ResultJson resultJson = new ResultJson();
        try {
            Question getQ = boardDao.findById(qid).get();
            for (Answer answer : getQ.answers) {
                if (answer.aid.equals(aid)) {
                    if(answer.isbSelection()){
                        resultJson.setStateFail();
                        resultJson.setMessage("채택되었기 때문에 삭제 불가");
                        resultJson.setContents(false);
                    }else{
                        getQ.answers.remove(answer);
                        resultJson.setContents(true);
                    }
                    break;
                }
            }
            boardDao.save(getQ);
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
    public ResultJson addAnswerComment(String qid, String aid, Comment comment) {
        ResultJson resultJson = new ResultJson();
        try {
            Question getQ = boardDao.findById(qid).get();
            for (Answer answer : getQ.answers) {
                if (answer.aid.equals(aid)) {
                    answer.comments.add(comment);
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
    public ResultJson updateAnswerComment(String qid, String aid, String cid, String contents) {
        ResultJson resultJson = new ResultJson();
        try {
            Question getQ = boardDao.findById(qid).get();
            for (Answer answer : getQ.answers) {
                if (answer.aid.equals(aid)) {
                    for (Comment comment : answer.comments) {
                        if (comment.cid.equals(cid)) {
                            comment.setContents(contents);
                            break;
                        }
                    }
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
    public ResultJson deleteQuestionComment(String qid, String cid) {
        ResultJson resultJson = new ResultJson();
        try {
            Question getQ = boardDao.findById(qid).get();
            for (Comment cmt : getQ.comments) {
                if (cmt.cid.equals(cid)) {
                    getQ.comments.remove(cmt);
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
    public ResultJson deleteAnswerComment(String qid, String aid, String cid) {
        ResultJson resultJson = new ResultJson();
        try {
            Question getQ = boardDao.findById(qid).get();
            for (Answer ans : getQ.answers) {
                if (ans.aid.equals(aid)) {
                    for (Comment comment : ans.comments) {
                        if (comment.cid.equals(cid)) {
                            ans.comments.remove(comment);
                            break;
                        }
                    }
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

}