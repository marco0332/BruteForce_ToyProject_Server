package com.ssafy.bruteforce.service;

import java.util.List;
import java.util.Optional;

import com.ssafy.bruteforce.dto.User;
import com.ssafy.bruteforce.dto.UserQnAInfo;
import com.ssafy.bruteforce.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userDao;

    @Override
    public void addUser(User user) {
        userDao.insert(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.save(user);
    }

    @Override
    public void deleteUserById(String id) {
        userDao.deleteById(id);
    }

    @Override
    public void deactivateUserById(String id) {
        User deactivatedUser = userDao.findById(id).get();
        if (deactivatedUser.getbDeactivated()) {
            System.out.println("Error/deactivateUser : 이미 비활성화된 계정");
            return;
        }
        deactivatedUser.setbDeactivated(true);
        userDao.save(deactivatedUser);
    }

    @Override
    public List<User> findAllUserByName(String name) {
        return null;
    }

    @Override
    public boolean login(String id, String pw) {
        Optional<User> user = userDao.findById(id);
        if (user.isPresent()) {
            User currentUser = user.get();
            Boolean bLoginResult = currentUser.getPw() == pw ? true : false;
            return bLoginResult;
        }
        System.out.println("Error/Login : 존재하지 않는 아이디입니다.");
        return false;
    }

    @Override
    public boolean existsById(String id) {
        return userDao.existsById(id);
    }

    @Override
    public User findUserById(String id) {
        return userDao.findById(id).get();
    }

    @Override
    public List<UserQnAInfo> findAllUserQnAInfoById(String id) {
        return null;
    }

}