import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
    //conexiune
    private static  Connection connection;
    private DBUtils(){

    }
    public static Connection getConnection(){
        if(connection!=null)
        {
            return connection;
        }else {
            String url = "jdbc:mysql://localhost:3306/dbcloud2022";
            String username = "root";
            String password = "Crocodil_123";
            try {
                 connection = DriverManager.getConnection(url, username, password);
                 return connection;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
    }


}
