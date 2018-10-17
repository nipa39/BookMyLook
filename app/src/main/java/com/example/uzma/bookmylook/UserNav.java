package com.example.uzma.bookmylook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class UserNav extends AppCompatActivity {


    String username,mail,userid,test;
    TextView t1,t2;
    TextView rating,profile,services,proemail,proname,myclients;
    TextView myprofile,mybookings,sharepic,logout,appinfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_nav);

        userid=getIntent().getStringExtra("Uid");

        test=getIntent().getStringExtra("EXTRA_SESSION_ID");

        username=getIntent().getStringExtra("UserName");
        mail=getIntent().getStringExtra("Email");

        myprofile=findViewById(R.id.myprofile);
        mybookings=findViewById(R.id.mybookings);
        sharepic=findViewById(R.id.sharephoto);
        logout=findViewById(R.id.logout);
        appinfo=findViewById(R.id.appinfo);

        myprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(UserNav.this,MyUserProfile.class);
                //intent.putExtra("Username",username);
                intent.putExtra("Uid",userid);
                intent.putExtra("Email",mail);
                startActivity(intent);
            }
        });
        mybookings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(UserNav.this,MyUserBookings.class);
                intent.putExtra("UserName",username);
                startActivity(intent);
            }
        });
        sharepic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UserPicUpload.class);
                intent.putExtra("EXTRA_SESSION_ID", test);
                //  Toast.makeText(Retrieve.this,username, Toast.LENGTH_SHORT).show();
                intent.putExtra("UserName",username);

                // Toast.makeText(Retrieve.this, id1, Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(UserNav.this, "Signed Out", Toast.LENGTH_SHORT).show();
                finish();
                startActivity(new Intent(UserNav.this,UserLoginPg.class));
            }
        });
        appinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(UserNav.this,AppInfo.class);
                startActivity(intent);
            }
        });


       t1=findViewById(R.id.proname);
       t2=findViewById(R.id.proemail);

       t1.setText(username);
       t2.setText(mail);

        profile=findViewById(R.id.myprofile);


    }
}
