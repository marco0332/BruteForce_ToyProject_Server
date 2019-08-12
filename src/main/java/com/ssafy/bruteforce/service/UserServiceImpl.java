package com.ssafy.bruteforce.service;

import java.util.List;
import java.util.NoSuchElementException;

import com.ssafy.bruteforce.dto.ResultJson;
import com.ssafy.bruteforce.dto.User;
import com.ssafy.bruteforce.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userDao;

    @Override
    public ResultJson addUser(User user) {
        
        ResultJson resultJson = new ResultJson();
        try{
            if( userDao.existsById(user.getUserid()) ){
                resultJson.setStateFail();
                resultJson.setMessage("ID already exist");
                resultJson.setContents(false);
            }else{
                userDao.save(user);
                resultJson.setContents(true);
            }
		}catch(Exception e){
            resultJson.setStateUnconnect();
			resultJson.setMessage("Server Error");
        }
        return resultJson;
    }

    @Override
    public ResultJson updateUser(User user) {
        ResultJson resultJson = new ResultJson();
		try{
            userDao.save(user);
            resultJson.setContents(true);
		}catch(Exception e){
			resultJson.setStateUnconnect();
			resultJson.setMessage("Server Error");
        }
        return resultJson;
    }

    @Override
    public ResultJson deleteUserById(String id) {
        ResultJson resultJson = new ResultJson();
		try{
            userDao.deleteById(id);
            resultJson.setContents(true);
        }catch(Exception e){
			resultJson.setStateUnconnect();
			resultJson.setMessage("Server Error");
        }
        return resultJson;
    }

    @Override
    public ResultJson deactivateUserById(String id) {
        ResultJson resultJson = new ResultJson();
        try{
            User deactivatedUser = userDao.findById(id).get();
            deactivatedUser.setbDeactivated(true);
            userDao.save(deactivatedUser);
            resultJson.setContents(true);
        }catch(Exception e){
            resultJson.setStateUnconnect();
			resultJson.setMessage("Server Error");
        }
        return resultJson;
    }

    @Override
    public ResultJson findAllUserByName(String name) {
        ResultJson resultJson = new ResultJson();
        try{
            List<User> users = userDao.findByNameLike(name);
            resultJson.setContents(users);
        }catch(NoSuchElementException e){
            resultJson.setStateFail();
            resultJson.setMessage("No Such Element");
            resultJson.setContents(false);
        }catch(Exception e){
            resultJson.setStateUnconnect();
            resultJson.setMessage("Server Error");
        }
        return resultJson;
    }

    @Override
    public ResultJson login(String id, String pw) {
        ResultJson resultJson = new ResultJson();
        try{
            User user = userDao.findById(id).get();
            
            if( user.getbDeactivated() || !user.getPw().equals(pw) ){
                resultJson.setMessage("계정이 없거나 비밀번호가 일치하지 않습니다.");
                resultJson.setStateFail();
                resultJson.setContents(false);           
            }else{
                resultJson.setContents(user);
            }
        
        }catch(NoSuchElementException e){
            resultJson.setStateFail();
            resultJson.setContents(false);
            resultJson.setMessage("계정이 없거나 비밀번호가 일치하지 않습니다.");
        }catch(Exception e){
            resultJson.setStateUnconnect();
            resultJson.setMessage("Server Error");
        }
        return resultJson;
    }

    @Override
    public ResultJson existsById(String id) {
        ResultJson resultJson = new ResultJson();
        try{
            resultJson.setContents(userDao.existsById(id));
        }catch(Exception e){
            resultJson.setStateUnconnect();
            resultJson.setMessage("Server Error");
        }
        return resultJson;
    }

    @Override
    public ResultJson findUserById(String id) {
        ResultJson resultJson = new ResultJson();
        try{
            User user = userDao.findById(id).get();
            resultJson.setContents(user);
        }catch(Exception e){
            resultJson.setStateUnconnect();
            resultJson.setMessage("Server Error");
        }
        return resultJson;
    }

    @Override
    public ResultJson findAllUserQnAInfoById(String id) {
        ResultJson resultJson = new ResultJson();
        try{
            
        }catch(NoSuchElementException e){

        }catch(Exception e){

        }
        return resultJson;
    }

}