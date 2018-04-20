package models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by jenna on 21/3/18.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    // Set Database Properties
    public static final String DATABASE_NAME = "BookDB";
    public static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Book.CREATE_STATEMENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Book.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void addBook(Book book) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Book.COLUMN_NAME, book.getmName());
        values.put(Book.COLUMN_ISBN, book.getmISBN());
        values.put(Book.COLUMN_AUTHOR, book.getmAuthor());
        values.put(Book.COLUMN_PUBLISHER, book.getmPublisher());
        values.put(Book.COLUMN_EDITION, book.getmEdition());
        values.put(String.valueOf(Book.COLUMN_YEAR), book.getmYear());
        values.put(Book.COLUMN_GENRE, book.getmGenre());
        values.put(Book.COLUMN_DESC, book.getmDesc());
        db.insert(Book.TABLE_NAME, null, values);
        db.close();
    }

    public HashMap<Long, Book> getAllBooks() {
        HashMap<Long, Book> books = new LinkedHashMap<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + Book.TABLE_NAME, null);
        // Add each book to hashmap (Each row has 1 book)
        while (cursor.moveToNext()) {
            Book book = new Book(cursor.getLong(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getInt(6),
                    cursor.getString(7),
                    cursor.getString(8));
            books.put(book.getId(), book);
        }
        cursor.close();
        db.close();

        if(books.size() == 0) {
            // If there are no book in the db then add some default book
            createDefaultBooks();
            books = getAllBooks();
        }
        return books;
    }

    public void removeBook(Book book)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Book.TABLE_NAME,
                Book.COLUMN_ID + " = ?",
                new String[] {String.valueOf(Book.getId())});
    }

    private void createDefaultBooks() {
        addBook(new Book(0, "The Lovely Bones", "0-316-66634-3", "Alice Sebold", "Little, Brown", "45", 2002, "Novel", "It is the story of a teenage girl who, after being raped and murdered, watches from her personal Heaven as her family and friends struggle to move on with their lives while she comes to terms with her own death."));
        addBook(new Book(1, "Harry Potter: The Philosopher's Stone", "0-7475-3269-9", "J.K. Rowling", "Bloomsbury UK", "332 UK", 1997, "Fantasy", "It's a story around Harry who ..."));
        addBook(new Book(2, "Harry Potter: The Chamber of Secrets", "0-7475-3849-2", "J.K. Rowling", "Bloomsbury UK", "435 UK", 1998, "Fantasy", "It's a story around Harry who ..."));
        addBook(new Book(3, "Harry Potter: The Prisoner of Azkaban", "0-7475-4215-5", "J.K. Rowling", "Bloomsbury UK", "562 UK", 1999, "Fantasy", "It's a story around Harry who ..."));
    }

}