package com.jd.service;

import com.jd.common.web.result.Result;
import com.jd.domain.User;

/**
 * Created by IntelliJ IDEA.
 * User: qinshuangping
 * Date: 14-11-25
 * Time: 上午10:30
 * 用户service层
 */
public interface UserService {
    Result findUsers();

    Result findUsers(String name, int pageIndex, int pageSize);

    Result createUser(User example);

    Result findUsersByTime(String dateStart, String dateEnd,String name,int pageIndex, int pageSize);

    Result findUsersByTime1(String dateStart, String dateEnd, int pageIndex, int pageSize);

    public Result update(User user);
    public boolean delete(User user);
    public Result findUserById(String id);
}
