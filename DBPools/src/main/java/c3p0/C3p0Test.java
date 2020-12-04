package c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;

public class C3p0Test {

    static DataSource dataSource = new ComboPooledDataSource();

    public static Connection getConnection() throws Exception{
        Connection connection = dataSource.getConnection();
        connection.setAutoCommit(false);
        return connection;
    }

    public static void main(String[] args) throws Exception {
        Connection connection = getConnection();
    }
}
