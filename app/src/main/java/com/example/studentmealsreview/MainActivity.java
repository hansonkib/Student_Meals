package com.example.studentmealsreview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class MainActivity extends AppCompatActivity {
ProgressDialog progressDialog;
EditText username,password;
Button signButton,login;
    public  static SQLiteHelper sqLiteHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//below is the code for sign up button to link to the user registration page
        signButton=findViewById(R.id.signButton);
        username=findViewById(R.id.usernamel);
        password=findViewById(R.id.passwordl);
        login=findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String s1=username.getText().toString();
//                String s2=password.getText().toString();
                SQLiteHelper shp=new SQLiteHelper(getApplicationContext(),"usersDB.sqlite",null,1);
                SQLiteDatabase db=shp.getReadableDatabase();
                String[] cols={"username","password"};
                String[] vals={username.getText().toString(),password.getText().toString()};
                Cursor cursor=db.query("users",cols,"username=? AND password=?",vals,null,null,null);
                if (cursor !=null){
                    if (cursor.moveToFirst()){
                        Intent intent = new Intent(MainActivity.this,Meals_review.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Wrong log in credentials",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        signButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                testing lib here
//                TapTargetView.showFor(this,TapTarget.forView(R.id.),"We have the best targets","believe me");
//                        all this optional

                Intent intent =new Intent(getApplicationContext(),drawer_page.class);
                startActivity(intent);
            }
        });


//        GraphView graph = (GraphView) findViewById(R.id.graph);
//        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
//                new DataPoint(0, 1),
//                new DataPoint(1, 5),
//                new DataPoint(2, 3),
//                new DataPoint(3, 2),
//                new DataPoint(4, 6)
//        });
//        graph.addSeries(series);

    }
    public void onStart(){
        super.onStart();
        progressDialog=progressDialog.show(this,"Meals App opening","please wait...",true);
        CountDownTimer  timer= new CountDownTimer(3000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
progressDialog.dismiss();
            }
        }.start();
    }
}
