package com.example.studentmealsreview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import static com.example.studentmealsreview.MainActivity.sqLiteHelper;

public class Sign_up extends AppCompatActivity {
    ProgressDialog progressDialog;
    EditText upname,username,password;
    Button signupButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        upname=findViewById(R.id.upname);
        username=findViewById(R.id.usern);
        password=findViewById(R.id.password);
        signupButton=findViewById(R.id.signUp);
        sqLiteHelper=new SQLiteHelper(getApplicationContext(),"usersDB.sqlite",null,1);
        sqLiteHelper.queryData("CREATE TABLE IF NOT EXISTS users (name VARCHAR,username VARCHAR,password VARCHAR)");
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=upname.getText().toString();
                String s2=username.getText().toString();
                String s3=password.getText().toString();
                if (s1.equals("")||s2.equals("")||s3.equals("")){
                    AlertDialog.Builder alertDialog=new AlertDialog.Builder(Sign_up.this);
                    alertDialog.setTitle("Error\tDear user:");
                    alertDialog.setMessage("All fields must be filled");
                    alertDialog.setPositiveButton("Ok,Thanks", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    alertDialog.show();
                }
                else{
                    Boolean checkUsername=sqLiteHelper.checkUsername(s2);
                    if (checkUsername==true){
                        try {
                            sqLiteHelper.insertUsersData(s1.trim(),s2.trim(),s3.trim());
//                    Toast.makeText(getApplicationContext(),"user added successfully",Toast.LENGTH_LONG).show();
                            AlertDialog.Builder alertDialog=new AlertDialog.Builder(Sign_up.this);
                            alertDialog.setTitle("hello\t"+s1.trim());
                            alertDialog.setMessage("your details has been added to the database successfully");
                            alertDialog.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
//user clicks on the cancel button
                                }
                            });
                            alertDialog.setPositiveButton("OK,Thanks", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });

                            alertDialog.show();
                        }catch (Exception e){
                            Toast.makeText(Sign_up.this, "error occurred\n"+e, Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        AlertDialog.Builder alertDialog=new AlertDialog.Builder(Sign_up.this);
                        alertDialog.setTitle("Error");
                        alertDialog.setMessage("username entered already exists in the database");
                        alertDialog.setPositiveButton("Ok,Thanks", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        alertDialog.show();
                    }

                }
            }
        });
    }

//    code bellow is for the progress dialog
    public  void onStart(){
        super.onStart();
         progressDialog=ProgressDialog.show(this,"Please wait","loading...",true);
        CountDownTimer timer=new CountDownTimer(2000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
progressDialog.dismiss();
            }
        }
        .start();
    }
}

