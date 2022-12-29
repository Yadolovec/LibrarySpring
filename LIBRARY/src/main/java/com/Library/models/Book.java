package com.Library.models;

public class Book {


    private int book_id;
    private String bookName;
    private String author;
    private int yearOfPublication;
    private int user_id;

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }


    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Book(int book_id, String bookName, String author, int yearOfPublication, int user_id) {
        this.book_id = book_id;
        this.bookName = bookName;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
        this.user_id = user_id;
    }

    public Book(){}
}
