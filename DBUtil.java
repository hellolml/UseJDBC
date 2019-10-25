
import java.sql.*;

public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/ebook";
    private static final String USER_NAME = "root";
    private static final String PASSWORD ="123456";
    public static void main(String args[]) {
        Connection connection=null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");                //1.创建数据库链接,加载驱动
            connection = DriverManager.getConnection(URL,USER_NAME,PASSWORD); //1.创建数据库连接,创建连接对象
            System.out.println(connection);
            statement = connection.createStatement();        //2.创建操作命令statement
            resultSet= statement.executeQuery("select * from book");  //3.使用操作命令来执行SQL
            /*4. 处理结果集ResultSet*/
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String author = resultSet.getString("author");
                Double price = resultSet.getDouble("price");
                System.out.println(String.format("id=%d,name=%s,author=%s,price=%.2f",id,name,author,price));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
        /*5.释放资源*/
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
