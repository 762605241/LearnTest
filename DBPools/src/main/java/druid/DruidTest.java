package druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DruidTest {
    static Connection connection;
    static DataSource dataSource;
    static {
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("DBPools/src/druid.properties");
            properties.load(fileInputStream);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        connection = dataSource.getConnection();
        connection.setAutoCommit(false);
        return connection;
    }

    public static void main(String[] args) throws SQLException {
        Connection connection = getConnection();
        System.out.println(connection);
    }
}
