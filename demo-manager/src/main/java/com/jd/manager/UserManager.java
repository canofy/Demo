package com.jd.manager;

import com.jd.common.util.PaginatedList;
import com.jd.common.util.Query;
import com.jd.domain.User;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: qinshuangping
 * Date: 14-11-24
 * Time: 下午6:08
 * To change this template use File | Settings | File Templates.
 */
public interface UserManager {
    List<User> findUsers();

    int getUsersCount();


    List<User> findUsersPage(Query query);

    /**
     * @param example
     * @param pageIndex
     * @param pageSize  @return
     */
    PaginatedList<User> findUsers(String example, int pageIndex, int pageSize);


    int createUser(User example);

    List<User> findUsersByTime(String dateStart, String dateEnd,String name,int pageIndex, int pageSize);

    public int update(User user);

    public boolean delete(User user);

    public User findUserById(String id);
}
