package com.example.uzma.bookmylook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class EditProfile extends AppCompatActivity {

    String parlourname,userid,pmail;
    TextView rating,profile,services,proemail,proname,myclients;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        pmail=getIntent().getStringExtra("Mail");
        parlourname=getIntent().getStringExtra("Parlourname");
        userid=getIntent().getStringExtra("Uid");

        proemail=findViewById(R.id.proemail);
        proname=findViewById(R.id.proname);

        proname.setText(parlourname);
        proemail.setText(pmail);

        rating=findViewById(R.id.myratings);
        profile=findViewById(R.id.myprofile);
        services=findViewById(R.id.myservices);
        myclients=findViewById(R.id.myclients);

        myclients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ClientHistory.class);
                //  Toast.makeText(UserLoginPg.this,username, Toast.LENGTH_SHORT).show();
                //   intent.putExtra("Parlourname",parlourname);

                intent.putExtra("Pname",parlourname);
                startActivity(intent);
            }
        });

        services.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), UpdateServices.class);
                //  Toast.makeText(UserLoginPg.this,username, Toast.LENGTH_SHORT).show();
                //   intent.putExtra("Parlourname",parlourname);

                intent.putExtra("Pname",parlourname);
                startActivity(intent);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MyProfile.class);
                //  Toast.makeText(UserLoginPg.this,username, Toast.LENGTH_SHORT).show();
             //   intent.putExtra("Parlourname",parlourname);
                intent.putExtra("Mail",pmail);
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
