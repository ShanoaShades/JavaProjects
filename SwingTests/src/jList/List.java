package jList;

import javax.swing.*;  
public class List  
{  
     List(){  
        JFrame f= new JFrame();  
        // On crée la liste l1 de classe String selon un modèle prédéfini. Faut quand même que je demade deux ou trois trucs là...
        DefaultListModel<String> l1 = new DefaultListModel<>();  
          l1.addElement("Item1");  
          l1.addElement("Item2");  
          l1.addElement("Item3");  
          l1.addElement("Item4");  
          // On utilise la classe JList pour créer l'objet list et afficher la liste qui permettra la sélection de ses éléments.
          JList<String> list = new JList<>(l1);  
          list.setBounds(100,100, 75,75);  
          f.add(list);  
          f.setSize(400,400);  
          f.setLayout(null);  
          f.setVisible(true);  
     }  
public static void main(String args[])  
    {  
   new List();  
    }}  