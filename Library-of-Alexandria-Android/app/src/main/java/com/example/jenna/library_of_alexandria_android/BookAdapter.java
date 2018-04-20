package com.example.jenna.library_of_alexandria_android;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import models.Book;

import java.util.ArrayList;

public class BookAdapter extends BaseAdapter {

    private Context mCurrentContext;
    private ArrayList<Book> mBookList;
    public BookAdapter(Context con, ArrayList<Book> book) {
        mCurrentContext = con;
        mBookList = book;
    }
    @Override
    public int getCount() {
        return mBookList.size();
    }

    @Override
    public Object getItem(int position) {
        return mBookList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        // Check if view already exists. If not inflate it
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) mCurrentContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // Create a list item based off layout definition
            view = inflater.inflate(R.layout.list_book_item, null);
        }

        // Assign values to the TextViews using Person Object
        TextView nameView = (TextView) view.findViewById(R.id.listNameTextView);
        TextView continentView = (TextView) view.findViewById(R.id.listAuthorTextView);
        nameView.setText(mBookList.get(position).getmName());
        continentView.setText(mBookList.get(position).getmAuthor());

        return view;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}
