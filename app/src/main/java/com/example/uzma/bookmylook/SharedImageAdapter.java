package com.example.uzma.bookmylook;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class SharedImageAdapter extends RecyclerView.Adapter<SharedImageAdapter.ImageViewHolder>{

    private Context mContext;
    private List<Upload> mUploads;

    public SharedImageAdapter(Context context,List<Upload> uploads){
        mContext=context;
        mUploads=uploads;
    }

    @Override
    public SharedImageAdapter.ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.sharedpics, parent, false);
        return new SharedImageAdapter.ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(SharedImageAdapter.ImageViewHolder holder, int position) {
        Upload uploadCurrent=mUploads.get(position);
        holder.textViewDes.setText(uploadCurrent.getName());
        //holder.txtusername.setText();
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
        public ImageButton likebutton;
        public TextView textViewDes;
        public TextView txtusername;
        public ImageView imageView1;

        public ImageViewHolder(View itemView) {
            super(itemView);
            textViewDes=itemView.findViewById(R.id.txt_view_des);
            txtusername=itemView.findViewById(R.id.txt_view_name);
            imageView1=itemView.findViewById(R.id.imgup);
            likebutton=itemView.findViewById(R.id.icon);
        }
    }
}
