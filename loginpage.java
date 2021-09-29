package Demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
public class loginpage implements ActionListener {
    JFrame log_frame;
    JLabel username,password;
    JTextField txt_username;
    JPasswordField txt_password;
    JButton btn_login, btn_register;
    Font fon1;
    public loginpage(){
        log_frame = new JFrame("Login");
        log_frame.setSize(550,300);
        log_frame.setLayout(null);
        log_frame.setVisible(true);
        log_frame.setBackground(SystemColor.activeCaption);
        fon1=new Font("algerian",Font.BOLD,50);
        // Username label
        username = new JLabel("Username: ");
        username.setBounds(50,50,100,20);
        log_frame.add(username);
        // Username textfield
        txt_username = new JTextField();
        txt_username.setBounds(150,50,300,20);
        log_frame.add(txt_username);
        // Pasword lable
        password = new JLabel("Password: ");
        password.setBounds(50,100,100,20);
        log_frame.add(password);
        // Password to be entered here
        txt_password = new JPasswordField();
        txt_password.setBounds(150,100,300,20);
        log_frame.add(txt_password);
        // Buttons here
        btn_login = new JButton("Login");
        btn_login.setBounds(150,150,100,20);
        btn_login.addActionListener(this);
        log_frame.add(btn_login);
        btn_register = new JButton("Sign up");
        btn_register.setBounds(280,150,100,20);
        btn_register.addActionListener(this);
        log_frame.add(btn_register);
    }

    public static void main(String[] args) {
        new loginpage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btn_login){
            String name = txt_username.getText();
            String pass = txt_password.getText();
            String query = "select * from register where username='"+name+"' and pass='"+pass+"'";
            DatabaseOperation db = new DatabaseOperation();
            ResultSet rs = db.select(query);
            try {
                if (rs.next()){
                    JOptionPane.showMessageDialog(log_frame,"Login Successful");
                    new AddProduct();
                    log_frame.dispose();
                }
                else {
                    JOptionPane.showMessageDialog(log_frame,"Invalid Login Credentials");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        if (e.getSource()==btn_register){
            log_frame.dispose();
            new Registration();
        }
    }
}