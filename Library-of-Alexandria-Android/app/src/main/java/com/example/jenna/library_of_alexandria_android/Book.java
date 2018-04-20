package com.example.jenna.library_of_alexandria_android;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jenna on 9/4/18.
 */

@SuppressLint("ParcelCreator")
public class Book implements Parcelable {
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

    protected Book(Parcel in) {
        mName = in.readString();
        mISBN = in.readString();
        mAuthor = in.readString();
        mPublisher = in.readString();
        mEdition = in.readString();
        mYear = in.readInt();
        mGenre = in.readString();
        mDesc = in.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeString(mISBN);
        dest.writeString(mAuthor);
        dest.writeString(mPublisher);
        dest.writeString(mEdition);
        dest.writeInt(mYear);
        dest.writeString(mGenre);
        dest.writeString(mDesc);
    }
}
