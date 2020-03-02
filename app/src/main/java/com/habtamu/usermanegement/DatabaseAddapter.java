package com.habtamu.usermanegement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseAddapter extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="user.db";
    public static final String TABLE_NAME="user_table";
    public  static final String Col_1="user_Id";
    public  static final String Col_2="fullName";
    public  static final String Col_3="userName";
    public  static final String Col_4="email";
    public  static final String Col_5="password";
    public  static final String Col_6="confirm_password";
    public  static final String Col_7="phoneNumber";
    public  static final String Col_8="gender";
    //SQLiteDatabase db=this.getWritableDatabase();
    public DatabaseAddapter( Context context) {
        super(context, DATABASE_NAME, null, 1);
       // SQLiteDatabase datbase=this.getReadableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
db.execSQL("create table "+TABLE_NAME +
        " (user_Id INTEGER PRIMARY KEY AUTOINCREMENT,fullName TEXT,userName TEXT ,email TEXT,password TEXT,confirm_password TEXT,phoneNumber TEXT,gender TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
db.execSQL("DROP TABLE  If exists "+TABLE_NAME);
onCreate(db);
    }
    boolean insertData(String fullname,String username,String email,
                       String passwored,String confirmPassword,
                       String phonenumber,String gender) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Col_2, fullname);
        values.put(Col_3, username);
        values.put(Col_4, email);
        values.put(Col_5, passwored);
        values.put(Col_6, confirmPassword);
        values.put(Col_7, phonenumber);
        values.put(Col_8, gender);
      long result = db.insert(TABLE_NAME, Col_1, values);
if(result==-1)
    return false;
    else
        return true;
    }
    public Cursor getAllmodels(){
        SQLiteDatabase db=this.getReadableDatabase();
      String[] columns={Col_1,Col_2,Col_3,Col_4,Col_5,Col_6,Col_7,Col_8};
      return db.query(TABLE_NAME,columns,null,null,null,null,null);
    }
    public  long delete(int id){
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(TABLE_NAME,Col_1+"=?",new String[]{String.valueOf(id)
        });
    }
    }

