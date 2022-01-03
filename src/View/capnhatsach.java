package View;

import Controller.bookController;
import Model.book;
import Model.student;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class capnhatsach extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField t1,t2,t3,t4,t5,t6,t7;
    private JButton b1,b2,b3;
    JComboBox comboBox;
        
    public static void main(String[] args) {
	new capnhatsach().setVisible(true);
    }

//    public void random() {
//        Random rd = new Random();
//	t1.setText("" + rd.nextInt(1000 + 1));
//    }

    public capnhatsach() {
        setBounds(600, 200, 518, 442);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

           Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
            int iCoordX = (objDimension.width - this.getWidth()) / 2;
            int iCoordY = (objDimension.height - this.getHeight()) / 2;
            this.setLocation(iCoordX, iCoordY); 
	JLabel l1 = new JLabel("Tên sách");
	l1.setForeground(new Color(47, 79, 79));
	l1.setFont(new Font("Time new roman", Font.BOLD, 14));
	l1.setBounds(73, 84, 90, 22);
	contentPane.add(l1);

	JLabel l2 = new JLabel("Mã vạch");
	l2.setForeground(new Color(47, 79, 79));
	l2.setFont(new Font("Tahoma", Font.BOLD, 14));
	l2.setBounds(73, 117, 90, 22);
	contentPane.add(l2);

	JLabel l3 = new JLabel("Tác giả");
	l3.setForeground(new Color(47, 79, 79));
	l3.setFont(new Font("Tahoma", Font.BOLD, 14));
	l3.setBounds(73, 150, 90, 22);
	contentPane.add(l3);

	JLabel l4 = new JLabel("Gía");
	l4.setForeground(new Color(47, 79, 79));
	l4.setFont(new Font("Time new roman", Font.BOLD, 14));
	l4.setBounds(73, 216, 90, 22);
	contentPane.add(l4);

	JLabel l5 = new JLabel("Số trang");
	l5.setForeground(new Color(47, 79, 79));
	l5.setFont(new Font("Tahoma", Font.BOLD, 14));
	l5.setBounds(73, 249, 90, 22);
	contentPane.add(l5);

	JLabel l6 = new JLabel("Mã sách");
	l6.setForeground(new Color(47, 79, 79));
	l6.setFont(new Font("Time new roman", Font.BOLD, 14));
	l6.setBounds(73, 51, 90, 22);
	contentPane.add(l6);

	JLabel l7 = new JLabel("Số lượng");
	l7.setForeground(new Color(47, 79, 79));
	l7.setFont(new Font("Time new roman", Font.BOLD, 14));
	l7.setBounds(73, 183, 90, 22);
	contentPane.add(l7);

	t1 = new JTextField();
	t1.setForeground(new Color(47, 79, 79));
	t1.setFont(new Font("Time new roman", Font.BOLD, 14));
	t1.setBounds(169, 54, 280, 20);
	contentPane.add(t1);
	t1.setColumns(10);

	t2 = new JTextField();
	t2.setForeground(new Color(47, 79, 79));
	t2.setFont(new Font("Time new roman", Font.BOLD, 14));
	t2.setColumns(10);
	t2.setBounds(169, 87, 280, 20);
	contentPane.add(t2);

	t3 = new JTextField();
	t3.setForeground(new Color(47, 79, 79));
	t3.setFont(new Font("Time new roman", Font.BOLD, 14));
	t3.setColumns(10);
	t3.setBounds(169, 120, 280, 20);
	contentPane.add(t3);

	t4 = new JTextField();
	t4.setForeground(new Color(47, 79, 79));
	t4.setFont(new Font("Time new roman", Font.BOLD, 14));
	t4.setColumns(10);
	t4.setBounds(169, 153, 280, 20);
	contentPane.add(t4);

        t7 = new JTextField();
	t7.setForeground(new Color(47, 79, 79));
	t7.setFont(new Font("Time new roman", Font.BOLD, 14));
	t7.setColumns(10);
	t7.setBounds(169, 188, 280, 20);
	contentPane.add(t7);
        
        t5 = new JTextField();
	t5.setForeground(new Color(47, 79, 79));
	t5.setFont(new Font("Time new roman", Font.BOLD, 14));
	t5.setColumns(10);
	t5.setBounds(169, 219, 280, 20);
	contentPane.add(t5);

	t6 = new JTextField();
	t6.setForeground(new Color(47, 79, 79));
	t6.setFont(new Font("Time new roman", Font.BOLD, 14));
	t6.setColumns(10);
	t6.setBounds(169, 252, 280, 20);
	contentPane.add(t6);

	

        b1 = new JButton("Tìm kiếm");
	b1.addActionListener(this);
	b1.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128)), null));
        b1.setFont(new Font("Time new roman", Font.BOLD, 15));
	b1.setBounds(72, 300, 100, 33);
        b1.setBackground(Color.BLUE);
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
	b3.setBounds(292, 300, 95, 33);
        b3.setBackground(Color.BLUE);
        b3.setForeground(Color.WHITE);
	contentPane.add(b3);


	b2 = new JButton("Back");
	b2.addActionListener(this);
	b2.setBorder(new CompoundBorder(new LineBorder(new Color(105, 105, 105)), null));
	b2.setFont(new Font("Time new roman", Font.BOLD, 15));
	b2.setBounds(182, 300, 97, 33);
        b2.setBackground(Color.BLUE);
        b2.setForeground(Color.WHITE);
	
	contentPane.add(b2);

	JPanel panel = new JPanel();
	panel.setBorder(new TitledBorder(new LineBorder(new Color(138, 43, 226), 2), "Cập nhật sách", TitledBorder.LEADING,
			TitledBorder.TOP, null, new Color(0, 0, 255)));
	panel.setBounds(10, 29, 475, 355);
	contentPane.add(panel);
        
        panel.setBackground(Color.WHITE);
        contentPane.setBackground(Color.WHITE);
