package DataSource_Package;

import DomainSource_Package.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginMapper {
    public static boolean getLoginMedic(String username, String password) {
        try {
            DataBaseConnection dataBaseConnection = DataBaseConnection.getDataBaseConnection();
            Connection connection = dataBaseConnection.connection;

            String sql = "SELECT username, password, role FROM login WHERE(username=? and password=?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);

            ResultSet resultSet = preparedStatement.executeQuery();
            int r = 0;
            if(resultSet.next()) {
                r= resultSet.getInt("role");
            }
            resultSet.close();
            if(r == 1) {
                return true;
            } else {
                return false;
            }
        }
        catch (Exception e) {
            System.out.println("Eroare in DataSource_Package, LoginMapper, getLoginDoctor" + e);
            return false;
        }
    }

    public static boolean getLoginPacient(String username, String password) {
        try {
            DataBaseConnection dataBaseConnection = DataBaseConnection.getDataBaseConnection();
            Connection connection = dataBaseConnection.connection;

            String sql = "SELECT username, password, role FROM login WHERE(username=? and password=?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);

            ResultSet resultSet = preparedStatement.executeQuery();
            int r = 0;
            if(resultSet.next()) {
                r= resultSet.getInt("role");
            }
            resultSet.close();
            if(r == 2) {
                return true;
            } else {
                return false;
            }
        }
        catch (Exception e) {
            System.out.println("Eroare in DataSource_Package, LoginMapper, getLoginPacient" + e);
            return false;
        }
    }

    public static int getLoginId(Login login){
        int loginId = 0;
        try {
            DataBaseConnection dataBaseConnection = DataBaseConnection.getDataBaseConnection();
            Connection connection = dataBaseConnection.connection;
            String sql = "SELECT idlogin FROM login WHERE username=? AND password=?";
            PreparedStatement preparedStatement = connection.prepareCall(sql);
            preparedStatement.setString(1, login.getUsername());
            preparedStatement.setString(2, login.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                loginId = resultSet.getInt("idlogin");
            }
            resultSet.close();
        }
        catch (Exception e) {
            System.out.println("Eroare in DataSource_Package, LoginMapper, getLoginId(login)" + e);
        }
        return loginId;
    }

    public static Login getLoginByUsername(String username) {
        Login login = new Login();
        try {
            DataBaseConnection dataBaseConnection = DataBaseConnection.getDataBaseConnection();
            Connection connection = dataBaseConnection.connection;
            String sql = "SELECT idlogin, passowrd, role FROM login WHERE username=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                login.setIdLogin(resultSet.getInt("idlogin"));
                login.setPassword(resultSet.getString("password"));
                login.setRole(resultSet.getInt("role"));
            }
            resultSet.close();
        } catch (Exception e ) {
            System.out.println("Eroare in DataSource_Package, LoginMapper, getLoginByUsername" + e);
        }
        System.out.println("S1: " + login.getUsername());
        System.out.println("S2: " + login.getIdLogin());
        return login;
    }

}
