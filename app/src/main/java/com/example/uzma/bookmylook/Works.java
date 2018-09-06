package com.example.uzma.bookmylook;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ASUS on 9/5/2018.
 */

public class Works {

    private int mImage;
    private String mDetail;

    // Constructor that is used to create an instance of the Movie object


    public Works(int mImage,String mDetail) {
        this.mImage = mImage;
        this.mDetail=mDetail;
    }

    public int getmImage() {
        return mImage;
    }

    public void setmImage(int mImage) {
        this.mImage = mImage;
    }

    public String getmDetail() {
        return mDetail;
    }

    public void setmDetail(String mDetail) {
        this.mDetail = mDetail;
    }

}


