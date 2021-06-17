package Design_Package;

import DomainSource_Package.Medici_Logic;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgramariView extends JFrame {

    public JFrame frame;
    public JPanel panel;
    public JLabel titleLabel;
    public JTable programariTable;
    public DefaultTableModel defaultTableModel;
    public JButton backButton;

    public ProgramariView(){
        frame = new JFrame();
        frame.setTitle("Programari");
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        titleLabel = new JLabel("Programari");
        titleLabel.setBounds(350,40,100,25);
        panel.add(titleLabel);

        String[] column = {"Id Programare","Id Pacient", "Data", "Ora", "Specializare", "Medic", "Servicii"};
        defaultTableModel = new DefaultTableModel(column,0);
        programariTable = new JTable(defaultTableModel);
        JScrollPane scrollPane = new JScrollPane(programariTable);
        scrollPane.setBounds(20,100,750,300);
        panel.add(scrollPane);
        Medici_Logic.getProgramare(programariTable);

        backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        backButton.setBounds(30,25,100,25);
        panel.add(backButton);









        frame.setVisible(true);
    }

//    public static void main(String[] args) {
//        ProgramariView programari = new ProgramariView();
//    }
}
