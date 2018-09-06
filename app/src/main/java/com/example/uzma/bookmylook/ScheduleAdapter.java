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


public class ScheduleAdapter extends ArrayAdapter<Scedule> {

    private Context mContext;
    private List<Scedule> moviesList = new ArrayList<>();

    public ScheduleAdapter(@NonNull Context context, @LayoutRes ArrayList<Scedule> list) {
        super(context, 0 , list);
        mContext = context;
        moviesList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.schedule_listview,parent,false);

        Scedule currentMovie = moviesList.get(position);




        TextView name = (TextView) listItem.findViewById(R.id.textView_name);
        name.setText(currentMovie.getmName());

        TextView service = (TextView) listItem.findViewById(R.id.textView_service);
        service.setText(currentMovie.getmService());

        TextView time = (TextView) listItem.findViewById(R.id.textView_time);
        time.setText(currentMovie.getmTime());
        return listItem;
    }}
