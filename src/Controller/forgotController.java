/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ProTech
 */
public class forgotController {
    conn con = new conn();
    public ResultSet forgot(String username){
        try {
            String sql = "select * from account where username=?";
            PreparedStatement st = con.c.prepareStatement(sql);
            
            st.setString(1,username);
            ResultSet rs = st.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(forgotController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ResultSet getPass (String combobox1){
        try {
            String sql = "select * from account where sec_ans=?";
            PreparedStatement st = con.c.prepareStatement(sql);
            
            st.setString(1, combobox1);
            ResultSet rs = st.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(forgotController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
