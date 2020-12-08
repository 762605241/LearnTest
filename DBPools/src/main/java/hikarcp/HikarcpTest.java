package hikarcp;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class HikarcpTest {
    static Connection connection;
    static HikariDataSource ds;

    static {
        HikariConfig config = new HikariConfig("DBPools/src/hikarcp.properties");
        ds = new HikariDataSource(config);
    }
    public static Connection getConnection() throws SQLException {
        Connection connection = ds.getConnection();
        connection.setAutoCommit(false);
        return connection;
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(getConnection());
    }
}
