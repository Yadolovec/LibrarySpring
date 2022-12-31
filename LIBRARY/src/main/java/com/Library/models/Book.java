package com.Library.models;

public class Book {


    private Integer book_id;
    private String bookName;
    private String author;
    private Integer yearOfPublication;
    private Integer person_id;

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
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

    public Book(Integer book_id, String bookName, String author, Integer yearOfPublication, Integer person_id) {
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
