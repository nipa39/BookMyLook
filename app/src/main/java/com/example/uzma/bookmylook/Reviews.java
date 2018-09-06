package com.example.uzma.bookmylook;



public class Reviews  {

    private String mName;
    private int mRating;
    private String mDetail;

    // Constructor that is used to create an instance of the Movie object


    public Reviews(String mName,int mRating,String mDetail) {
        this.mName = mName;
        this.mRating=mRating;
        this.mDetail=mDetail;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }
    public int getmRating() {return mRating;}
    public void setmRating(){this.mRating=mRating;}

    public String getmDetail() {
        return mDetail;
    }

    public void setmDetail(String mDetail) {
        this.mDetail = mDetail;
    }

}
