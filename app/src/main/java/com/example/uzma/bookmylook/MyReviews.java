package com.example.uzma.bookmylook;

/**
 * Created by ASUS on 9/5/2018.
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyReviews extends AppCompatActivity {
    private ListView listView;
    private ReviewsAdapter mAdapter;
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);

        listView = (ListView) findViewById(R.id.movies_list);
        ArrayList<Reviews> moviesList = new ArrayList<>();
        moviesList.add(new Reviews("Nourin Khandaker", 4 , "The Service is really good.Keep it up."));
        moviesList.add(new Reviews("Uzma Hasan", 4 , "I did Facial here last week and got the service properly."));



        mAdapter = new ReviewsAdapter(this,moviesList);
        listView.setAdapter(mAdapter);

    }
}
