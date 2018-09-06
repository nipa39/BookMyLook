package com.example.uzma.bookmylook;

/**
 * Created by ASUS on 9/5/2018.
 */

public class Scedule {

    private String mName;

    private String mService;

    private String mTime;

    // Constructor that is used to create an instance of the Movie object
    public Scedule(String mName, String mService, String mTime) {
        this.mService= mService;
        this.mName = mName;
        this.mTime = mTime;
    }




    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmService() {
        return mService;
    }

    public void setmTime(String mTime) {
        this.mTime = mTime;
    }
    public String getmTime() {
        return mTime;
    }
}
