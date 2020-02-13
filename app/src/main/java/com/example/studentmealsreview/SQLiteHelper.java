package com.example.studentmealsreview;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;
import java.util.List;

//import androidx.annotation.Nullable;

public class SQLiteHelper  extends SQLiteOpenHelper {
    public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public void queryData(String sql){
        SQLiteDatabase database =getWritableDatabase();
        database.execSQL(sql);
    }
    public void insertStudentData(String name,String regNo, String Course,String year){
        SQLiteDatabase database = getWritableDatabase();
        String sql ="INSERT INTO student VALUES(?,?,?,?)";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1,name);
        statement.bindString(2,regNo);
        statement.bindString(3,Course);
        statement.bindString(4,year);
        statement.executeInsert();
    }
    public void insertUsersData(String name,String username, String password){
        SQLiteDatabase database = getWritableDatabase();
        String sql ="INSERT INTO users VALUES(?,?,?)";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1,name);
        statement.bindString(2,username);
        statement.bindString(3,password);
        statement.executeInsert();
    }
    public boolean checkReg(String regNo){
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor cursor=database.rawQuery("SELECT * FROM student WHERE regNo=?",new String[]{regNo});
        if (cursor.getCount()>0) return false;
        else return true;
    }
    public String  getAllStudents(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT name FROM student",new String[]{});
        return String.valueOf(cursor);
    }
    public boolean checkUsername(String username){
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor cursor=database.rawQuery("SELECT * FROM users WHERE username=?",new String[]{username});
        if (cursor.getCount()>0) return false;
        else return true;
    }
    public boolean login(String username,String password){
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor cursor=database.rawQuery("SELECT * FROM users WHERE username=? AND password=?",new String[]{username,password});
        if (cursor.getCount()>1) return true;
        else return false;
    }
    public boolean allUsers(){
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor cursor=database.rawQuery("SELECT * FROM user",new String[]{});
        if (cursor.getCount()<0) return false;
        else return true;
    }
    public Cursor getUser(String sql){
        SQLiteDatabase database=getReadableDatabase();
        return database.rawQuery(sql,null);
    }
    //public List<String> getAll(){
//        List<String> list =new ArrayList<String>();
//        String sql="SELECT * FROM student";
//        SQLiteDatabase db= this.getReadableDatabase();
//        Cursor cursor=db.rawQuery(sql,null);
//        if (cursor.moveToFirst()){
//            do {
//                    list.add(cursor.getString(2));
//                }
//                while (cursor.moveToNext());
//            }
//            cursor.close();
//            db.close();
//            return list;
//        }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
