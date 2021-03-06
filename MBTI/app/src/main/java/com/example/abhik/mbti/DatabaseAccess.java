package com.example.abhik.mbti;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhik on 26/10/17.
 */

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    public DatabaseAccess(MBTIquestionarre context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }



    public static DatabaseAccess getInstance(MBTIquestionarre context){
        if(instance == null){
            instance = new DatabaseAccess(context);
        }
        return  instance;
    }

    public  void open(){
        this.database = openHelper.getWritableDatabase();
    }

    public void close(){
        if (database != null){
            this.database.close();
        }
    }

    public List<String> getQuestion(){
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT Question FROM Questions" , null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public List<Integer> getID() {
        List<Integer> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT ID FROM Questions" , null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getInt(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public List<String> getOptionA(){
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT OptionA FROM Questions" , null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public List<String> getOptionB(){
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT OptionB FROM Questions" , null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
}
