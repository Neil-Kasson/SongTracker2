package com.example.songtracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collections;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "list.db";
    public static final String TABLE_NAME = "LIST_TABLE";
    public static final String COL_1 = "Date";
    public static final String COL_2 = "Name";
    public static final String COL_3 = "ID";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+" (Date TEXT, Name TEXT, ID INTEGER PRIMARY KEY AUTOINCREMENT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String date, String name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_1, date);
        cv.put(COL_2, name);
        long result = db.insert(TABLE_NAME, null, cv);
        if(result==-1)
            return false;
        else
            return true;
    }

    public int getSize(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM "+TABLE_NAME, null);
        int count = c.getCount();
        c.close();
        return count;
    }

    public ArrayList<Item> getData(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM "+TABLE_NAME, null);
        ArrayList<Item> things = new ArrayList<Item>();
        while(c.moveToNext()){
            things.add(new Item(c.getString(0), c.getString(1)));
        }
        c.close();
        Collections.reverse(things);
        return things;
    }



}
