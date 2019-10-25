

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.*;
public class DBUtil1 {
    private static final String URL = "jdbc:mysql://localhost:3306/ebook";
    private static final String USER_NAME = "root";
    private static final String PASSWORD ="123456";
    private static MysqlDataSource DATASOURCE = new MysqlDataSource();
    static {
        DATASOURCE.setUrl(URL);
        DATASOURCE.setUser(USER_NAME);
        DATASOURCE.setPassword(PASSWORD);
    }
    public static Connection getConnection(){
        try {
            return DATASOURCE.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("获取数据库连接失败!");
        }
    }
    public static void close(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet){
        try {
            if(resultSet!=null){
                resultSet.close();
            }
            if (preparedStatement!=null){
                preparedStatement.close();
            }
            if(connection!=null){
                connection.close();
            }
        } catch (SQLException e) {
           throw new RuntimeException("数据库释放资源错误!");
        }
    }
}
