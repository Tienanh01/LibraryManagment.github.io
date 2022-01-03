package View;

import Controller.studentController;
import Model.student;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
   
public class capNhatStudent extends JFrame implements ActionListener{
   
    private JPanel contentPane;
    private JTextField t1,t2,t3,t4,t5,t6,t7;
    private JComboBox comboBox, comboBox_1, comboBox_2, comboBox_3;
    JButton b1,b2,b3;

    public static void main(String[] args) {
        new capNhatStudent().setVisible(true);
    }

//    public void random() {
//        Random rd = new Random();
//	t1.setText("" + rd.nextInt(10000 + 1));
//    }

    public capNhatStudent() {
        super("Add Student");
	setBounds(700, 200, 500, 450);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
        setLocationRelativeTo(null);
	JLabel l1 = new JLabel("Mã sinh viên");
	l1.setForeground(new Color(25, 25, 112));
	l1.setFont(new Font("Time new roman", Font.BOLD, 14));
	l1.setBounds(64, 63, 102, 22);
	contentPane.add(l1);

	JLabel l2 = new JLabel("Tên");
	l2.setForeground(new Color(25, 25, 112));
	l2.setFont(new Font("Time new roman", Font.BOLD, 14));
	l2.setBounds(64, 97, 102, 22);
	contentPane.add(l2);

	JLabel l3 = new JLabel("Ngày sinh");
	l3.setForeground(new Color(25, 25, 112));
	l3.setFont(new Font("Time new roman", Font.BOLD, 14));
	l3.setBounds(64, 130, 102, 22);
	contentPane.add(l3);

	JLabel l4 = new JLabel("Ngành học");
	l4.setForeground(new Color(25, 25, 112));
	l4.setFont(new Font("Time new roman", Font.BOLD, 14));
	l4.setBounds(64, 209, 102, 22);
	contentPane.add(l4);

        JLabel l5 = new JLabel("Sinh viên năm");
	l5.setForeground(new Color(25, 25, 112));
	l5.setFont(new Font("Time new roman", Font.BOLD, 14));
	l5.setBounds(64, 242, 102, 22);
	contentPane.add(l5);

	JLabel l6 = new JLabel("Kỳ");
	l6.setForeground(new Color(25, 25, 112));
	l6.setFont(new Font("Time new roman", Font.BOLD, 14));
	l6.setBounds(64, 275, 102, 22);
	contentPane.add(l6);

	t1 = new JTextField();
//	t1.setEditable(false);
	t1.setForeground(new Color(47, 79, 79));
	t1.setFont(new Font("Time new roman", Font.BOLD, 14));
	t1.setBounds(174, 66, 240, 20);
	contentPane.add(t1);
	t1.setColumns(10);

	t2 = new JTextField();
	t2.setForeground(new Color(47, 79, 79));
	t2.setFont(new Font("Time new roman", Font.BOLD, 14));
	t2.setColumns(10);
	t2.setBounds(174, 100, 240, 20);
	contentPane.add(t2);

	t3 = new JTextField();
	t3.setForeground(new Color(47, 79, 79));
	t3.setFont(new Font("Time new roman", Font.BOLD, 14));
	t3.setColumns(10);
	t3.setBounds(174, 133, 240, 20);
	contentPane.add(t3);
        
        t7 = new JTextField();
	t7.setForeground(new Color(47, 79, 79));
	t7.setFont(new Font("Time new roman", Font.BOLD, 14));
	t7.setColumns(10);
	t7.setBounds(174, 174, 240, 20);
	contentPane.add(t7);
        
        t4 = new JTextField();
	t4.setForeground(new Color(47, 79, 79));
	t4.setFont(new Font("Time new roman", Font.BOLD, 14));
	t4.setColumns(10);
	t4.setBounds(174, 212, 240, 20);
	contentPane.add(t4);
        
        t5 = new JTextField();
	t5.setForeground(new Color(47, 79, 79));
	t5.setFont(new Font("Time new roman", Font.BOLD, 14));
	t5.setColumns(10);
	t5.setBounds(174, 245, 240, 20);
	contentPane.add(t5);
        
        t6 = new JTextField();
	t6.setForeground(new Color(47, 79, 79));
	t6.setFont(new Font("Time new roman", Font.BOLD, 14));
	t6.setColumns(10);
	t6.setBounds(174, 278, 240, 20);
	contentPane.add(t6);
        
      t2.setEditable(false);
      t3.setEditable(false);
      t4.setEditable(false);
      t5.setEditable(false);
      t6.setEditable(false);
      t7.setEditable(false);        
//	b1 = new JButton("ADD");
//	b1.addActionListener(this);
//	b1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
//	b1.setBounds(64, 321, 111, 33);
//        b1.setBackground(Color.BLACK);
//        b1.setForeground(Color.WHITE);
//	contentPane.add(b1);
//
//	b2 = new JButton("Back");
//	b2.addActionListener(this);
//	b2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
//	b2.setBounds(198, 321, 111, 33);
//        b2.setBackground(Color.BLACK);
//        b2.setForeground(Color.WHITE);
//	contentPane.add(b2);

 b1 = new JButton("Tìm kiếm");
	  b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });
	b1.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128)), null));
        b1.setFont(new Font("Time new roman", Font.BOLD, 15));
	b1.setBounds(72, 320, 100, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
	contentPane.add(b1);
        
        b3 = new JButton("Cập nhật");
//	b3.addActionListener(this);
          b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CapNhatActionPerformed(evt);
            }
        });
	b3.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128)), null));
        b3.setFont(new Font("Time new roman", Font.BOLD, 15));
	b3.setBounds(292, 320, 95, 33);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
	contentPane.add(b3);


	b2 = new JButton("Back");
	b2.addActionListener(this);
	b2.setBorder(new CompoundBorder(new LineBorder(new Color(105, 105, 105)), null));
	b2.setFont(new Font("Time new roman", Font.BOLD, 15));
	b2.setBounds(182, 320, 97, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
	
	contentPane.add(b2);


	JLabel l7 = new JLabel("Hệ học");
	l7.setForeground(new Color(25, 25, 112));
	l7.setFont(new Font("Time new roman", Font.BOLD, 14));
	l7.setBounds(64, 173, 102, 22);
	contentPane.add(l7);
        
	JPanel panel = new JPanel();
	panel.setBorder(new TitledBorder(new LineBorder(new Color(102, 205, 170), 2, true), "Add-Student",
			TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
	panel.setBackground(new Color(211, 211, 211));
	panel.setBounds(10, 30, 460, 370);
        
        contentPane.setBackground(Color.WHITE);
        panel.setBackground(Color.WHITE);
        
	contentPane.add(panel);
//	random();
    }
    
    public void actionPerformed(ActionEvent ae){
        ArrayList<student> listS = new ArrayList<>();
        try{
            if(ae.getSource() == b1){             
               conn con = new conn();
            String sql = "select * from student where student_id = ?";
		PreparedStatement st = con.c.prepareStatement(sql);
		st.setString(1, t1.getText());
		ResultSet rs = st.executeQuery();
		
                while (rs.next()) {
                    t2.setText(rs.getString("name"));
                    t3.setText(rs.getString("dob"));
                    t4.setText(rs.getString("course"));
                    t5.setText(rs.getString("Nganhhoc"));
                    t6.setText(rs.getString("year"));
                    t7.setText(rs.getString("semester"));
		}
		st.close();
		rs.close();

            }       
                      
            
            
            if(ae.getSource() == b2){
                this.setVisible(false);
		new Home().setVisible(true);		
            }
        }catch(Exception e){
            
        }
    }
    private void SearchActionPerformed(java.awt.event.ActionEvent evt) { 
        try {
            conn con = new conn();
            String sql = "select * from student where student_id = ?";
            PreparedStatement st = con.c.prepareStatement(sql);
            st.setString(1, t1.getText());
            ResultSet rs = st.executeQuery();
            
            while (rs.next()) {
                t2.setText(rs.getString("name"));
                t3.setText(rs.getString("dob"));
                t7.setText(rs.getString("course"));
                t4.setText(rs.getString("Nganhhoc"));
                t5.setText(rs.getString("year"));
                t6.setText(rs.getString("semester"));
            }
            st.close();
            rs.close();
            t1.setEditable(false);
            t2.setEditable(true);
            t3.setEditable(true);
            t4.setEditable(true);
            t5.setEditable(true);
            t6.setEditable(true);
            t7.setEditable(true);
        } catch (SQLException ex) {
            Logger.getLogger(capNhatStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void CapNhatActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try {
            conn con = new conn();
            String sql = "update student set name= ?,dob= ?,course=?,Nganhhoc= ?,year=?,semester = ? " + " where student_id = '"+t1.getText()+"'";
            PreparedStatement st = con.c.prepareStatement(sql);
            st.setString(1,t2.getText());
            st.setString(2,t3.getText());
            st.setString(3,t7.getText());
            st.setString(4,t4.getText());
            st.setString(5,t5.getText());
            st.setString(6,t6.getText());
            
            if(st.executeUpdate() > 0){
                JOptionPane.showMessageDialog(this,"Cập nhật thành công");
            }else{
                JOptionPane.showMessageDialog(this, "Thất bại");
//                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(capnhatsach.class.getName()).log(Level.SEVERE, null, ex);
        }
        
}
}

