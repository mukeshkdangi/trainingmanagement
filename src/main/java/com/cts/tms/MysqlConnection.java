package com.cts.tms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author Uday Menon 11:00:05 pm
 */

public class MysqlConnection {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL      = "jdbc:mysql://localhost:3306/tms";

    // Database credentials
    static final String USER        = "root";
    static final String PASS        = "XXXXXXXX";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            // STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // STEP 4: Execute a query
            System.out.println("returned connection");
        } catch (SQLException se) {
            System.out.println("failed to get connection" + se);
            se.printStackTrace();
        } catch (Exception e) {
            System.out.println("failed to get connection" + e);
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConnection(Connection conn, Statement stmt) {

        try {
            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();
        } catch (Exception e) {
        }

        finally {
            // finally block used to close resources if Closing failed above
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            } // nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
