package com.example.jenna.library_of_alexandria_android;

/**
 * Created by jenna on 9/4/18.
 */

public class Book {
    private String mName;
    private String mISBN;
    private String mAuthor;
    private String mPublisher;
    private String mEdition;
    private int mYear;
    private String mGenre;
    private String mDesc;

    public Book() {
        mName = "Book name";
        mISBN = "ISBN";
        mAuthor = "Author name";
        mPublisher = "Publisher name";
        mEdition = "Edition";
        mYear = 0;
        mGenre = "Genre type";
        mDesc = "Description";
    }

    public Book(String name, String isbn, String author, String publisher, String edition, int year, String genre, String desc) {
        mName = name;
        mISBN = isbn;
        mAuthor = author;
        mPublisher = publisher;
        mEdition = edition;
        mYear = year;
        mGenre = genre;
        mDesc = desc;
    }

    public String getmName() {return mName;}
    public String getmISBN() {return mISBN;}
    public String getmAuthor() {return mAuthor;}
    public String getmPublisher() {return mPublisher;}
    public String getmEdition() {return mEdition;}
    public int getmYear() {return mYear;}
    public String getmGenre() {return mGenre;}
    public String getmDesc() {return mDesc;}

    public void setmName(String name) {mName = name;}
    public void setmISBN(String isbn) {mISBN =isbn;}
    public void setmAuthor(String author) {mAuthor = author;}
    public void setmPublisher(String publisher) {mPublisher = publisher;}
    public void setmEdition(String edition) {mEdition = edition;}
    public void setmYear(int year) {mYear = year;}
    public void setmGenre(String genre) {mGenre = genre;}
    public void setmDesc(String desc) {mDesc = desc;}

    public String bookSummary() {
        return "Book name: " + mName + ". ISBN: " + mISBN + ". Author: " + mAuthor + ". Publisher: " + mPublisher + ". Edition: " + mEdition + ". Year: " + mYear + ". Genre: " + mGenre + ". Description: " + mDesc;
    }
}
