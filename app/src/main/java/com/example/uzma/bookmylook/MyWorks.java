package com.example.uzma.bookmylook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyWorks extends AppCompatActivity {
    private ListView listView;
    private WorksAdapter mAdapter;
    TextView t;
    String date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_works);

        listView = (ListView) findViewById(R.id.movies_list);
        ArrayList<Works> moviesList = new ArrayList<>();
        moviesList.add(new Works(R.drawable.eyemakup,"Date:15/07/2018" ));
        moviesList.add(new Works(R.drawable.bride,"Date:1/08/2018"));
        moviesList.add(new Works(R.drawable.hqdefault,"Date:20/07/2018"));


        mAdapter = new WorksAdapter(this,moviesList);
        listView.setAdapter(mAdapter);

    }
    }

