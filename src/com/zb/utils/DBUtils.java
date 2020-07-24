package com.zb.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;


public class DBUtils {

    private static ComboPooledDataSource dataSource =
            new ComboPooledDataSource("c3p0-config.xml");
    

    public  static Connection getConnectionByDatasource(){
        Connection conn = null;
        try {
             conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  conn;
    }
    public static void close(Connection conn){
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
