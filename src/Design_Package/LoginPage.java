package Design_Package;

import DomainSource_Package.Login;
import DomainSource_Package.Login_Logic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame {

    public JFrame frame;
    public JPanel panel;
    public JLabel titleLabel;
    public JLabel usernameLabel;
    public JTextField usernameTextField;
    public JLabel passwordLabel;
    public JPasswordField passwordField;
    public JRadioButton doctorRButton;
    public JRadioButton pacientRButton;
    public JButton loginButton;

    public LoginPage() {

        frame = new JFrame();
        frame.setTitle("Login Page");
        frame.setSize(400, 450);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        titleLabel = new JLabel("Login Page");
        titleLabel.setBounds(180, 40, 100, 25);
        panel.add(titleLabel);

        usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(20,100,100,25);
        panel.add(usernameLabel);

        usernameTextField = new JTextField();
        usernameTextField.setBounds(100,100,150,25);
        panel.add(usernameTextField);

        passwordLabel = new JLabel("Passowrd");
        passwordLabel.setBounds(20,150,100,25);
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(100,150,150,25);
        panel.add(passwordField);

        doctorRButton = new JRadioButton("Doctor");
        doctorRButton.setBounds(100,200,100,25);
        panel.add(doctorRButton);

        pacientRButton = new JRadioButton("Pacient");
        pacientRButton.setBounds(200,200,100,25);
        panel.add(pacientRButton);

        loginButton = new JButton("LOGIN");
        loginButton.setBounds(100,250,150,25);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = usernameTextField.getText();
                try {
                    System.out.println("Username: " +user);
                    boolean medic = Login_Logic.verifyLoginMedic(usernameTextField.getText(), passwordField.getText());
                    boolean pacient = Login_Logic.verifyLoginPacient(usernameTextField.getText(),passwordField.getText());

                    int status = Login_Logic.getRole(medic, pacient);
                    Login login_db = Login_Logic.getLoginByUsername(user);

                    if(status == 1 && doctorRButton.isSelected()){
                        JOptionPane.showMessageDialog(null,"Logged as Doctor succesful");
                        frame.dispose();
                        InterfataMedici interfataMedici = new InterfataMedici();
                    } else if((status == 1 && pacientRButton.isSelected()) || status == 2 && doctorRButton.isSelected()) {
                        JOptionPane.showMessageDialog(null,"Login failed, choose another role");
                    } else if(status == 2 && pacientRButton.isSelected()){
                        JOptionPane.showMessageDialog(null,"Logged as patient succesful");
                        frame.dispose();
                        InterfataPacienti interfataPacienti = new InterfataPacienti();
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Login");
                    }
                } catch (Exception exception) {
                    System.out.println("Login error" + exception);
                }
            }
        });
        panel.add(loginButton);




        frame.setVisible(true);
    }

    public static void main(String[] args) {
        LoginPage loginPage = new LoginPage();

    }
}