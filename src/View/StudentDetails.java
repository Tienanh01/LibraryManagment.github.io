/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.*;
import net.proteanit.sql.DbUtils;

public class StudentDetails extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTable table;
    private JTextField search;
    private JButton b1,b2;
    
    public static void main(String[] args) {
	new StudentDetails().setVisible(true);
    }

    public void student() {
        Connection c;
    Statement s;
        try {
           Class.forName("com.mysql.jdbc.Driver");  
            c =DriverManager.getConnection("jdbc:mysql:///project7","root","");    
            s =c.createStatement();  
            
            String sql = "select * from student";
            PreparedStatement st = c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            table.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
            st.close();
            c.close();
        } catch (Exception e) {

        }
    }

    public StudentDetails() {
        setBounds(300, 200, 940, 485);
        contentPane = new JPanel();
	contentPane.setBackground(new Color(220, 220, 220));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
        contentPane.setBackground(Color.WHITE);
	contentPane.setLayout(null);

                setLocationRelativeTo(null);

	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(79, 133, 771, 288);
	contentPane.add(scrollPane);

	table = new JTable();
	table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                int row = table.getSelectedRow();
		search.setText(table.getModel().getValueAt(row, 1).toString());
            }
	});
	table.setBackground(new Color(240, 248, 255));
	table.setForeground(Color.DARK_GRAY);
	table.setFont(new Font("Time new roman", Font.BOLD, 16));
	scrollPane.setViewportView(table);

	JButton b1 = new JButton("Search");
	 b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
	b1.setBorder(new LineBorder(new Color(255, 20, 147), 2, true));
	ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/eight.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        b1.setIcon(i3);
	b1.setForeground(new Color(199, 21, 133));
	b1.setFont(new Font("Time new roman", Font.BOLD, 18));
	b1.setBounds(564, 89, 138, 33);
	contentPane.add(b1);

	JButton b2 = new JButton("Delete");
	 b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
	ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/nineth.png"));
        Image i5 = i4.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        b2.setIcon(i6);
	b2.setForeground(new Color(199, 21, 133));
	b2.setFont(new Font("Time new roman", Font.BOLD, 18));
	b2.setBorder(new LineBorder(new Color(255, 20, 147), 2, true));
	b2.setBounds(712, 89, 138, 33);
	contentPane.add(b2);

	JLabel l1 = new JLabel("Danh sách sinh viên");
	l1.setForeground(new Color(102, 205, 170));
	l1.setFont(new Font("Time new roman", Font.BOLD | Font.ITALIC, 26));
	l1.setBounds(250, 20, 400, 47);
	contentPane.add(l1);


	search = new JTextField();
	search.setBackground(new Color(255, 240, 245));
	search.setBorder(new LineBorder(new Color(255, 105, 180), 2, true));
	search.setForeground(new Color(47, 79, 79));
	search.setFont(new Font("Time new roman", Font.BOLD | Font.ITALIC, 17));
	search.setBounds(189, 89, 357, 33);
	contentPane.add(search);
	search.setColumns(10);

	JLabel l2 = new JLabel("Back");
	l2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                Home home = new Home();
		home.setVisible(true);
            }
	});
	l2.setForeground(Color.GRAY);
	l2.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
	ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("library/management/system/icons/tenth.png"));
        Image i8 = i7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        l2.setIcon(i9);
	l2.setBounds(97, 89, 72, 33);
	contentPane.add(l2);

	JPanel panel = new JPanel();
	panel.setBorder(new TitledBorder(new LineBorder(new Color(95, 158, 160), 3, true), "Chi tiết sinh viên",
		TitledBorder.LEADING, TitledBorder.TOP, null, new Color(72, 209, 204)));
	panel.setBounds(68, 59, 790, 370);
        panel.setBackground(Color.WHITE);
	contentPane.add(panel);
        
	student();
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            
            conn con = new conn();
            if( ae.getSource() == b1){
                String sql = "select * from student where concat(name, student_id) like ?";
		PreparedStatement st = con.c.prepareStatement(sql);
		st.setString(1, "%" + search.getText() + "%");
		ResultSet rs = st.executeQuery();

		table.setModel(DbUtils.resultSetToTableModel(rs));
		rs.close();
		st.close();
            }
    
            if(ae.getSource() == b2){
//                String sql = "delete from student where name = '" + search.getText() + "'";               
//		PreparedStatement st = con.c.prepareStatement(sql);
//
//		JDialog.setDefaultLookAndFeelDecorated(true);
//		int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
//		JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
//		if (response == JOptionPane.NO_OPTION) {
//
//		} else if (response == JOptionPane.YES_OPTION) {
//                    int rs = st.executeUpdate();
//                    JOptionPane.showMessageDialog(null, "Deleted !!");
//		} else if (response == JOptionPane.CLOSED_OPTION) {
//                
//                }
//		st.close();
		
            }
            con.c.close();
        }catch(Exception e){
            
        }
    }
       private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            conn con  = new conn();
            String sql = "delete from student where name = '" + search.getText() + "'";
            PreparedStatement st = con.c.prepareStatement(sql);
            
            JDialog.setDefaultLookAndFeelDecorated(true);
            int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.NO_OPTION) {
                
            } else if (response == JOptionPane.YES_OPTION) {
                int rs = st.executeUpdate();
                JOptionPane.showMessageDialog(null, "Deleted !!");
            } else if (response == JOptionPane.CLOSED_OPTION) {
                
            }
            st.close();
            setVisible(false);
            StudentDetails std = new StudentDetails();
            std.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(StudentDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            
        conn con = new conn();
            String sql = "select * from student where concat(name, student_id) like ?";
		PreparedStatement st = con.c.prepareStatement(sql);
		st.setString(1, "%" + search.getText() + "%");
		ResultSet rs = st.executeQuery();

		table.setModel(DbUtils.resultSetToTableModel(rs));
		rs.close();
		st.close();
            st.close();          
        } catch (SQLException ex) {
            Logger.getLogger(StudentDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
}
