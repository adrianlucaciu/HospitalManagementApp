package DataSource_Package;

import DomainSource_Package.Istoric;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MediciMapper {
    public static void getProgramare(JTable table){
        try {
            DataBaseConnection dataBaseConnection = DataBaseConnection.getDataBaseConnection();
            Connection connection = dataBaseConnection.connection;
            String sql = "SELECT * FROM programari";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
            while (resultSet.next()){
                int idProgramari = resultSet.getInt("idProgramari");
                int idPacient = resultSet.getInt("idPacient");
                String data = resultSet.getString("data");
                String ora = resultSet.getString("ora");
                String specializare = resultSet.getString("specializare");
                String medic = resultSet.getString("medic");
                String servicii = resultSet.getString("servicii");
                tableModel.addRow(new Object[] {idProgramari, idPacient, data, ora, specializare, medic, servicii});
            }
            resultSet.close();
        }
        catch (Exception e) {
            System.out.println("Eroare in DataSource_Package, MediciMapper, getProgramarare" + e);
        }
    }

    public static Istoric getIstoricByIdPacient(JTable jTable, int idPacient){
        Istoric istoric = new Istoric();
        try {
            DataBaseConnection dataBaseConnection = DataBaseConnection.getDataBaseConnection();
            Connection connection = dataBaseConnection.connection;
            String sql = "SELECT * FROM istoric WHERE idPacient=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,idPacient);
            ResultSet resultSet = preparedStatement.executeQuery();

            DefaultTableModel tableModel2 = (DefaultTableModel) jTable.getModel();

            while(resultSet.next()){
                int idIstoric = istoric.setIdIstoric(resultSet.getInt("idIstoric"));
                int idPacientget = istoric.setIdPacient(resultSet.getInt("idPacient"));
                String nume = istoric.setNume(resultSet.getString("nume"));
                String boli = istoric.setBoli(resultSet.getString("boli"));
                String medicamente = istoric.setMedicamente(resultSet.getString("medicamente"));
                int varsta = istoric.setVarsta(resultSet.getInt("varsta"));
                tableModel2.addRow(new Object[] {idIstoric, idPacientget, nume, boli, medicamente, varsta});
            }
            resultSet.close();
        }
        catch (Exception e){
            System.out.println("Eroare in DataSource_Package, MediciMapper, getIstoricByIdPacient");
        }
        return istoric;
    }

    public static boolean verifyIdPacientForAllPacienti(int idPacient){
        try {
            DataBaseConnection dataBaseConnection = DataBaseConnection.getDataBaseConnection();
            Connection connection = dataBaseConnection.connection;
            String sql = "SELECT idPacient FROM istoric";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                int result = resultSet.getInt("idPacient");
                if(idPacient == result) {
                    return true;
                }
            }
            resultSet.close();
        } catch (Exception e) {
            System.out.println("Eroare in DataSource_Package, MediciMapper, verifyIdPacientForAllPacienti" + e);
        }
        return false;
    }

}
