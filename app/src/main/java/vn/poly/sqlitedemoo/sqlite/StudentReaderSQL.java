package vn.poly.sqlitedemoo.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import vn.poly.sqlitedemoo.model.Student;

public class StudentReaderSQL extends SQLiteOpenHelper {


    public static final String CREATE_TABLE =
            "CREATE TABLE Student (id VARCHAR PRIMARY KEY,name NVARCHAR)";

    public static final String T_NAME = "Student";
    public static final String C_ID = "id";
    public static final String C_NAME = "name";


    public StudentReaderSQL(Context context) {
        super(context, "Students.db ", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }




}
