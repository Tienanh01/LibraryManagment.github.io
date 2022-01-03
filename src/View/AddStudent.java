package View;

import Controller.studentController;
import Model.student;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
   
public class AddStudent extends JFrame implements ActionListener{
   
    private JPanel contentPane;
    private JTextField t1,t2,t3;
    private JComboBox comboBox, comboBox_1, comboBox_2, comboBox_3;
    JButton b1,b2;

    public static void main(String[] args) {
        new AddStudent().setVisible(true);
    }

//    public void random() {
//        Random rd = new Random();
//	t1.setText("" + rd.nextInt(10000 + 1));
//    }

    public AddStudent() {
        super("Thêm sinh viên");
	setBounds(600, 200, 475, 442);
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
	t1.setBounds(174, 66, 220, 20);
	contentPane.add(t1);
	t1.setColumns(10);

	t2 = new JTextField();
	t2.setForeground(new Color(47, 79, 79));
	t2.setFont(new Font("Time new roman", Font.BOLD, 14));
	t2.setColumns(10);
	t2.setBounds(174, 100, 220, 20);
	contentPane.add(t2);

	t3 = new JTextField();
	t3.setForeground(new Color(47, 79, 79));
	t3.setFont(new Font("Time new roman", Font.BOLD, 14));
	t3.setColumns(10);
	t3.setBounds(174, 133, 220, 20);
	contentPane.add(t3);

	comboBox = new JComboBox();
	comboBox.setModel(new DefaultComboBoxModel(new String[] { "ATTT","CNTT","DTVT"}));
	comboBox.setForeground(new Color(47, 79, 79));
	comboBox.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	comboBox.setBounds(176, 211, 220, 20);
	contentPane.add(comboBox);

	comboBox_1 = new JComboBox();
	comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4","5" }));
	comboBox_1.setForeground(new Color(47, 79, 79));
	comboBox_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	comboBox_1.setBounds(176, 244, 220, 20);
	contentPane.add(comboBox_1);

	comboBox_2 = new JComboBox();
	comboBox_2.setModel(
			new DefaultComboBoxModel(new String[] { "1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th","9th" }));
	comboBox_2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	comboBox_2.setForeground(new Color(47, 79, 79));
	comboBox_2.setBounds(176, 277, 220, 20);
	contentPane.add(comboBox_2);

	b1 = new JButton("Thêm");
	b1.addActionListener(this);
	b1.setFont(new Font("Time new roman", Font.BOLD, 14));
	b1.setBounds(87, 330, 100, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
	contentPane.add(b1);

	b2 = new JButton("Back");
	b2.addActionListener(this);
	b2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
	b2.setBounds(273, 330, 100, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
	contentPane.add(b2);

	JLabel l7 = new JLabel("Hệ học");
	l7.setForeground(new Color(25, 25, 112));
	l7.setFont(new Font("Time new roman", Font.BOLD, 14));
	l7.setBounds(64, 173, 102, 22);
	contentPane.add(l7);

	comboBox_3 = new JComboBox();
	comboBox_3.setModel(new DefaultComboBoxModel(
			new String[] { "HQS","HDS"}));
	comboBox_3.setForeground(new Color(47, 79, 79));
	comboBox_3.setFont(new Font("Time new roman", Font.BOLD, 14));
	comboBox_3.setBounds(176, 176, 220, 20);
	contentPane.add(comboBox_3);

	JPanel panel = new JPanel();
	panel.setBorder(new TitledBorder(new LineBorder(new Color(102, 205, 170), 2, true), "Thêm sinh viên",
			TitledBorder.LEADING, TitledBorder.TOP, null, new Color(30, 144, 255)));
	panel.setBackground(new Color(211, 211, 211));
	panel.setBounds(30, 20, 398, 364);
        
        contentPane.setBackground(Color.WHITE);
        panel.setBackground(Color.WHITE);
        
	contentPane.add(panel);
//	random();
    }
    
    public void actionPerformed(ActionEvent ae){
        ArrayList<student> listS = new ArrayList<>();
        try{
            if(ae.getSource() == b1){              
                 student s = new student();
                s.setStudent_id(t1.getText());
                s.setName(t2.getText());
                s.setDob(t3.getText());
                s.setCourse((String)comboBox_3.getSelectedItem());
                s.setMajors((String) comboBox.getSelectedItem());
                s.setYear((String) comboBox_1.getSelectedItem());
                s.setSemester((String) comboBox_2.getSelectedItem());
                    studentController scl = new studentController();

                    int i = scl.addStudent(s);
		if (i > 0){
                    JOptionPane.showMessageDialog(null, "Thêm thành công");
                    this.setVisible(false);
                    new Home().setVisible(true);
                }
		else
                    JOptionPane.showMessageDialog(null, "error");               
            }
            
            if(ae.getSource() == b2){
                this.setVisible(false);
		new Home().setVisible(true);		
            }
        }catch(Exception e){
            
        }
    }
}

