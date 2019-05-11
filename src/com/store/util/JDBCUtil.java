package com.store.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
    private static DruidDataSource ds = null;
    private static QueryRunner qr = null;

    static {
        try {
            Properties p = new Properties();
            InputStream in = JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties");
            p.load(in);
            ds = (DruidDataSource) DruidDataSourceFactory.createDataSource(p);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DruidDataSource getDs() {
        return ds;
    }

    public static QueryRunner getQr() {
        qr = new QueryRunner(ds);
        return qr;
    }

    public static Connection getConn(){
        try {
            Connection conn = ds.getConnection();
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
