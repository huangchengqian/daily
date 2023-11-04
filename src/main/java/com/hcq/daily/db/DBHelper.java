package com.hcq.daily.db;

import com.hcq.daily.vo.DataSourceVO;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

@Configuration
public class DBHelper {

    private static final HashMap<String, HikariDataSource> dsCache = new HashMap<>();


    public Connection getConnection(String dsCode) throws SQLException {
        if (dsCode == null || dsCode.isEmpty()) {
            return null;
        }
        HikariDataSource ds = getDataSource(dsCode);
        return ds.getConnection();
    }

    private HikariDataSource getDataSource(String dsCode) {

        if (!dsCache.containsKey(dsCode)) {
            // synchronized (DBHelper.class) {
                if (!dsCache.containsKey(dsCode)) {
                    System.out.printf("==============%s获取连接，新建数据源=============\n", dsCode);
                    DataSourceVO dataSourceVO = new DataSourceVO();
                    dataSourceVO.setDataSourceCode(dsCode);
                    dataSourceVO.setDataSourceUrl("jdbc:postgresql://127.0.0.1:5432/postgres");
                    dataSourceVO.setDbAccount("postgres");
                    dataSourceVO.setDbPassword("hcq10086");
                    getConfigDataSourceVO(dataSourceVO);
                }
           // }
        }
        System.out.printf("==============%s返回连接=============\n", dsCode);
        return dsCache.get(dsCode);
}

    private void getConfigDataSourceVO(DataSourceVO dataSourceVO) {
        System.out.println("new ds!");
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(dataSourceVO.getDataSourceUrl());
        config.setUsername(dataSourceVO.getDbAccount());
        config.setPassword(dataSourceVO.getDbPassword());
        config.setPoolName(dataSourceVO.getDataSourceCode());
        config.setIdleTimeout(1000 * 60 * 10);
        config.setMaxLifetime(1000 * 60 * 30);
        config.setMinimumIdle(0);
        config.setMaximumPoolSize(5);
        config.setKeepaliveTime(1000 * 60 * 30);

        config.addDataSourceProperty("rewriteBatchStatement", "true");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");

        HikariDataSource dataSource = new HikariDataSource(config);
        dsCache.put(dataSourceVO.getDataSourceCode(), dataSource);

    }
}
