package com.example.jenna.library_of_alexandria_android;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

import models.Book;

public class AddBookActivity extends AppCompatActivity implements
        View.OnClickListener{

    EditText mNameEditText;
    EditText mISBNEditText;
    EditText mAuthorEditText;
    EditText mPublisherEditText;
    EditText mEditionEditText;
    EditText mYearEditText;
    EditText mGenreEditText;
    EditText mDescEditText;
    Button mCreateBtn;
    Button mUpdateBtn;

    //Book mNewBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Create a new default Book object
        //mNewBook = new Book();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        // Instantiate UI elements
        mNameEditText = (EditText) findViewById(R.id.nameEditText);
        mISBNEditText = (EditText) findViewById(R.id.isbnEditText);
        mAuthorEditText = (EditText) findViewById(R.id.authorEditText);
        mPublisherEditText = (EditText) findViewById(R.id.publisherEditText);
        mEditionEditText = (EditText) findViewById(R.id.editionEditText);
        mYearEditText = (EditText) findViewById(R.id.yearEditText);
        mGenreEditText = (EditText) findViewById(R.id.genreEditText);
        mDescEditText = (EditText) findViewById(R.id.descEditText);
        mCreateBtn = (Button) findViewById(R.id.createBtn);
        mUpdateBtn = (Button) findViewById(R.id.updateBtn);

        // Set onClick Listener for Jedi button
        mCreateBtn.setOnClickListener(this);
        mUpdateBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.createBtn:
                createNewBook();
                break;

            case R.id.updateBtn:
                updateBook();
                break;

            default:
                break;
        }
//        // Run Validation before creating jedi object
//        // Set Jedi to contain user input
//        mNewBook = new Book();
//        mNewBook.setmName(name);
//        mNewBook.setmISBN(isbn);
//        mNewBook.setmAuthor(author);
//        mNewBook.setmPublisher(publisher);
//        mNewBook.setmEdition(edition);
//        mNewBook.setmYear(year);
//        mNewBook.setmGenre(genre);
//        mNewBook.setmDesc(desc);


        // Create new intent and put in Book object
//        Intent newIntent = new Intent(this, AddBookActivity.class);
//        newIntent.putExtra("Book", String.valueOf(mNewBook));
//        startActivity(newIntent);
    }

    public void createNewBook() {
        // Get user input
        String name = mNameEditText.getText().toString();
        String isbn = mISBNEditText.getText().toString();

        if(name.length() > 0 && isbn.length()>0){
            //String author = mAuthorEditText.getText().toString() || "";

            if(mAuthorEditText.length() == 0) {
                String author = "" ;
                String publisher = "" ;
                String edition = "" ;
                int year = 0 ;
                String genre = "" ;
                String desc = "" ;
                Book newBook = new Book(0, name, isbn, author, publisher, edition, year, genre, desc);

                // Create new intent, pass information & finish
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("result", newBook);
                setResult(RESULT_OK, intent);
                finish();

            } else {
                String author = mAuthorEditText.getText().toString();
                String publisher = mPublisherEditText.getText().toString();
                String edition = mEditionEditText.getText().toString();
                int year = Integer.parseInt(mYearEditText.getText().toString());
                String genre = mGenreEditText.getText().toString();
                String desc = mDescEditText.getText().toString();

                Book newBook = new Book(0, name, isbn, author, publisher, edition, year, genre, desc);

                // Create new intent, pass information & finish
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("result", newBook);
                setResult(RESULT_OK, intent);
                finish();
            }
        } else {
            AlertDialog.Builder builder
                    = new AlertDialog.Builder(AddBookActivity.this);
            builder.setTitle("Input Request");
            builder.setMessage("Book name and ISBN cannot be empty.");
            builder.setPositiveButton("Ok", null);
            builder.show();

        }
    }

    public void updateBook() {
        // Get user input
        String name = mNameEditText.getText().toString();
        String isbn = mISBNEditText.getText().toString();

        if(name.length() > 0 && isbn.length()>0){
            //String author = mAuthorEditText.getText().toString() || "";

            if(mAuthorEditText.length() == 0) {
                String author = "" ;
                String publisher = "" ;
                String edition = "" ;
                int year = 0 ;
                String genre = "" ;
                String desc = "" ;
                Book newBook = new Book(0, name, isbn, author, publisher, edition, year, genre, desc);

                // Create new intent, pass information & finish
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("result", newBook);
                setResult(RESULT_OK, intent);
                finish();

            } else {
                String author = mAuthorEditText.getText().toString();
                String publisher = mPublisherEditText.getText().toString();
                String edition = mEditionEditText.getText().toString();
                int year = Integer.parseInt(mYearEditText.getText().toString());
                String genre = mGenreEditText.getText().toString();
                String desc = mDescEditText.getText().toString();

                Book newBook = new Book(0, name, isbn, author, publisher, edition, year, genre, desc);

                // Create new intent, pass information & finish
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("result", newBook);
                setResult(RESULT_OK, intent);
                finish();
            }
        } else {
            AlertDialog.Builder builder
                    = new AlertDialog.Builder(AddBookActivity.this);
            builder.setTitle("Input Request");
            builder.setMessage("Book name and ISBN cannot be empty.");
            builder.setPositiveButton("Ok", null);
            builder.show();

        }
    }
}
