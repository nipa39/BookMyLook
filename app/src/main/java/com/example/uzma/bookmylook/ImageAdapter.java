package com.example.uzma.bookmylook;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

// To set the image to upload in the imageview
public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder>{

    private Context mContext;
    private List<Upload> mUploads;

    public ImageAdapter(Context context,List<Upload> uploads){
        mContext=context;
        mUploads=uploads;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.image_item, parent, false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder,int position) {
        Upload uploadCurrent=mUploads.get(position);
        holder.textViewName.setText(uploadCurrent.getName());
        //  holder.imageView1.setImageURI(
        //          uploadCurrent.getImageUrl();
        //  )
        String uzma=uploadCurrent.getImageUrl();
        // Toast.makeText(mContext, uzma, Toast.LENGTH_SHORT).show();
        // holder.imageView1.setImageResource(mUploads.get(position.));
        Picasso.get()
                // .load("http://i.imgur.com/DvpvklR.png")
                .load(uploadCurrent.getImageUrl())
                .into(holder.imageView1);
                //.load(uploadCurrent.getImageUrl())
               // .into(holder.imageView1);

    }

    @Override
    public int getItemCount() {
        return mUploads.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder{
        public TextView textViewName;
        public ImageView imageView1;

        public ImageViewHolder(View itemView) {
            super(itemView);
            textViewName=itemView.findViewById(R.id.txt_view_name);
            imageView1=itemView.findViewById(R.id.imgup);
        }
    }
}