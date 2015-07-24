package com.jd.service.impl;

import com.jd.common.web.result.Result;
import com.jd.domain.User;
import com.jd.manager.UserManager;
import com.jd.service.UserService;

/**
 * Created by IntelliJ IDEA.
 * User: qinshuangping
 * Date: 14-11-25
 * Time: 上午10:33
 * To change this template use File | Settings | File Templates.
 */
public class UserServiceImpl implements UserService{
    private UserManager userManager;

    public Result findUsers() {
        Result result = new Result();
        result.addDefaultModel("users",userManager.findUsers());
        result.setSuccess(true);
        return result;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Result findUsers(String name, int pageIndex, int pageSize) {
        Result result = new Result();
        result.addDefaultModel("users",userManager.findUsers(name,pageIndex,pageSize));
        result.setSuccess(true);
        return result;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Result createUser(User user) {
        Result result = new Result();
        result.addDefaultModel("userId",userManager.createUser(user));
        result.addDefaultModel("user",user);
        result.setSuccess(true);
        return result;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Result findUsersByTime(String dateStart, String dateEnd,String name,int pageIndex, int pageSize) {
        Result result=new Result();
        result.addDefaultModel("user",userManager.findUsersByTime(dateStart,dateEnd,name,pageIndex,pageSize));
        result.setSuccess(true);
        return result;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Result findUsersByTime1(String dateStart, String dateEnd, int pageIndex, int pageSize) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Result update(User user) {
        Result result=new Result();
        userManager.update(user);
        result.addDefaultModel("user",user);
        result.setSuccess(true);
        return result;
    }

    public boolean delete(User user) {
        return userManager.delete(user);
    }

    public Result findUserById(String id) {
         Result result=new Result();
        result.addDefaultModel("user",userManager.findUserById(id));
        result.setSuccess(true);
        return result;
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }
}
