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
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class WorksAdapter extends ArrayAdapter<Works> {

    private Context mContext;
    private List<Works> moviesList = new ArrayList<>();

    public WorksAdapter(@NonNull Context context, @LayoutRes ArrayList<Works> list) {
        super(context, 0 , list);
        mContext = context;
        moviesList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.work_listview,parent,false);

        Works currentMovie = moviesList.get(position);




        ImageView image = (ImageView)listItem.findViewById(R.id.workimage);
        image.setImageResource(currentMovie.getmImage());

        TextView name = (TextView) listItem.findViewById(R.id.worktv);
        name.setText(currentMovie.getmDetail());
        return listItem;
    }}