//	random();
    t2.setEditable(false);
    t3.setEditable(false);
    t4.setEditable(false);
    t5.setEditable(false);
    t6.setEditable(false);
    t7.setEditable(false);
    }
    public boolean KiemTraRong(){
        if(t1.getText().isEmpty() )return false;
        if(t2.getText().isEmpty() )return false;
        if(t3.getText().isEmpty() )return false;
        if(t4.getText().isEmpty() )return false;
        if(t5.getText().isEmpty() )return false;
        if(t6.getText().isEmpty() )return false;                
        return true;
    }
    
    public void actionPerformed(ActionEvent ae){
       String bname = null;
       int dem = 0;
            try{
            conn con = new conn();
          bname = t2.getText();
            if(ae.getSource() == b1){
                 String sql = "select * from book where book_id = ?";
		PreparedStatement st = con.c.prepareStatement(sql);
		st.setString(1, t1.getText());
		ResultSet rs = st.executeQuery();
		
                while (rs.next()) {
                    t2.setText(rs.getString("name"));
                    t3.setText(rs.getString("isbn"));
                    t4.setText(rs.getString("publisher"));
                    t7.setText(rs.getString("number"));
                    t5.setText(rs.getString("price"));
                    t6.setText(rs.getString("pages"));
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
                
            }
            if(ae.getSource() == b2){
                this.setVisible(false);
		new Home().setVisible(true);

            }
            if(ae.getSource() == b3){
               
                 if(KiemTraRong()== false){
            JOptionPane.showMessageDialog(this,"Bạn chưa nhập đủ thông tin" );            
        }else{
                   
                 String sql = "update book set name= ?,isbn= ?,publisher=?,number= ?,price=?,pages = ? " + " where book_id = '"+t1.getText()+"'";
                PreparedStatement st = con.c.prepareStatement(sql);
                st.setString(2,t2.getText());
                st.setString(3,t3.getText());
                st.setString(4,t4.getText());
                st.setString(5,t7.getText());
                st.setString(6,t5.getText());
                st.setString(7,t6.getText());               
                
                if(st.executeUpdate() > 0){
                    JOptionPane.showMessageDialog(this,"Cập nhật thành công");
                }else{
                    JOptionPane.showMessageDialog(this, "Thất bại");
//                }
                
                 }
                 
                 }
            }
                 
//                  String sql = "delete from book where name = '" + bname + "'";
//		PreparedStatement st = con.c.prepareStatement(sql);
//
//		JDialog.setDefaultLookAndFeelDecorated(true);
//		int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
//                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
//		if (response == JOptionPane.YES_OPTION) {		
//                    int rs = st.executeUpdate();
//                    JOptionPane.showMessageDialog(null, "Deleted !!");}              
//                st.close();
//            JOptionPane.showMessageDialog(rootPane, "Delete");
//            }
//            con.c.close();
            
        }catch(Exception e){
            
       
        }
    }
       private void CapNhatActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try {
            conn con = new conn();
            String sql = "update book set name= ?,isbn= ?,publisher=?,number= ?,price=?,pages = ? " + " where book_id = '"+t1.getText()+"'";
            PreparedStatement st = con.c.prepareStatement(sql);
            st.setString(1,t2.getText());
            st.setString(2,t3.getText());
            st.setString(3,t4.getText());
            st.setString(4,t7.getText());           
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
