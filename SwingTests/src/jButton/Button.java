package jButton;

import javax.swing.*;    
public class Button {  
public static void main(String[] args) {  
    JFrame f=new JFrame("Bouton simple");  
    JButton b=new JButton("Cliquez");  
    // Below (Axe x, Axe y, Width, Height)
    b.setBounds(150,150,95,30);  
    f.add(b);  
    f.setSize(400,400);  
    f.setLayout(null);  
    f.setVisible(true);   
}  
}  