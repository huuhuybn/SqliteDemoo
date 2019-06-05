package vn.poly.sqlitedemoo.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import vn.poly.sqlitedemoo.model.Student;

import static vn.poly.sqlitedemoo.sqlite.StudentReaderSQL.C_ID;
import static vn.poly.sqlitedemoo.sqlite.StudentReaderSQL.C_NAME;
import static vn.poly.sqlitedemoo.sqlite.StudentReaderSQL.T_NAME;

public class StudentDAO {


    private StudentReaderSQL studentReaderSQL;

    public StudentDAO(Context context) {

        studentReaderSQL = new StudentReaderSQL(context);

    }

    public long insertStudent(Student student) {

        // b1 : xin quyen
        SQLiteDatabase sqLiteDatabase = studentReaderSQL.getWritableDatabase();

        // b2 : ghep cap du lieu
        ContentValues contentValues = new ContentValues();
        contentValues.put(C_ID, student.id);
        contentValues.put(C_NAME, student.name);

        // b3 : su dung cau lenh insert
        long result = sqLiteDatabase.insert(T_NAME, null, contentValues);

        // b4 : dong ket noi
        sqLiteDatabase.close();

        return result;

    }

    public long updateStudent(Student student) {

        // b1 : xin quyen
        SQLiteDatabase sqLiteDatabase = studentReaderSQL.getWritableDatabase();

        // b2 : ghep cap du lieu
        ContentValues contentValues = new ContentValues();
        contentValues.put(C_ID, student.id);
        contentValues.put(C_NAME, student.name);

        // b3 : su dung cau lenh insert
        long result = sqLiteDatabase.
                update(T_NAME, contentValues, C_ID + "=?", new String[]{student.id});

        // b4 : dong ket noi
        sqLiteDatabase.close();

        return result;

    }


    public int delStudent(String id) {

        // b1 : xin quyen
        SQLiteDatabase sqLiteDatabase = studentReaderSQL.getWritableDatabase();

        // b2 : xoa
        int result = sqLiteDatabase.delete(T_NAME, C_ID + "=?", new String[]{id});

        sqLiteDatabase.close();

        return result;

    }


    public List<Student> getAllStudents() {
        List<Student> studentList = new ArrayList<>();
        // b1 : xin quyen
        SQLiteDatabase sqLiteDatabase = studentReaderSQL.getReadableDatabase();

        // b2 : viet cau lenh select

        String select = "SELECT * FROM " + T_NAME;

        // b3 : su dung cau lenh rawQuery
        Cursor cursor = sqLiteDatabase.rawQuery(select, null);
        if (cursor.moveToFirst()) {
            do {
                Student student = new Student();
                student.id = cursor.getString(0);
                student.name = cursor.getString(1);

                studentList.add(student);

            } while (cursor.moveToNext());

            // dong ket noi con tro
            cursor.close();
        }
        // dong ket noi DB
        sqLiteDatabase.close();
        return studentList;

    }


}
