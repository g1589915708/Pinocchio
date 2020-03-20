package org.easyweb.service.impl;

import org.easyweb.dao.UserDao;
import org.easyweb.model.UserModel;
import org.easyweb.redis.RedisService;
import org.easyweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
//    @Autowired
    @Resource(name="redisServiceImpl")
    private RedisService redisService;
    @Override
    public void InsertByUser(UserModel user) {
        userDao.InsertByUser(user);
    }

    @Override
    public void DeleteByName(UserModel user) {
        userDao.DeleteByName(user);
    }

    @Override
    public void UpdateByName(UserModel user) {
        userDao.UpdateByName(user);
    }

    @Override
    public UserModel SelectByName(UserModel user) {
        UserModel userModel = null;
        //先从Redis里取
        userModel = (UserModel) redisService.getObject(user.getUsername());
        if(null == userModel){
            //如果Redis没有则从数据库里取
            userModel =userDao.SelectByName(user);
            //从数据库中取了之后，再存入Redis，以便下次取
            if(userModel!=null){
                redisService.setObject(user.getUsername(),(Object)userModel);
            }
        }
        return userModel;
    }
}
