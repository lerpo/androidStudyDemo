package com.example.androiddemo.datastore;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;

public class DataBaseUtil {
    private static DataBaseUtil instance;
    private DataBaseUtil(){};
    private static SQLiteDatabase db;
    public static synchronized DataBaseUtil getInstance(Context context) {
       if (instance == null) {
           DatabaseHelper databaseHelper = new DatabaseHelper(context,"user.db", null,1);
           databaseHelper.getWritableDatabase();
           db = databaseHelper.getWritableDatabase();
          instance = new DataBaseUtil();
       }
        return instance;
    }

    /**
     * 增加一个用户
     * @param qname
     * @param qage
     * @param qsex
     */
    public void add(String qname,Integer qage,String qsex) {
        ContentValues values = new ContentValues();
        values.put("name",qname);
        values.put("age",qage);
        values.put("sex",qsex);
        db.insert("user",null,values);

//        db.execSQL("insert into user(name, age, sex) values(?,?,?,?)", new String[]{qname,qage,qsex});
    }

    /**
     * 更新用户名称
     * @param qname
     */
    public void update(String qname, String qUpadateName) {

        ContentValues values = new ContentValues();
        values.put("name",qUpadateName);
        db.update("user",values,"name= ?",new String[]{qname});

//        db.execSQL("update user set qname = ? where id = ?", new String[]{qId+"",qname});
    }

    /**
     * 删除指定用户名的用户
     * @param qname
     */
    public void delete(String qname) {
        db.delete("user","name = ?",new String[]{qname});

//        db.execSQL("delete from user where qname = ?", new String[]{qname});
    }

    /**
     * 查询所有用户
     */
    public ArrayList query() {
        ArrayList userList = new ArrayList();
        Cursor cursor = db.query("user",null,null,null,null,null,null);
        if(cursor.moveToFirst()){
            do{
                String name = cursor.getString(cursor.getColumnIndex("name"));
                int age = cursor.getInt(cursor.getColumnIndex("age"));
                String sex = cursor.getString(cursor.getColumnIndex("sex"));
                userList.add(name+","+age+","+sex);
            }while(cursor.moveToNext());
        }
        cursor.close();
        return userList;
//        db.execSQL("select * from user", null);
    }

    public Cursor queryReturnCursor() {
        Cursor cursor = db.query("user",null,null,null,null,null,null);

        return cursor;
//        db.execSQL("select * from user", null);
    }

}
