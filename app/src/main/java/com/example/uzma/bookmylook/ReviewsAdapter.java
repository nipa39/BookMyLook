package com.example.uzma.bookmylook;

/**
 * Created by ASUS on 9/5/2018.
 */

import android.content.Context;
import android.graphics.Movie;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class ReviewsAdapter extends ArrayAdapter<Reviews> {

    private Context mContext;
    private List<Reviews> moviesList = new ArrayList<>();

    public ReviewsAdapter(@NonNull Context context, @LayoutRes ArrayList<Reviews> list) {
        super(context, 0 , list);
        mContext = context;
        moviesList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.review_listview,parent,false);

        Reviews currentMovie = moviesList.get(position);




        TextView name = (TextView) listItem.findViewById(R.id.textView_name);
        name.setText(currentMovie.getmName());

        RatingBar r=(RatingBar) listItem.findViewById(R.id.rating);
        r.setRating(currentMovie.getmRating());

       EditText time = (EditText) listItem.findViewById(R.id.reviewet);
        time.setText(currentMovie.getmDetail());
        return listItem;
    }}