package com.hisd.common.web.security.configure;

import org.apache.commons.dbcp.BasicDataSource;

public class ApplicationDataSource extends BasicDataSource {

    @Override
    public synchronized void setUrl(String url) {
    }

    @Override
    public void setUsername(String username) {
    }

    @Override
    public void setPassword(String password) {
    }

    @Override
    public synchronized void setDriverClassName(String driverClassName) {
    }
}
