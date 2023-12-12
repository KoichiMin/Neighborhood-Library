package com.pluralsight;

public class Book {

    int id;
    String isbn;
    String title;
    boolean isCheckedOut;
    String checkedOutTo;

    public Book(int id, String isbn, String title){
        this.id = id;
        this.isbn = isbn;
        this.title = title;
    }

    public void checkOut(String name){
        this.checkedOutTo = name;
        this.isCheckedOut = true;
    }

    public void checkIn(){
        this.checkedOutTo = "";
        this.isCheckedOut = false;
    }





}
