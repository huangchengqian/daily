package com.hcq.daily.VO;

public class DataSourceVO {

    private String dbAccount;

    private String dbPassword;

    private String dataSourceUrl;

    private String dataSourceCode;

    public String getDbAccount() {
        return dbAccount;
    }

    public void setDbAccount(String dbAccount) {
        this.dbAccount = dbAccount;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public String getDataSourceUrl() {
        return dataSourceUrl;
    }

    public void setDataSourceUrl(String dataSourceUrl) {
        this.dataSourceUrl = dataSourceUrl;
    }

    public String getDataSourceCode() {
        return dataSourceCode;
    }

    public void setDataSourceCode(String dataSourceCode) {
        this.dataSourceCode = dataSourceCode;
    }


    @Override
    public String toString() {
        return "DataSourceVO{" +
                "dbAccount='" + dbAccount + '\'' +
                ", dbPassword='" + dbPassword + '\'' +
                ", dataSourceUrl='" + dataSourceUrl + '\'' +
                ", dataSourceCode='" + dataSourceCode + '\'' +
                '}';
    }
}
