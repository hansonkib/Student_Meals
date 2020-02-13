package com.example.studentmealsreview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class Statistics extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        GraphView graph=(GraphView)findViewById(R.id.graph);
        graph.setTitle("breakfast");
        LineGraphSeries<DataPoint>series=new LineGraphSeries<DataPoint>(new DataPoint[]{
             new DataPoint(0,1) ,
             new DataPoint(1,5),
                new DataPoint(3,2),
                new DataPoint(4,6)

        });
        graph.addSeries(series);

//        GraphView graphs=(GraphView)findViewById(R.id.graphs);
//        graphs.setTitle("lunch");
//        LineGraphSeries<DataPoint>series1=new LineGraphSeries<DataPoint>(new DataPoint[]{
//                new DataPoint(21,4),
//                new DataPoint(14,7),
//                new DataPoint(23,3),
//                new DataPoint(5,4),
//                new DataPoint(12,4),
//                new DataPoint(3,8)
//        });
//        graphs.addSeries(series1);
    }
}
