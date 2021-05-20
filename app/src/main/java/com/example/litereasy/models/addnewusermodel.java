package com.example.litereasy.models;

public class addnewusermodel {
    String address,bookid,bookname,date,duedate,email,name,phone,quantity,userid;
    public addnewusermodel() {
    }

    public addnewusermodel(String address, String bookid, String bookname, String date, String duedate, String email, String name, String phone, String quantity, String userid) {
        this.address = address;
        this.bookid = bookid;
        this.bookname = bookname;
        this.date = date;
        this.duedate = duedate;
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.quantity = quantity;
        this.userid = userid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
