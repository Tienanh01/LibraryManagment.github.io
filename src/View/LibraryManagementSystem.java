package View;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class LibraryManagementSystem extends JFrame implements ActionListener{

        JLabel l1,l2;
        JButton b1;
        JButton b2;
        
        public LibraryManagementSystem() {
		
                setSize(650,417);
                setLayout(null);
//                setLocation(300,300);
                setLocationRelativeTo(null);

		l1 = new JLabel("");                             
                b1 = new JButton("");
//                b2 = new JButton("Student login");
                
                b1.setBackground(Color.LIGHT_GRAY);        
                
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/anhbia1.png"));
                Image i3 = i1.getImage().getScaledInstance(650, 417,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                l1 = new JLabel(i2);
                
                ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/nextpage.png"));
                Image image1 =  image.getImage().getScaledInstance(120, 116, Image.SCALE_DEFAULT);
                ImageIcon image2 = new ImageIcon(image1);
                l2 = new JLabel(image2);
                            
                b1.setBounds(350,230,150,116);
//                   b2.setBounds(1050,150,200,60);
		l1.setBounds(0, 0, 650, 417);                                            
                
                l1.add(b1);
//                l1.add(b2);
		add(l1);
                
                b1.addActionListener(this);
//                b2.addActionListener(this);
	}
        
        public void actionPerformed(ActionEvent ae){
                new Login_user().setVisible(true);
                this.setVisible(false);
                
        }
        
        public static void main(String[] args) {
                LibraryManagementSystem window = new LibraryManagementSystem();
                window.setVisible(true);			
	}
}
