package com.example.a71task.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.a71task.model.Note;
import com.example.a71task.util.Util;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(@Nullable Context context) {
        super(context, Util.DATABASE_NAME,null,  Util.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE = "CREATE TABLE " + Util.TABLE_NAME + "(" + Util.NOTE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Util.NOTE_TEXT + " TEXT)";

        db.execSQL(CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insertNote(Note note){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Util.NOTE_TEXT, note.getNote_text());
        long rowid = db.insert(Util.TABLE_NAME, null, cv);
        db.close();
        return  rowid;
    }

    public List<Note> listAllNotes(){
        List<Note> noteList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String SelectAll = " SELECT * FROM "+ Util.TABLE_NAME;
        Cursor cursor = db.rawQuery(SelectAll, null);
        if (cursor.moveToFirst()){
            do {
                Note note = new Note();
                note.setNote_id(cursor.getInt(0));
                note.setNote_text(cursor.getString(1));

                noteList.add(note);

            }while (cursor.moveToNext());
        }
        return noteList;
    }

    public int updateText(Note note, int id){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Util.NOTE_TEXT, note.getNote_text());

        return  db.update(Util.TABLE_NAME, cv, Util.NOTE_ID.toString() +"=?", new String[]{String.valueOf(id)});
    }


    public void deleterow(int noteid) {
        SQLiteDatabase db = this.getWritableDatabase();
        String q = "DELETE FROM " + Util.TABLE_NAME + " WHERE " + Util.NOTE_ID + " = " + noteid;

        db.execSQL(q);
    }
}
