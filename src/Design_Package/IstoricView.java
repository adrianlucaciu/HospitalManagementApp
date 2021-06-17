package Design_Package;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IstoricView extends JFrame {
    public JFrame frame;
    public JPanel panel;
    public JLabel titleLabel;
    public JTable istoricTable;
    public DefaultTableModel defaultTableModel;
    public JButton backButton;

    public IstoricView(){
        frame = new JFrame();
        frame.setTitle("Istoric");
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        titleLabel = new JLabel("Istoric");
        titleLabel.setBounds(350,40,100,25);
        panel.add(titleLabel);

        String[] column = {"Id Pacient", "Nume", "Boli", "Medicamente", "Varsta"};
        defaultTableModel = new DefaultTableModel(column,0);
        istoricTable = new JTable(defaultTableModel);
        JScrollPane scrollPane = new JScrollPane(istoricTable);
        scrollPane.setBounds(20,100,750,300);
        panel.add(scrollPane);

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
