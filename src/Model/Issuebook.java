/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author ProTech
 */
public class Issuebook {
    private String book_id;
    private String student_id;
    private String bName;
    private String heDT;
    private String brach;

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public String getHeDT() {
        return heDT;
    }

    public void setHeDT(String heDT) {
        this.heDT = heDT;
    }

    public String getBrach() {
        return brach;
    }

    public void setBrach(String brach) {
        this.brach = brach;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }
    Date dateOfIssue;
}
