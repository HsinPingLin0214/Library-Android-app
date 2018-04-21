package com.example.jenna.library_of_alexandria_android;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.ArrayList;

import models.Book;
import models.DatabaseHelper;

public class BookDetailsActivity extends AppCompatActivity {

    private DatabaseHelper mDBHelper;

    Book mBook;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Get our database handler
        mDBHelper = new DatabaseHelper(getApplicationContext());

        Intent intent = getIntent();
        mBook = intent.getParcelableExtra("Book");
        TextView nameView = (TextView) findViewById(R.id.nameDisplayTextView);
        nameView.setText(mBook.toString());

        TextView isbnView = (TextView) findViewById(R.id.isbnDisplayTextView);
        isbnView.setText(mBook.toString());

        TextView authorView = (TextView) findViewById(R.id.authorDisplayTextView);
        authorView.setText(mBook.toString());

        TextView publisherView = (TextView) findViewById(R.id.publisherDisplayTextView);
        publisherView.setText(mBook.toString());

        TextView editionView = (TextView) findViewById(R.id.editionDisplayTextView);
        editionView.setText(mBook.toString());

        TextView yearView = (TextView) findViewById(R.id.yearDisplayTextView);
        yearView.setText(mBook.toString());

        TextView genreView = (TextView) findViewById(R.id.genreDisplayTextView);
        genreView.setText(mBook.toString());
    }

    private void setSupportActionBar(Toolbar toolbar) {
    }
}
