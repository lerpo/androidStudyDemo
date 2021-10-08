package com.example.androiddemo.datastore;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String CREATE_BOOK = "create table user ( "
            + "id integer primary key autoincrement,"
            + "name text,"
            + "age real,"
            + "sex text)";
    private Context context;
    public DatabaseHelper (Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BOOK);
    }

    //当打开数据库时传入的版本号与当前的版本号不同时会调用该方法
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
