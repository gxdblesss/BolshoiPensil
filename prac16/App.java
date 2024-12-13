package prac16;

//Реализуйте программу Проверка пароля на Джава с использованием
//        Layout менеджеров компоновки. Окно программы должно иметь вид как на рис.
//        16.41.

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class App extends JFrame {
    JFrame self = this;
    App(){
        this.setTitle("Password application");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 200);
        this.setLayout(new BorderLayout());

        JLabel serviceLabel = new JLabel("Service:", JLabel.RIGHT);
        JLabel usernameLabel = new JLabel("Username:", JLabel.RIGHT);
        JLabel passwordLabel = new JLabel("Password:", JLabel.RIGHT);

        JTextField serviceField = new JTextField();
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton checkButton = new JButton("Check");

        JPanel topPanel = new JPanel(new GridLayout(3, 5, 10, 10));
        topPanel.add(serviceLabel);
        topPanel.add(serviceField);
        topPanel.add(usernameLabel);
        topPanel.add(usernameField);
        topPanel.add(passwordLabel);
        topPanel.add(passwordField);

        for (var Comp : topPanel.getComponents()){
            Comp.setFont(new Font("Times New Roman", Font.BOLD, 14));
        }

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.add(checkButton);

        this.add(topPanel, BorderLayout.NORTH);
        this.add(bottomPanel, BorderLayout.SOUTH);
        this.getRootPane().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = new String(passwordField.getPassword());
                if (password.equals("123456")) {
                    JOptionPane.showMessageDialog(self, "Successfully logged in!");
                    System.exit(0);
                } else {
                    JOptionPane.showMessageDialog(self, "Incorrect password!");
                    System.exit(0);
                }
            }
        });
    }
}

 class Task_3 {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
                var App = new App();
                App.setVisible(true);
            }
        });
    }
}

