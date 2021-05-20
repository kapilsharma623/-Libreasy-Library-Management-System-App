package com.example.litereasy.models;

public class allbooksmodel {
   String bookid,bookname,subject,author,quantity,description,bookimage,soldbooks;

    allbooksmodel()
    {

    }

    public allbooksmodel(String bookid, String bookname, String subject, String author, String quantity, String description, String bookimage, String soldbooks) {
        this.bookid = bookid;
        this.bookname = bookname;
        this.subject = subject;
        this.author = author;
        this.quantity = quantity;
        this.description = description;
        this.bookimage = bookimage;
        this.soldbooks = soldbooks;
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

    public String getSoldbooks() {
        return soldbooks;
    }

    public void setSoldbooks(String soldbooks) {
        this.soldbooks = soldbooks;
    }
}
