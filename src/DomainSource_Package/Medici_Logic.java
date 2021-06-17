package DomainSource_Package;

import DataSource_Package.MediciMapper;

import javax.swing.*;

public class Medici_Logic {

    public static void getProgramare(JTable table) {
        MediciMapper.getProgramare(table);
    }

    public static Istoric getIstoricByIdPacient(JTable table, int idPacient){
        return MediciMapper.getIstoricByIdPacient(table, idPacient);
    }

    public static boolean verifyIdPacientForAllPacienti(int x){
        return MediciMapper.verifyIdPacientForAllPacienti(x);
    }
}
