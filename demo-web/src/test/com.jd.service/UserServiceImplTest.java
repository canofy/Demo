package com.jd.service;

import com.jd.common.web.result.Result;
import com.jd.domain.User;
import org.junit.Test;

import java.util.List;
import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: qinshuangping
 * Date: 14-11-25
 * Time: 上午11:35
 * To change this template use File | Settings | File Templates.
 */
public class UserServiceImplTest extends BaseTest {
    private UserService userService;

    @Test
    public void testCreateUser() {
        Random random = new Random();

        User user = new User();
        user.setUserAccount("test1");
        user.setUserType(random.nextInt(99));
        userService.createUser(user);
    }

    @Test
    public void testFindAll(){
         Result result=userService.findUsers();
         List<User> list= (List<User>) result.get("user");
         System.out.println("user size="+list.size());
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
