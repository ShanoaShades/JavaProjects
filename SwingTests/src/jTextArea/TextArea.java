package jTextArea;

import javax.swing.*;  
public class TextArea  
{  
     TextArea(){ 
        JFrame f= new JFrame("TextArea Simple");  
        // Je remarque qu'on peut soit créer directement un objet avec son contenu via new soit créer plusieurs objets à la suite et ensuite leur donner du contenu
        JTextArea area=new JTextArea("Welcome to javatpoint");  
        area.setBounds(10,30, 200,200);  
        f.add(area);  
        f.setSize(300,300);  
        f.setLayout(null);  
        f.setVisible(true);  
     }  
public static void main(String args[])  
    {  
   new TextArea();  
    }}  
