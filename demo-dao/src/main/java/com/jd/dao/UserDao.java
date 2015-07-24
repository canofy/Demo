package com.jd.dao;

import com.jd.domain.User;
import com.jd.common.util.Query;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: qinshuangping
 * Date: 14-11-24
 * Time: 下午6:05
 * To change this template use File | Settings | File Templates.
 */
public interface UserDao {

     /**
     * @return
     */
    public List<User> findUsers() ;

    int getUsersCount();

    /**
     * @return
     */
    int getUsersCount(Query query);

    List<User> findUseresPage(Query query);

    /**
     * @param user
     */
    void createUser(User user);

    List<User> findUsersByTime(String startDate,String endDate,Query query);

    public int update(User user);
    public boolean delete(User user);
    public  User findUserById(String id);
}
