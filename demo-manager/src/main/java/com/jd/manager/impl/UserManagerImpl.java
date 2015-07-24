package com.jd.manager.impl;

import com.jd.common.manager.BaseManager;
import com.jd.common.util.PaginatedList;
import com.jd.common.util.Query;
import com.jd.common.util.base.BaseQuery;
import com.jd.common.util.base.PaginatedArrayList;
import com.jd.dao.UserDao;
import com.jd.domain.User;
import com.jd.manager.UserManager;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: qinshuangping
 * Date: 14-11-24
 * Time: 下午6:09
 * To change this template use File | Settings | File Templates.
 */
public class UserManagerImpl extends BaseManager implements UserManager{
    private final static Log log = LogFactory.getLog(UserManagerImpl.class);
    private UserDao userDao;

    public List<User> findUsers() {
        return userDao.findUsers();  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int getUsersCount() {
        return userDao.getUsersCount();  //To change body of implemented methods use File | Settings | File Templates.
    }

    public List<User> findUsersPage(Query query) {
        return userDao.findUseresPage(query);  //To change body of implemented methods use File | Settings | File Templates.
    }

    public PaginatedList<User> findUsers(String name, int pageIndex, int pageSize) {
        BaseQuery baseQuery = new BaseQuery();
        if(StringUtils.isNotBlank(name)) { //
            baseQuery.setValue("%"+name+"%"); //
        }
        int totalItem=userDao.getUsersCount(baseQuery);
        PaginatedList<User>  users= new PaginatedArrayList<User>(pageIndex,pageSize);
        users.setTotalItem(totalItem);
        baseQuery.setStartRow(getMySqlStartRow(users.getStartRow()));
        baseQuery.setEndRow(users.getPageSize());

        //users.getPageSize()
        List<User> list=userDao.findUseresPage(baseQuery);
        users.addAll(list);
        return users;  //To change body of implemented methods use File | Settings | File Templates.
    }
     protected int getMySqlStartRow(int startRow) {
        return startRow > 1 ? startRow - 1 : 0;
    }
    /**
     * 添加用户
     * 使用了事务，完全可以不用，这里主要是用来学习
     * @param user
     * @return
     */
    public int createUser(final User user) {
        TransactionTemplate template = getDataSourceTransactionManager();
        template.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                try {
                       userDao.createUser(user);
                } catch (Exception e) {
                    log.error("createUser error!",e);
                     status.setRollbackOnly();
                    throw new RuntimeException("createUser error",e);
                }
            }
        });
        return user.getId();
    }

    public List<User> findUsersByTime(String dateStart, String dateEnd,String name,int pageIndex, int pageSize) {
        BaseQuery baseQuery = new BaseQuery();
        int totalItem=userDao.getUsersCount(baseQuery);
        PaginatedList<User>  users= new PaginatedArrayList<User>(pageIndex,pageSize);
        users.setTotalItem(totalItem);
        baseQuery.setStartRow(getMySqlStartRow(users.getStartRow()));
        baseQuery.setEndRow(users.getPageSize());

        return userDao.findUsersByTime(dateStart,dateEnd,baseQuery);  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int update(User user) {

        return userDao.update(user);
    }

    public boolean delete(User user) {
        return userDao.delete(user);
    }

    public User findUserById(String id) {
        return userDao.findUserById(id);
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
