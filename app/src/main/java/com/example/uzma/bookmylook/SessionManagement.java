package com.example.uzma.bookmylook;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManagement {
    Context context;
    SharedPreferences sharedPreferences;

    public SessionManagement(Context context){
        this.context=context;
        sharedPreferences=context.getSharedPreferences("allinfo", Context.MODE_PRIVATE);

    }
}
