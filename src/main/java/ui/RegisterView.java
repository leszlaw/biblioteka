package main.java.ui;

import javax.swing.*;
import javax.swing.text.DateFormatter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class RegisterView {

    JFrame frame;
    JPanel panel;

    JLabel nameLabel;
    JTextField nameText;

    JLabel lastNameLabel;
    JTextField lastNameText;

    JFormattedTextField txtDate;

    JLabel nickLabel;
    JTextField nickText;

    JLabel loginLabel;
    JTextField loginText;

    JLabel passwordLabel;
    JTextField passwordText;

    JLabel emailLabel;
    JTextField emailText;

    JLabel phoneLabel;
    JTextField phoneText;


    public RegisterView() {
        createWindow();
        placeComponents();
        frame.setVisible(true);
    }

    private void createWindow(){
        frame = new JFrame("Rejestracja");
        frame.setSize(300, 160);
        frame.setResizable(false);

        panel = new JPanel();
        frame.add(panel);
    }

    private void placeComponents(){
        panel.setLayout(null);

        nameLabel = new JLabel("Imię");
        nameLabel.setBounds(10, 10, 80, 25);
        panel.add(nameLabel);

        nameText = new JTextField(81);
        nameText.setBounds(100, 10, 160, 25);
        panel.add(nameText);

        lastNameLabel = new JLabel("Nazwisko");
        lastNameLabel.setBounds(10, 40, 80, 25);
        panel.add(lastNameLabel);

        lastNameText = new JPasswordField(36);
        lastNameText.setBounds(100, 40, 160, 25);
        panel.add(lastNameText);

        // przy dacie tylko inaczej
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        DateFormatter dateFormatter  = new DateFormatter(df);
        txtDate = new JFormattedTextField(df);
        txtDate.setBounds(100,70,160,25);
        txtDate .addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') ||
                        (c == KeyEvent.VK_BACK_SPACE) ||
                        (c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_SLASH)))
                {
                    JOptionPane.showMessageDialog(null, "Please Enter Valid");
                    e.consume();
                }
            }
        });
        panel.add(txtDate);
        // reszta juz normalnie

    }

}
