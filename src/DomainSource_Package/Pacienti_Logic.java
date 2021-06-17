package DomainSource_Package;

import DataSource_Package.MediciMapper;
import DataSource_Package.PacientiMapper;

import javax.swing.*;

public class Pacienti_Logic {
    public static void getProgramare(JTable table) {
        PacientiMapper.getProgramare(table);
    }

    public static void insertProgramare(int idProgramare, int idPacient, String data, String ora, String specializare, String medic, String servicii){
        PacientiMapper.insertProgramare(idProgramare, idPacient, data, ora, specializare, medic, servicii);
    }

    public static void getServicii(JTable table) {
        PacientiMapper.getServicii(table);
    }
}
