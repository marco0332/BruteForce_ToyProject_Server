package com.ssafy.bruteforce.service;

import java.util.List;
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

    // @Override
    // public List<Question> findAllQuestions() {
    // return boardDao.findAll();
    // }
    @Override
    public ResultJson findAllQuestions() {
        ResultJson resultJson = new ResultJson();
        try {
            resultJson.setContents(boardDao.findAll());
        } catch (NoSuchElementException e) {
            resultJson.setStaeFail();
            resultJson.setMessage("No Such Element");
        } catch (Exception e) {
            resultJson.setStateUnconnect();
            resultJson.setMessage("Server Error");
        }
        return resultJson;
    }

    // @Override
    // public Question findQuestionById(String qid) {
    // return boardDao.findById(qid).get();
    // }
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

    // @Override
    // public List<Question> findQuestionByTitle(String title) {
    // return boardDao.findByTitle(title);
    // }
    @Override
    public ResultJson findQuestionByTitle(String title) {
        ResultJson resultJson = new ResultJson();
        try {
            resultJson.setContents(boardDao.findByTitle(title));
        } catch (NoSuchElementException e) {
            resultJson.setStaeFail();
            resultJson.setMessage("No Such Element");
        } catch (Exception e) {
            resultJson.setStateUnconnect();
            resultJson.setMessage("Server Error");
        }
        return resultJson;
    }

    // @Override
    // public List<Question> findQuestionByTag(String[] tag) {
    // return boardDao.findByTag(tag);
    // }
    @Override
    public ResultJson findQuestionByTag(String[] tag) {
        ResultJson resultJson = new ResultJson();
        try {
            resultJson.setContents(boardDao.findByTag(tag));
        } catch (NoSuchElementException e) {
            resultJson.setStaeFail();
            resultJson.setMessage("No Such Element");
        } catch (Exception e) {
            resultJson.setStateUnconnect();
            resultJson.setMessage("Server Error");
        }
        return resultJson;
    }

    // @Override
    // public void addQuestion(Question question) {
    // boardDao.insert(question);
    // }
    @Override
    public ResultJson addQuestion(Question question) {
        ResultJson resultJson = new ResultJson();
        try {
            boardDao.insert(question);
        } catch (Exception e) {
            resultJson.setStateUnconnect();
            resultJson.setMessage("Server Error");
        }
        return resultJson;
    }

    // @Override
    // public void updateQuestion(Question question) {
    // boardDao.save(question);
    // }
    @Override
    public ResultJson updateQuestion(Question question) {
        ResultJson resultJson = new ResultJson();
        try {
            boardDao.save(question);
        } catch (Exception e) {
            resultJson.setStateUnconnect();
            resultJson.setMessage("Server Error");
        }
        return resultJson;
    }

    // @Override
    // public void deleteQuestion(String qid) {
    // boardDao.deleteById(qid);
    // }
    @Override
    public ResultJson deleteQuestion(String qid) {
        ResultJson resultJson = new ResultJson();
        try {
            boardDao.deleteById(qid);
        } catch (Exception e) {
            resultJson.setStateUnconnect();
            resultJson.setMessage("Server Error");
        }
        return resultJson;
    }

    // @Override
    // public boolean closedUpdate(String qid, String aid) {
    // Question getQ = boardDao.findById(qid).get();
    // getQ.setbClosed(true);
    // for(Answer answer:getQ.answers){
    // if(answer.aid.equals(aid)){
    // answer.setbSelection(true);
    // break;
    // }
    // }
    // boardDao.save(getQ);
    // return false;
    // }
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
        } catch(Exception e){
            resultJson.setStateUnconnect();
            resultJson.setMessage("Server Error");
        }
        return resultJson;
    }

    // @Override
    // public void addAnswer(String qid, Answer answer) {
    // Question getQ = boardDao.findById(qid).get();
    // getQ.answers.add(answer);
    // boardDao.save(getQ);
    // }
    public ResultJson addAnswer(String qid, Answer answer) {
        ResultJson resultJson = new ResultJson();
        try {
            Question getQ = boardDao.findById(qid).get();
            getQ.answers.add(answer);
            boardDao.save(getQ);
        } catch(Exception e){
            resultJson.setStateUnconnect();
            resultJson.setMessage("Server Error");
        }
        return resultJson;
    }

    // @Override
    // public void updateAnswer(String qid, String aid, String contents) {
    // Question getQ = boardDao.findById(qid).get();
    // for(Answer answer:getQ.answers){
    // if(answer.aid.equals(aid)){
    // answer.setContents(contents);
    // break;
    // }
    // }
    // boardDao.save(getQ);
    // }
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
        } catch(Exception e){
            resultJson.setStateUnconnect();
            resultJson.setMessage("Server Error");
        }
        return resultJson;
    }

    // @Override
    // public void deleteAnswer(String qid, String aid) {
    // Question getQ = boardDao.findById(qid).get();
    // for(Answer answer:getQ.answers){
    // if(answer.aid.equals(aid)){
    // getQ.answers.remove(answer);
    // break;
    // }
    // }
    // boardDao.save(getQ);
    // }
    @Override
    public ResultJson deleteAnswer(String qid, String aid) {
        ResultJson resultJson = new ResultJson();
        try {
            Question getQ = boardDao.findById(qid).get();
            for (Answer answer : getQ.answers) {
                if (answer.aid.equals(aid)) {
                    getQ.answers.remove(answer);
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

    // @Override
    // public void addQuestionComment(String qid, Comment comment) {
    // Question getQ = boardDao.findById(qid).get();
    // getQ.comments.add(comment);
    // boardDao.save(getQ);
    // }
    @Override
    public ResultJson addQuestionComment(String qid, Comment comment) {
        ResultJson resultJson = new ResultJson();
        try {
            Question getQ = boardDao.findById(qid).get();
            getQ.comments.add(comment);
            boardDao.save(getQ);
        } catch(Exception e){
            resultJson.setStateUnconnect();
            resultJson.setMessage("Server Error");
        }
        return resultJson;
    }

    // @Override
    // public void addAnswerComment(String qid, String aid, Comment comment) {
    // Question getQ = boardDao.findById(qid).get();
    // for(Answer answer:getQ.answers){
    // if(answer.aid.equals(aid)){
    // answer.comments.add(comment);
    // break;
    // }
    // }
    // boardDao.save(getQ);
    // }
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
        } catch(Exception e){
            resultJson.setStateUnconnect();
            resultJson.setMessage("Server Error");
        }
        return resultJson;
    }

    // @Override
    // public void updateQuestionComment(String qid, String cid, String contents) {
    // Question getQ = boardDao.findById(qid).get();
    // for(Comment comment:getQ.comments){
    // if(comment.cid.equals(cid)){
    // comment.setContents(contents);
    // break;
    // }
    // }
    // boardDao.save(getQ);
    // }
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
        } catch(Exception e){
            resultJson.setStateUnconnect();
            resultJson.setMessage("Server Error");
        }
        return resultJson;
    }

    // @Override
    // public void updateAnswerComment(String qid, String aid, String cid, String
    // contents) {
    // Question getQ = boardDao.findById(qid).get();
    // for(Answer answer:getQ.answers){
    // if(answer.aid.equals(aid)){
    // for(Comment comment:answer.comments){
    // if(comment.cid.equals(cid)){
    // comment.setContents(contents);
    // break;
    // }
    // }
    // break;
    // }
    // }
    // boardDao.save(getQ);
    // }
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
        } catch(Exception e){
            resultJson.setStateUnconnect();
            resultJson.setMessage("Server Error");
        }
        return resultJson;
    }

    // @Override
    // public void deleteQuestionComment(String qid, String cid) {
    // Question getQ = boardDao.findById(qid).get();
    // for(Comment cmt:getQ.comments){
    // if(cmt.cid.equals(cid)){
    // getQ.comments.remove(cmt);
    // break;
    // }
    // }
    // boardDao.save(getQ);
    // }
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
        } catch(Exception e){
            resultJson.setStateUnconnect();
            resultJson.setMessage("Server Error");
        }
        return resultJson;
    }

    // @Override
    // public void deleteAnswerComment(String qid, String aid, String cid) {
    // Question getQ = boardDao.findById(qid).get();
    // for(Answer ans:getQ.answers){
    // if(ans.aid.equals(aid)){
    // for(Comment comment:ans.comments){
    // if(comment.cid.equals(cid)){
    // ans.comments.remove(comment);
    // break;
    // }
    // }
    // break;
    // }
    // }
    // boardDao.save(getQ);
    // }
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
        } catch(Exception e){
            resultJson.setStateUnconnect();
            resultJson.setMessage("Server Error");
        }
        return resultJson;
    }

}