package com.example.jenna.library_of_alexandria_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toolbar;

import java.util.ArrayList;


public class SearchActivity extends AppCompatActivity {

    private ListView mListView;
    private BookAdapter mAdapter;
    private ArrayList<Book> mBookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Initialize the Person List
        mBookList = new ArrayList<>();
        initializeDefaultList();
        mListView = (ListView) findViewById(R.id.bookListView);
        // Create Adapter and associate it with our PersonList
        mAdapter = new BookAdapter(this, mBookList);
        mListView.setAdapter(mAdapter); 
        updateListCount();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present. getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Function to initialize default values for the person list (Change this later)
    private void initializeDefaultList() {
        mBookList.add(new Book("The Lovely Bones", "0-316-66634-3", "Alice Sebold", "Little, Brown", "45", 2002, "Novel", "It is the story of a teenage girl who, after being raped and murdered, watches from her personal Heaven as her family and friends struggle to move on with their lives while she comes to terms with her own death."));
        mBookList.add(new Book("Harry Potter: The Philosopher's Stone", "0-7475-3269-9", "J.K. Rowling", "Bloomsbury UK", "332 UK", 1997, "Fantasy", "It's a story around Harry who ..."));
        mBookList.add(new Book("Harry Potter: The Chamber of Secrets", "0-7475-3849-2", "J.K. Rowling", "Bloomsbury UK", "435 UK", 1998, "Fantasy", "It's a story around Harry who ..."));
        mBookList.add(new Book("Harry Potter: The Prisoner of Azkaban", "0-7475-4215-5", "J.K. Rowling", "Bloomsbury UK", "562 UK", 1999, "Fantasy", "It's a story around Harry who ..."));
    }

    private void updateListCount() {
        // Get total size of person list & set title
        int numBook = mBookList.size();
        setTitle("Total Book: " + numBook);
    }

    private void setSupportActionBar(Toolbar toolbar) {
    }
}
