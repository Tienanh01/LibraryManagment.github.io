/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.student;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ProTech
 */
public class studentController {            
    ArrayList<student> list = new ArrayList<>();
     conn con = new conn();
    
   public int addStudent(student stmd) throws ClassNotFoundException{
       int i = 0;
        try {            
            String sql = "insert into student(student_id , name, dob, course, Nganhhoc, year, semester) values(?, ?, ?, ?, ?, ?, ?)";
         PreparedStatement st = con.c.prepareStatement(sql);           
            st.setString(1, stmd.getStudent_id());
            st.setString(2, stmd.getName());
            st.setString(3, stmd.getDob());
            st.setString(4, stmd.getCourse());
            st.setString(5, stmd.getMajors());
            st.setString(6, stmd.getYear());
            st.setString(7, stmd.getSemester());        
            i = st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(studentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
   }
    public ArrayList<student> getListStudent(){
        ArrayList<student> list = new ArrayList<>();
        String sql = "SELECT * FROM tblStudent";
        
        try {
            PreparedStatement ps = con.c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                student s = new student();
                s.setStudent_id(rs.getString("student_id"));
                s.setName(rs.getString("name"));
                s.setDob(rs.getString("dob"));
                s.setCourse(rs.getString("course"));
                s.setMajors(rs.getString("Nganhhoc"));
                s.setYear(rs.getString("year"));
                s.setSemester(rs.getString("semester"));
                
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }
}
