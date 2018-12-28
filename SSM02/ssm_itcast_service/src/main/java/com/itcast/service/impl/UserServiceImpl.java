package com.itcast.service.impl;

import com.itcast.dao.UserDao;
import com.itcast.domain.Pages;
import com.itcast.domain.User;
import com.itcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User findUser(User user) throws Exception {
        return userDao.findUser(user);
    }



   /* @Override
    public List<User> findAll() throws Exception {
        return userDao.findAll();
    }*/



    @Override
    public void saveUser(User user) throws Exception {
        userDao.saveUser(user);
    }

    @Override
    public User updateUser(Integer id) throws Exception {
        return userDao.updateUser(id);
    }

    @Override
    public void deleteUser(Integer id) throws Exception {
        userDao.deleteUser(id);
    }

    @Override
    public List<User> findAll(Pages pages) throws Exception {
        if(pages!=null){
            //pages进行每页起始记录处理
            pages.setStartNum((pages.getPageNum()-1)*pages.getPageCounts());
        }
        return userDao.findAll(pages);
    }

   /* @Override
    public List<User> findPages(Pages pages) throws Exception {
        if (pages!=null){
            pages.setStartNum((pages.getPageNum()-1)*pages.getPageCounts());
        }
        return userDao.findPages(pages);
    }*/

}
