package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnUtils {
    public static Connection getOracleConnection() throws SQLException,ClassNotFoundException{
        String hostName = "localhost";
        String sid = "xe";
        String userName = "busdm";
        String password = "123456789";
        return getOracleConnection(hostName, sid, userName, password);
    }
    public static Connection getOracleConnection(String hostName, String sid,
                                                 String userName, String password) throws ClassNotFoundException,SQLException {
        String connectionURL = "jdbc:oracle:thin:@" + hostName + ":1521:" + sid;

        Connection conn = DriverManager.getConnection(connectionURL, userName,
                password);
        return conn;
    }
}
