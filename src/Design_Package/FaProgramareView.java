package Design_Package;

import DomainSource_Package.Pacienti_Logic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FaProgramareView extends JFrame {
    public JFrame frame;
    public JPanel panel;
    public JLabel titleLabel;
    public JButton backButton;
    public JLabel dataLabel;
    public JComboBox dataCombobox;
    public JLabel oraLabel;
    public JComboBox oraCombobox;
    public JLabel specializareLabel;
    public JComboBox specializareCombobox;
    public JLabel medicLabel;
    public JComboBox medicCombobox;
    public JCheckBox consulatieCheckbox;
    public JCheckBox controlCheckbox;
    public JCheckBox investigatieCheckbox;
    public JCheckBox analizeCheckbox;
    public JButton programeazaButton;
    public JLabel idProgramareLabel;
    public JTextField idProgramareTextField;
    public JLabel idPacientLabel;
    public JTextField idPacientTextField;

    public FaProgramareView(){
        frame = new JFrame();
        frame.setTitle("Adauga programare");
        frame.setSize(600, 450);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        titleLabel = new JLabel("Adauga programare");
        titleLabel.setBounds(220,30,150,25);
        panel.add(titleLabel);

        idProgramareLabel = new JLabel("Id Programare");
        idProgramareLabel.setBounds(370,30,100,25);
        panel.add(idProgramareLabel);

        idProgramareTextField = new JTextField();
        idProgramareTextField.setBounds(470,30,100,25);
        panel.add(idProgramareTextField);

        idPacientLabel = new JLabel("Id Pacient");
        idPacientLabel.setBounds(370,70,100,25);
        panel.add(idPacientLabel);

        idPacientTextField = new JTextField();
        idPacientTextField.setBounds(470,70,100,25);
        panel.add(idPacientTextField);

        backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        backButton.setBounds(30,25,100,25);
        panel.add(backButton);

        dataLabel = new JLabel("Data programari");
        dataLabel.setBounds(50,100,100,25);
        panel.add(dataLabel);


        String[] data = {"1 iunie 2021", "2 iunie 2021", "3 iunie 2021", "5 iunie 2021", "10 iunie 2021", "16 iunie 2021", "21 iunie 2021"};
        dataCombobox = new JComboBox(data);
        dataCombobox.setBounds(200,100,150,25);
        panel.add(dataCombobox);

        oraLabel = new JLabel("Ora Programari");
        oraLabel.setBounds(50,150,100,25);
        panel.add(oraLabel);

        String[] ora = {"10:00", "12:00", "14:00", "16:00", "18:00", "20:00"};
        oraCombobox = new JComboBox(ora);
        oraCombobox.setBounds(200,150,150,25);
        panel.add(oraCombobox);

        specializareLabel = new JLabel("Specializare");
        specializareLabel.setBounds(50,200,100,25);
        panel.add(specializareLabel);

        String[] specializare = {"Cardiologie", "Dermatologie", "Medicina interna", "Ecografie", "ORL", "Pediatrie", "Psihiatrie"};
        specializareCombobox = new JComboBox(specializare);
        specializareCombobox.setBounds(200,200,150,25);
        panel.add(specializareCombobox);

        medicLabel = new JLabel("Medic");
        medicLabel.setBounds(50,250,100,25);
        panel.add(medicLabel);

        String[] medici = {"Dr. Tantau Ioan", "Dr. Cozma Georgel", "Dr. Pop Ionut", "Dr. Alexe Mihai", "Dr. Ionescu Georgeta", "Dr. Balazs Parasca", "Dr. Popescu Ana", "Dr. Ioan Celestin"};
        medicCombobox = new JComboBox(medici);
        medicCombobox.setBounds(200,250,150,25);
        panel.add(medicCombobox);

        consulatieCheckbox = new JCheckBox("Consulatatie");
        consulatieCheckbox.setBounds(50,300,100,25);
        panel.add(consulatieCheckbox);

        controlCheckbox = new JCheckBox("Control");
        controlCheckbox.setBounds(180,300,100,25);
        panel.add(controlCheckbox);

        investigatieCheckbox = new JCheckBox("Investigatie");
        investigatieCheckbox.setBounds(290,300,100,25);
        panel.add(investigatieCheckbox);

        analizeCheckbox = new JCheckBox("Analize");
        analizeCheckbox.setBounds(400,300,100,25);
        panel.add(analizeCheckbox);

        programeazaButton = new JButton("Adauga programare");
        programeazaButton.setBounds(170,350,200,25);
        programeazaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idProgramare = Integer.parseInt(idProgramareTextField.getText());
                int idPacient = Integer.parseInt(idPacientTextField.getText());
                String data = (String) dataCombobox.getItemAt(dataCombobox.getSelectedIndex());
                String ora = (String) oraCombobox.getItemAt(oraCombobox.getSelectedIndex());
                String specializare = (String) specializareCombobox.getItemAt(specializareCombobox.getSelectedIndex());
                String medic = (String) medicCombobox.getItemAt(specializareCombobox.getSelectedIndex());
                String servicii = "";
                if (consulatieCheckbox.isSelected()) {
                    servicii = consulatieCheckbox.getText();
                }
                if (controlCheckbox.isSelected()) {
                    if (servicii.equals("")) {
                        servicii = controlCheckbox.getText();
                    } else {
                        servicii = servicii + ", " + controlCheckbox.getText();
                    }
                }

                if (investigatieCheckbox.isSelected()) {
                    if (servicii.equals("")) {
                        servicii = investigatieCheckbox.getText();
                    } else {
                        servicii = servicii + ", " + investigatieCheckbox.getText();
                    }
                }

                if (analizeCheckbox.isSelected()) {
                    if (servicii.equals("")) {
                        servicii = analizeCheckbox.getText();
                    } else {
                        servicii = servicii + ", " + analizeCheckbox.getText();
                    }
                }
                Pacienti_Logic.insertProgramare(idProgramare,idPacient,data,ora,specializare,medic,servicii);
                JOptionPane.showMessageDialog(null, "Programare adaugata");
            }
        });
        panel.add(programeazaButton);



        frame.setVisible(true);
    }
//
//    public static void main(String[] args) {
//        FaProgramareView faProgramareView = new FaProgramareView();
//    }
        }
