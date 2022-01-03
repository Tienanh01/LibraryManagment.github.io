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
public class loginController {
    public ResultSet login(String user,String pass){
            conn con = new conn();
        try {
            String sql = "select * from account where username=? and password=?";
            PreparedStatement st = con.c.prepareStatement(sql);
            
            st.setString(1, user);
            st.setString(2, pass);
            
            ResultSet rs = st.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
