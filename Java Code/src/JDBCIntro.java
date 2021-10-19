import java.sql.*;

public class JDBCIntro {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/JDBCIntro","root","root");
            statement= connection.createStatement();
            statement.execute("insert into table1 values(2,'prateek')");

//            statement.execute("update table1 set column1='gupta' where id=2");
            statement.execute("delete from table1 where id=2");
            ResultSet set= statement.executeQuery("select * from table1");
            while (set.next()){
                System.out.println(set.getInt(1)+"\t"+set.getString(2));
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
        }
        finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }

        }
    }
}
