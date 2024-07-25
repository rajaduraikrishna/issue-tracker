module my.module {
    requires java.base;
    requires java.sql;
    requires java.naming;

    opens com.ezeeinfo.issuemanager;

    opens com.ezeeinfo.issuemanager.service;

    exports com.ezeeinfo.issuemanager.service;
    exports com.ezeeinfo.issuemanager;
}