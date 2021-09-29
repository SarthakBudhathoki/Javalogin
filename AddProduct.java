package Demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddProduct implements ActionListener {
    JFrame prt;
    JLabel lbl_heading,prtId, prtName, prtPrice;
    JTextField txtprtId,txtprtName, txtprtPrice;
    JButton addprt, btnBack;
    Font fon1;

    public AddProduct(){
        prt = new JFrame("Add Product");
        prt.setSize(500,400);
        prt.setLayout(null);
        prt.setVisible(true);

        fon1=new Font("algerian",Font.BOLD,50);

        lbl_heading =new JLabel("Add Product");
        lbl_heading.setFont(fon1);
        lbl_heading.setBounds(80,10,550,50);
        lbl_heading.setForeground(new Color(34,34,247));
        prt.add(lbl_heading);

        // Product Id and Text Field
        prtId = new JLabel("Product Id : ");
        prtId.setBounds(100,100,100,20);
        prt.add(prtId);

        txtprtId = new JTextField();
        txtprtId.setBounds(200,100,150,20);
        prt.add(txtprtId);


        // Product name and Text Field
        prtName = new JLabel("Product Name : ");
        prtName.setBounds(100,130,100,20);
        prt.add(prtName);

        txtprtName = new JTextField();
        txtprtName.setBounds(200,130,150,20);
        prt.add(txtprtName);

        // Product Price and Text Field
        prtPrice = new JLabel("Product Price : ");
        prtPrice.setBounds(350,100,100,20);
        prt.add(prtPrice);

        txtprtPrice = new JTextField();
        txtprtPrice.setBounds(450,100,150,20);
        prt.add(txtprtPrice);

        // Add Product Button and Back to Dashboard Button
        addprt = new JButton("Add Product");
        addprt.setBounds(200,160,150,20);
        addprt.addActionListener(this);
        prt.add(addprt);

        btnBack = new JButton("Back to Dashboard");
        btnBack.setBounds(200,190,150,20);
        btnBack.addActionListener(this);
        prt.add(btnBack);

    }

    private void medReset(){
        txtprtId.setText("");
        txtprtName.setText("");
        txtprtPrice.setText("");
    }

    public static void main(String[] args) {
        new AddProduct();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String productID = txtprtId.getText();
        String productName = txtprtName.getText();
        String productPrice = txtprtPrice.getText();


        if (e.getSource()==addprt){
            if (productID.length()==0 || productName.length()==0 || productPrice.length()==0){
                JOptionPane.showMessageDialog(addprt, "Enter all fields completely");
            } else {
                DatabaseOperation db = new DatabaseOperation();
                String query = "insert into addproductData (productid,productname, productprice) values('"+productID+"', '"+productName+"','"+productPrice+"')";
                int ans=db.insert(query);
                if (ans>0){
                    JOptionPane.showMessageDialog(addprt ,"Product Added Successfully");
                    medReset();
                }
            }
        }
        if (e.getSource()==btnBack){
            prt.dispose();
            //new Dashboard();
        }
    }
}