package com.jd.action;

import com.jd.common.struts.action.BaseAction;
import com.jd.common.web.result.Result;
import com.jd.domain.User;
import com.jd.service.UserService;
import org.apache.commons.lang.StringUtils;

/**
 * Created by IntelliJ IDEA.
 * User: qinshuangping
 * Date: 14-11-25
 * Time: 下午2:58
 * To change this template use File | Settings | File Templates.
 */
public class UserAction extends BaseAction {
    private UserService userService;

    private int pageSize = 3;

    private String startTime;
    private String endTime;
    private String name;
    private User user;

    public String list() throws Exception {
        //Result result=userService.findUsers();
        Result result = userService.findUsers("", page, pageSize);
        result.addDefaultModel("message", "test message");
        super.toVm(result);
        return super.SUCCESS;
    }

    public String add() throws Exception {
        /* super.setCookie("jd.com","testcookie");*/

        return SUCCESS;
    }

    public String doAdd() throws Exception {
        Result result = userService.createUser(user);
        super.toVm(result);
        return SUCCESS;
    }

    public String delete() throws Exception {
        String id = super.request.getParameter("id");
        User deleteUser = new User();
        deleteUser.setId(Integer.parseInt(id));
        userService.delete(deleteUser);
        Result result = new Result();
        result.setSuccess(true);
        result.addDefaultModel("userId", id);
        super.toVm(result);
        return SUCCESS;
    }

    public String update() throws Exception {
        String id = super.request.getParameter("id");
        Result result = null;
        if (StringUtils.isEmpty(id)) {
            result = new Result();
            result.setSuccess(false);
            result.addDefaultModel("message", "not get id");
        } else {
            result = userService.findUserById(id);
        }
        super.toVm(result);
        return SUCCESS;
    }

    public String doUpdate() throws Exception {
        Result result=userService.update(user);
        result.addDefaultModel("message", "修改成功");
        super.toVm(result);
        return SUCCESS;
    }

    public String listByTime() throws Exception{

        Result result=userService.findUsersByTime(startTime,endTime,name,page,pageSize)   ;
        super.toVm(result);
        return SUCCESS;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
