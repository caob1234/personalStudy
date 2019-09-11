package com.smart.conf;

public class LogonService {
    private LogDao logDao;
    private UserDao userDao;

    public void setLogDao(LogDao logDao) {
        this.logDao = logDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void printHello() {
        System.out.println("LogonService say Hello world!");
        logDao.printHello();
    }
}
