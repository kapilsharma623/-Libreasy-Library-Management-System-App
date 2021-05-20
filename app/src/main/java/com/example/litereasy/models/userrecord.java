package com.example.litereasy.models;

public class userrecord {
    String username,userid,bookid,bookname,date,duedate,quantity;

    public userrecord() {
    }

    public userrecord(String username, String userid, String bookid, String bookname, String date, String duedate, String quantity) {
        this.username = username;
        this.userid = userid;
        this.bookid = bookid;
        this.bookname = bookname;
        this.date = date;
        this.duedate = duedate;
        this.quantity = quantity;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDuedate() {
        return duedate;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
