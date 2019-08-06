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
    public void deleteUser(String id) {
        userDao.deleteById(id);
    }

    @Override
    public void deactivateUser(String id) {
        Optional<User> user = userDao.findById(id);
        if (user.isPresent()) 
        {
            User deactivatedUser = user.get();
            if(deactivatedUser.getbDeactivated())
            {
                System.out.println("Error/deactivateUser : 이미 비활성화된 계정");
                return;
            }
            deactivatedUser.setbDeactivated(true);
            userDao.save(deactivatedUser);
        } else 
        {
            System.out.println("Error/deactivateUser : 존재하지 않는 계정");
            return;
        }
    }

    @Override
    public User searchUser(String id) {
        return null;
    }

    @Override
    public boolean login(User user) {
        return false;
    }

    @Override
    public boolean idCheck(String id) {
        return false;
    }

    @Override
    public List<User> findId(User user) {
        return null;
    }

    @Override
    public List<UserQnAInfo> findAllUserQnAInfo(String id) {
        return null;
    }

}