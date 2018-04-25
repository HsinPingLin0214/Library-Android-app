package com.example.jenna.library_of_alexandria_android;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import models.Book;

import java.util.ArrayList;

public class BookAdapter extends BaseAdapter implements Filterable {

    private Context mCurrentContext;
    private ArrayList<Book> mBookList;
    private ArrayList<Book> mFilteredList;
    private BookFilter mFilter;

    public BookAdapter(Context con, ArrayList<Book> booklist) {
        mCurrentContext = con;
        mBookList = booklist;
        mFilteredList = mBookList;
    }

    @Override
    public int getCount() {
        return mFilteredList.size();
    }

    @Override
    public Object getItem(int position) {
        return mFilteredList.get(position);
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

        // Assign values to the TextViews using Book Object
        TextView nameView = (TextView) view.findViewById(R.id.listNameTextView);
        TextView authorView = (TextView) view.findViewById(R.id.listAuthorTextView);
        nameView.setText(mFilteredList.get(position).getmName());
        authorView.setText(mFilteredList.get(position).getmAuthor());

        return view;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }

    @Override
    public Filter getFilter() {
        if(mFilter == null) {
            mFilter = new BookFilter();
        }
        return mFilter;
    }

    private class BookFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            if (constraint != null && constraint.length() > 0) {
                ArrayList<Book> tempList = new ArrayList<>();

                for (Book book : mBookList) {
                    if (book.getmName().toLowerCase().contains(constraint.toString().toLowerCase()))
                        tempList.add(book);
                }
                results.count = tempList.size();
                results.values = tempList;
            } else {
                results.count = mBookList.size();
                results.values = mBookList;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mFilteredList = (ArrayList<Book>) results.values;
            notifyDataSetChanged();
        }
    }
}
