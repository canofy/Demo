package com.jd.dao.impl;

import com.jd.common.dao.BaseDao;
import com.jd.common.util.Query;
import com.jd.dao.UserDao;
import com.jd.domain.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: qinshuangping
 * Date: 14-11-24
 * Time: 下午6:06
 * To change this template use File | Settings | File Templates.
 */
public class UserDaoImpl  extends BaseDao implements UserDao{
    public List<User> findUsers() {
        return super.queryForList("User.findUsers");
       // return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int getUsersCount() {
        return (Integer)super.queryForObject("User.getUsersCount");
        //return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int getUsersCount(Query query) {
        return (Integer)queryForObject("User.getUsersCount",query);
        //return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public List<User> findUseresPage(Query query) {
        return super.queryForList("User.findOrdersPage",query);
       // return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void createUser(User user) {
        super.insert("User.createUser",user);
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public List<User> findUsersByTime(String startDate, String endDate,Query query) {
          Map<String,String> map=new HashMap<String,String>();
          map.put("dateStart",startDate);
          map.put("dateEnd",endDate);
          map.put("startRow", String.valueOf(query.getStartRow()));
          map.put("pageSize",String.valueOf(query.getEndRow()));

          return super.queryForList("User.findOrdersPage",map);
        //return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int update(User user) {

        return super.update("User.updateUser",user);
    }

    public boolean delete(User user) {
        int flag=super.delete("User.deleteUser",user);
        if(flag>0) return true;
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public User findUserById(String id) {
        Map map=new HashMap();
        map.put("id",id);
        User user=(User)super.queryForObject("User.findUserById",map);
        return user;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
