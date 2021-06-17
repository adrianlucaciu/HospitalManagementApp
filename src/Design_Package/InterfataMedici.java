package Design_Package;

import DomainSource_Package.Medici_Logic;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfataMedici extends JFrame {
    public JFrame frame;
    public JPanel panel;
    public JButton programariButton;
    public JLabel idPacientLabel;
    public JTextField idPacientTextField;
    public JButton istoricButton;
    public JTable istoricTable;
    public DefaultTableModel defaultTableModel;

    public InterfataMedici() {
        frame = new JFrame();
        frame.setTitle("Interfata Medici");
        frame.setSize(700, 400);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        programariButton = new JButton("PROGRAMARI");
        programariButton.setBounds(90,50,150,25);
        programariButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProgramariView programariView = new ProgramariView();
            }
        });
        panel.add(programariButton);

        idPacientLabel = new JLabel("id Pacient");
        idPacientLabel.setBounds(30,100,100,25);
        panel.add(idPacientLabel);

        idPacientTextField = new JTextField();
        idPacientTextField.setBounds(100,100,150,25);
        panel.add(idPacientTextField);

        istoricButton = new JButton("Istoric");
        istoricButton.setBounds(270,100,100,25);
        istoricButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(idPacientTextField.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Please write Id Pacient");
                } else if(!(idPacientTextField.getText().trim().isEmpty())){
                    int i = Integer.parseInt(idPacientTextField.getText());
                    boolean exitingPacient = Medici_Logic.verifyIdPacientForAllPacienti(i);
                    if(exitingPacient){
                        Medici_Logic.getIstoricByIdPacient(istoricTable,i);
                    } else {
                        JOptionPane.showMessageDialog(null, "This id non existing");
                    }
                }
            }
        });
        panel.add(istoricButton);

        String[] column = {"Id Istoric","Id Pacient", "Nume", "Boli", "Medicamente", "Varsta"};
        defaultTableModel = new DefaultTableModel(column,0);
        istoricTable = new JTable(defaultTableModel);
        JScrollPane scrollPane = new JScrollPane(istoricTable);
        scrollPane.setBounds(20,200,600,100);
        panel.add(scrollPane);




        frame.setVisible(true);

    }

    public static void main(String[] args) {
        InterfataMedici interfataMedici = new InterfataMedici();

    }
}
