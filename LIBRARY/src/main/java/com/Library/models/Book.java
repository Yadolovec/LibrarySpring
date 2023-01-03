package com.Library.models;

import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class Book {


    private int book_id;
    @NotEmpty(message = "Book has to have a name")
    private String bookName;
    private String author;


    private Integer yearOfPublication;
    private Integer person_id;

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

    public Integer getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(Integer yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public Integer getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Integer person_id) {
        this.person_id = person_id;
    }

    public Book(int book_id, String bookName, String author, Integer yearOfPublication, Integer person_id) {
        this.book_id = book_id;
        this.bookName = bookName;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
        this.person_id = person_id;
    }

    public Book(){}

    public String forShow(){
        String toReturn = bookName;

        if (!author.isEmpty())
            toReturn=toReturn+", by "+author;
        if (yearOfPublication!=null)
            toReturn=toReturn+", "+yearOfPublication;
        return toReturn;
    }


}
