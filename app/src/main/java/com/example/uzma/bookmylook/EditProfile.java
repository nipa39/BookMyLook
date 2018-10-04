package com.example.uzma.bookmylook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class EditProfile extends AppCompatActivity {

    String parlourname,userid;
    TextView rating,profile,services;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        parlourname=getIntent().getStringExtra("Parlourname");
        userid=getIntent().getStringExtra("Uid");

        rating=findViewById(R.id.myratings);
        profile=findViewById(R.id.myprofile);
        services=findViewById(R.id.myservices);

        services.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), UpdateServices.class);
                //  Toast.makeText(UserLoginPg.this,username, Toast.LENGTH_SHORT).show();
                //   intent.putExtra("Parlourname",parlourname);
                intent.putExtra("Uid",userid);
                startActivity(intent);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MyProfile.class);
                //  Toast.makeText(UserLoginPg.this,username, Toast.LENGTH_SHORT).show();
             //   intent.putExtra("Parlourname",parlourname);
                intent.putExtra("Uid",userid);
                startActivity(intent);
            }
        });

        rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MyRatings.class);
                //  Toast.makeText(UserLoginPg.this,username, Toast.LENGTH_SHORT).show();
                intent.putExtra("Parlourname",parlourname);

                startActivity(intent);
            }
        });
    }
}
