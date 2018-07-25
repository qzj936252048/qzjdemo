package com.qzj.com.qzj.entity;

public class User  {
    // 序列化
    private static final long serialVersionUID = 1L;
    // 私有字段
    private String loginName;
    private String userName;
    private String passWord;
    // 公共构造器
    public User() {
        super();
    }
    // get/set 方法
    public String getLoginName() {
        return loginName;
    }
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassWord() {
        return passWord;
    }
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}