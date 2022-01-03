/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.book;
import Model.student;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ProTech
 */
public class bookController {
        conn con = new conn();
     public int addBook(book b){
       int i = 0;
        try {
            String sql = "insert into book(book_id, name, isbn, publisher, number, price, pages) values(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement st = con.c.prepareStatement(sql);
                // st.setInt(1, Integer.parseInt(textField.getText()));                
		st.setString(1,b.getBook_id() );
		st.setString(2, b.getName());
		st.setString(3, b.getIsbn());
		st.setString(4, b.getPubliser());
		st.setString(5, b.getEdition());
		st.setString(6, b.getPrice());
		st.setString(7, b.getPages());

		i = st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(studentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
   }
     
               
}
