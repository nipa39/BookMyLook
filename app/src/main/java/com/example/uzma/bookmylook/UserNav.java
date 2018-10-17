package com.example.uzma.bookmylook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class UserNav extends AppCompatActivity {


    String username,mail;
    TextView t1,t2;
    TextView rating,profile,services,proemail,proname,myclients;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_nav);

        username=getIntent().getStringExtra("UserName");
        mail=getIntent().getStringExtra("Email");


       t1=findViewById(R.id.proname);
       t2=findViewById(R.id.proemail);

       t1.setText(username);
       t2.setText(mail);

        profile=findViewById(R.id.myprofile);


    }
}
