import java.sql.*;
public class Select {
    public static void main(String args[]){
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = DBUtil1.getConnection();
        String sql = "select * from book";
        try {
            preparedStatement = connection.prepareStatement(sql);
            //preparedStatement.setString();
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String author = resultSet.getString("author");
                Double price = resultSet.getDouble("price");
                System.out.println(String.format("id=%d,name=%s,author=%s,price=%.2f",id,name,author,price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil1.close(connection,preparedStatement,resultSet );
        }
    }
}
