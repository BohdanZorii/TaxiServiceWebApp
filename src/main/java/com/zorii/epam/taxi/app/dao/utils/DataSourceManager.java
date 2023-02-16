package com.zorii.epam.taxi.app.dao.utils;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceManager {
    private static HikariConfig config=new HikariConfig();
    private static DataSource ds;

    static {
        config.setJdbcUrl("jdbc:mysql://localhost:3306/taxi_service");
        config.setUsername("root");
        config.setPassword("password");
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );

        ds=new HikariDataSource(config);
    }

    private DataSourceManager(){}

    public static Connection getConnection() throws SQLException{
        return ds.getConnection();
    }

    public static DataSource getDataSource(){
        return ds;
    }
}
