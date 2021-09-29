package Demo;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Registration implements ActionListener {
    JFrame reg_frame;
    JLabel lbl_heading, fullname, email, gender, pass, cpass;
    JTextField txt_fullname, txt_email;
    JRadioButton rd_male, rd_female;
    JPasswordField txt_pass, txt_cpass;
    JButton btn_register, btn_back;
    Font fon1,fon2,fon3;
    public Registration(){
        reg_frame = new JFrame("Registration Page");
        reg_frame.setSize(800,600);
        reg_frame.setLayout(null);
        reg_frame.setVisible(true);
        fon1=new Font("Cambria",Font.BOLD,50);
//        fon2=new Font("areal",Font.BOLD,18);
//        fon3=new Font("areal",Font.BOLD,30);
        lbl_heading =new JLabel("USER REGISTRATION");
        lbl_heading.setFont(fon1);
        lbl_heading.setBounds(80,10,550,50);
        lbl_heading.setForeground(new Color(34,34,247));
        reg_frame.add(lbl_heading);
        // Fullname label and Text Field
        fullname=new JLabel("User name : ");
        fullname.setBounds(30,100,300,20);
        reg_frame.add(fullname);
        txt_fullname =new JTextField();
        txt_fullname.setBackground(new Color(245,254,255));
        txt_fullname.setBounds(150,100,250,20);
        reg_frame.add(txt_fullname);
        // Email label and Text Field
        email=new JLabel("Email : ");
        email.setBounds(30,150,300,20);
        reg_frame.add(email);
        txt_email =new JTextField();
        txt_email.setBackground(new Color(245,254,255));
        txt_email.setBounds(150,150,250,20);
        reg_frame.add(txt_email);

        
  // Gender label
        gender = new JLabel("Gender : ");
        gender.setBounds(30,200,300,20);
        reg_frame.add(gender);
        // Gender Male or Female
        rd_male = new JRadioButton("Male");
        rd_male.setBounds(150,200,100,20);
        rd_male.setSelected(true);
        reg_frame.add(rd_male);
        rd_female = new JRadioButton("Female");
        rd_female.setBounds(250,200,100,20);
        reg_frame.add(rd_female);
        // Grouping Male and Female
        ButtonGroup gen = new ButtonGroup();
        gen.add(rd_male);
        gen.add(rd_female);
        // Password Area
        pass = new JLabel("Password : ");
        pass.setBounds(30,250,170,20);
        reg_frame.add(pass);
        txt_pass = new JPasswordField();
        txt_pass.setBounds(150,250,200,20);
        reg_frame.add(txt_pass);
        cpass = new JLabel("Confirm Password: ");
        cpass.setBounds(30, 300, 200,20);
        reg_frame.add(cpass);
        txt_cpass = new JPasswordField();
        txt_cpass.setBounds(150,300,200,20);
        reg_frame.add(txt_cpass);
        // Making a Registration Button
        btn_register = new JButton("Register");
        btn_register.setBounds(100,350,150,20);
        btn_register.addActionListener(this);
        reg_frame.add(btn_register);
        btn_back = new JButton("Back to Login");
        btn_back.setBounds(300,350,200,20);
        btn_back.addActionListener(this);
        reg_frame.add(btn_back);
    }

    public static void main(String[] args) {
        new Registration();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = txt_fullname.getText();
        String email = txt_email.getText();
        String gender = "Male";
        if (rd_female.isSelected()){
            gender = "female";
        }
        String pass1 = txt_pass.getText();
        String pass2 = txt_cpass.getText();
        if (!pass1.equals(pass2)){
            JOptionPane.showMessageDialog(reg_frame,"The password does not match," +
                    "Please try again");
        }
        else {
            if (e.getSource()==btn_register) {
                DatabaseOperation db = new DatabaseOperation();
                String query = "insert into register(username, email, gender, pass, con_pass) values('"+name+"','"+email+"','"+gender+"','"+pass1+"','"+pass2+"')";
                int ans=db.insert(query);
                if (ans>0){
                    JOptionPane.showMessageDialog(reg_frame ,"Data Registered Successfully");
                }
            }
        }
        if (e.getSource()==btn_back){
            reg_frame.dispose();
            new loginpage();
        }
    }
}


