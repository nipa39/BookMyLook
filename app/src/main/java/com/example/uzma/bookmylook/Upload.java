package com.example.uzma.bookmylook;

//Image upload er jonno

public class Upload {
    private String mName;
    private String mImageUrl;

    public Upload(){

    }
    public Upload(String picname,String imageUrl){
        if(picname.trim().equals("")){
            picname = "No name";
        }

        mName=picname;
        mImageUrl= imageUrl;

    }

    public String getName() {
        return mName;
    }

    public void setName(String name){
        mName=name;
    }

    public String getImageUrl() {
        return mImageUrl;
    }
    public void setImageUrl(String imageUrl) {
        mImageUrl=imageUrl;
    }
}

