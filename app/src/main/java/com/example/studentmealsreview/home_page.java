package com.example.studentmealsreview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class home_page extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinprob;
    ListView lst;
    String [] fruitname={"chapati","bread","beef","rice","cofee","omelete"};
    String [] desc={"chapati","bread","beef","rice","cofee","omelete"};
    Integer imgid[]={R.drawable.chapo,R.drawable.bread,R.drawable.beef,R.drawable.rice,R.drawable.cofees,R.drawable.omelete};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        spinprob=findViewById(R.id.spinproblems);
        lst=(ListView)findViewById(R.id.listView);
//        creating customview object
        CustomListview customListview=new CustomListview(this,fruitname,desc,imgid);
        lst.setAdapter(customListview);
//        calling loadspinner method
        loadSpinnerData();
    }

    public void loadSpinnerData(){
        List<String> items =new ArrayList<String>();
        items.add("Headache");
        items.add("diarrhoea");
        items.add("stomachache");
        ArrayAdapter<String> dataAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,items);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        attaching the dataAdapter to the spinner
        spinprob.setAdapter(dataAdapter);
    }
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
//        course=parent.getItemAtPosition(position).toString();
//        year=parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
