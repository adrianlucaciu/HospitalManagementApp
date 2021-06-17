package DataSource_Package;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PacientiMapper {

    public static void getProgramare(JTable table) {
        try {
            DataBaseConnection dataBaseConnection = DataBaseConnection.getDataBaseConnection();
            Connection connection = dataBaseConnection.connection;
            String sql = "SELECT * FROM programari";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            while (resultSet.next()) {
                int idProgramari = resultSet.getInt("idProgramari");
                int idPacient = resultSet.getInt("idPacient");
                String data = resultSet.getString("data");
                String ora = resultSet.getString("ora");
                String specializare = resultSet.getString("specializare");
                String medic = resultSet.getString("medic");
                String servicii = resultSet.getString("servicii");
                tableModel.addRow(new Object[]{idProgramari, idPacient, data, ora, specializare, medic, servicii});
            }
            resultSet.close();
        } catch (Exception e) {
            System.out.println("Eroare in DataSource_Package, PacientiMapper, getProgramarare" + e);
        }
    }

    public static void insertProgramare(int idProgramari, int idPacient, String data, String ora, String specializare, String medic, String servicii){
        try{
            DataBaseConnection dataBaseConnection = DataBaseConnection.getDataBaseConnection();
            Connection connection = dataBaseConnection.connection;

            String sql = "INSERT INTO programari(idProgramari, idPacient, data, ora, specializare, medic, servicii) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idProgramari);
            preparedStatement.setInt(2, idPacient);
            preparedStatement.setString(3, data);
            preparedStatement.setString(4, ora);
            preparedStatement.setString(5, specializare);
            preparedStatement.setString(6, medic);
            preparedStatement.setString(7, servicii);
            preparedStatement.executeUpdate();
        }catch (Exception e){
            System.out.println("Eroare in DataSource_Package, PacientiMapper, insertProgramare" + e);
        }
    }



    public static void getServicii(JTable table){
        try {
            DataBaseConnection dataBaseConnection = DataBaseConnection.getDataBaseConnection();
            Connection connection = dataBaseConnection.connection;
            String sql = "SELECT * FROM servicii";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            while (resultSet.next()){
                int idServicii = resultSet.getInt("idservicii");
                String numeServiciu = resultSet.getString("numeServiciu");
                String pret = resultSet.getString("pretServiciu");
                tableModel.addRow(new Object[] {idServicii, numeServiciu, pret});
            }
            resultSet.close();
        }
        catch (Exception e) {
            System.out.println("Eroare in DataSource_Package, PacientiMapper, getServicii" + e);
        }
    }
}
