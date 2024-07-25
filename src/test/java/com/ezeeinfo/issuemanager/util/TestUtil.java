package com.ezeeinfo.issuemanager.util;


import com.mysql.cj.jdbc.MysqlDataSource;
import com.ezeeinfo.issuemanager.IssueManagerManager;

public class TestUtil {
    public static IssueManagerManager questionBankManager() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("user");
        dataSource.setPassword("password");
        dataSource.setDatabaseName("mydb");
        return IssueManagerManager.getManager(dataSource);
    }

}
