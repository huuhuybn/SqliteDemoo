package vn.poly.sqlitedemoo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;
import java.util.Random;

import vn.poly.sqlitedemoo.R;
import vn.poly.sqlitedemoo.model.Student;
import vn.poly.sqlitedemoo.sqlite.StudentDAO;
import vn.poly.sqlitedemoo.sqlite.StudentReaderSQL;

public class MainActivity extends AppCompatActivity {


    private StudentDAO studentDAO;

    private EditText edtID,edtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtID = findViewById(R.id.edtID);
        edtName = findViewById(R.id.edtName);

        studentDAO = new StudentDAO(MainActivity.this);

        Student student = new Student();

        student.id = "PH" + new Random().nextInt(10000);
        student.name = "Huy Nguyen " + new Random().nextInt();




        List<Student> studentList = studentDAO.getAllStudents();


        Log.e("SIZE",studentList.size() + "");

    }

    public void insertSV(View view) {
        String id = edtID.getText().toString().trim();
        String name = edtName.getText().toString().trim();

        if (id.equals("")){

            Toast.makeText(this,"Vui long nhap ID",Toast.LENGTH_SHORT).show();
        }else if (name.equals("")){

            Toast.makeText(this,"Vui long nhap Name",Toast.LENGTH_SHORT).show();
        }else {
            // them vao sql
            Student student = new Student();

            student.id = id;
            student.name = name;
            long result = studentDAO.insertStudent(student);

            if (result > 0) {

                Toast.makeText(this, "Them thanh cong!!", Toast.LENGTH_SHORT).show();

            } else {

                Toast.makeText(this, "Them KHONG cong!!", Toast.LENGTH_SHORT).show();

            }



        }
    }

    public void updateSV(View view) {
        String id = edtID.getText().toString().trim();
        String name = edtName.getText().toString().trim();

        if (id.equals("")){

            Toast.makeText(this,"Vui long nhap ID",Toast.LENGTH_SHORT).show();
        }else if (name.equals("")){

            Toast.makeText(this,"Vui long nhap Name",Toast.LENGTH_SHORT).show();
        }else {
            // them vao sql
            Student student = new Student();

            student.id = id;
            student.name = name;
            long result = studentDAO.updateStudent(student);

            if (result > 0) {

                Toast.makeText(this, "SUA thanh cong!!", Toast.LENGTH_SHORT).show();

            } else {

                Toast.makeText(this, "SUA KHONG cong!!", Toast.LENGTH_SHORT).show();

            }



        }


    }
}
