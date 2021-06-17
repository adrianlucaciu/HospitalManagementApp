package Design_Package;

import DomainSource_Package.Pacienti_Logic;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServiciiView extends JFrame {

    public JFrame frame;
    public JPanel panel;
    public JLabel titleLabel;
    public JTable serviciiTable;
    public DefaultTableModel defaultTableModel;
    public JButton backButton;

    public ServiciiView(){
        frame = new JFrame();
        frame.setTitle("Servicii & Tarife");
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        titleLabel = new JLabel("Servicii & Tarife");
        titleLabel.setBounds(350,40,100,25);
        panel.add(titleLabel);

        String[] column = {"Id Serviciu", "Nume Investigatie", "Pret"};
        defaultTableModel = new DefaultTableModel(column,0);
        serviciiTable = new JTable(defaultTableModel);
        JScrollPane scrollPane = new JScrollPane(serviciiTable);
        scrollPane.setBounds(20,100,750,300);
        panel.add(scrollPane);
        Pacienti_Logic.getServicii(serviciiTable);

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
}
