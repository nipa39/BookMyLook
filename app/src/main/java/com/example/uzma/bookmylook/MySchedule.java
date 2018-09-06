package com.example.uzma.bookmylook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

public class MySchedule extends AppCompatActivity {
    private ListView listView;
    private ScheduleAdapter mAdapter;
    TextView t;
    String date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_schedule);

        t=(TextView) findViewById(R.id.scheduletv);
        date=getIntent().getStringExtra("DATE");
        t.append(date);
        listView = (ListView) findViewById(R.id.movies_list);
        ArrayList<Scedule> moviesList = new ArrayList<>();
        moviesList.add(new Scedule("Nourin Khandaker", "Eye Makeup" , "8:00-12:00"));
        moviesList.add(new Scedule("Uzma Hasan", "Eye Makeup" , "8:00-12:00"));
        moviesList.add(new Scedule("Ahona", "Eye Makeup" , "8:00-12:00"));
        moviesList.add(new Scedule("Uzma", "Eye Makeup" , "12:00-4:00"));
        moviesList.add(new Scedule("Nipa", "Eye Makeup" , "12:00-4:00"));
        moviesList.add(new Scedule("Jerin", "Eye Makeup" , "4:00-8:00"));
        moviesList.add(new Scedule("Mukta", "Eye Makeup" , "4:00-8:00"));
        moviesList.add(new Scedule("Hridi", "Eye Makeup" , "12:00-4:00"));
        moviesList.add(new Scedule("Mahir", "Eye Makeup" , "12:00-4:00"));

        mAdapter = new ScheduleAdapter(this,moviesList);
        listView.setAdapter(mAdapter);

    }
}
