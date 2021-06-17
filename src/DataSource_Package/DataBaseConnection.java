package DataSource_Package;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class DataBaseConnection {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/hospitalmanagement";
    static final String USER = "root";
    static final String PASS = "silvana321";

    public Connection connection;

    public static DataBaseConnection dataBaseConnection;

    private DataBaseConnection(){
        try{
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(DB_URL,USER,PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static synchronized DataBaseConnection getDataBaseConnection() {
        if(dataBaseConnection == null) {
            dataBaseConnection = new DataBaseConnection();
        }
        return dataBaseConnection;
    }
}
