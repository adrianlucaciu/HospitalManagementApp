package Design_Package;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfataPacienti extends JFrame {
    public JFrame frame;
    public JPanel panel;
    public JButton programariButton;
    public JButton faProgramareButton;
    public JButton serviciiButton;

    public InterfataPacienti(){
        frame = new JFrame();
        frame.setTitle("Interfata Pacienti");
        frame.setSize(400, 300);
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

        faProgramareButton = new JButton("Adauga programare");
        faProgramareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FaProgramareView faProgramareView = new FaProgramareView();
            }
        });
        faProgramareButton.setBounds(90,100,150,25);
        panel.add(faProgramareButton);

        serviciiButton = new JButton("Servicii & Tarife");
        serviciiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ServiciiView serviciiView = new ServiciiView();
            }
        });
        serviciiButton.setBounds(90,150,150,25);
        panel.add(serviciiButton);


        frame.setVisible(true);
    }

    public static void main(String[] args) {
        InterfataPacienti interfataPacienti = new InterfataPacienti();
    }
}
