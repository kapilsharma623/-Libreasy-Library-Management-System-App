package com.example.litereasy.models;

import android.net.Uri;

public class addnewbookmodel {
    String bookid,bookname,subject,author,date,quantity,description;
    String bookimage;


    public addnewbookmodel() {
    }

    public addnewbookmodel(String bookid,String bookname, String subject, String author, String date, String quantity, String description, String bookimage) {
        this.bookid=bookid;
        this.bookname = bookname;
        this.subject = subject;
        this.author = author;
        this.date = date;
        this.quantity = quantity;
        this.description = description;
        this.bookimage = bookimage;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBookimage() {
        return bookimage;
    }

    public void setBookimage(String bookimage) {
        this.bookimage = bookimage;
    }
}
