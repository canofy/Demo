package com.jd.domain;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: qinshuangping
 * Date: 14-11-24
 * Time: 下午6:07
 * To change this template use File | Settings | File Templates.
 */
public class User {
    private int id;
    private String userAccount;
    private int userType;
    private Date created;
    private Date modified;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }
}
