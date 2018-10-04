package com.example.uzma.bookmylook;

//Appointment er date fixation er pg (only user dekhte parbe eta) (user pg six)

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class Appointment extends AppCompatActivity {

    String menu,category,s,sessionId,username,parlourname,mail;
    Button b1;
    DatePicker dp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);

        username=getIntent().getStringExtra("UserName");
        mail=getIntent().getStringExtra("Email");
      //  Toast.makeText(this, username, Toast.LENGTH_SHORT).show();

        parlourname=getIntent().getStringExtra("EXTRA_SESSION_ID");

        sessionId=getIntent().getStringExtra("SelectedItems");
        dp=(DatePicker) findViewById(R.id.datepicker);
        Calendar today = Calendar.getInstance();

        dp.init(
                today.get(Calendar.YEAR),
                today.get(Calendar.MONTH),
                today.get(Calendar.DAY_OF_MONTH),
                new DatePicker.OnDateChangedListener(){

                    @Override
                    public void onDateChanged(DatePicker view,
                                              int year, int monthOfYear,int dayOfMonth) {
                        Toast.makeText(getApplicationContext(),
                                "Year: " + year + "\n" +
                                        "Month of Year: " + (monthOfYear+1) + "\n" +
                                        "Day of Month: " + dayOfMonth, Toast.LENGTH_SHORT).show();
                        s=dayOfMonth+"-"+(monthOfYear+1)+"-"+year;

                    }});

        b1=findViewById(R.id.dateOk);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i=new Intent(getApplicationContext(), Fixit.class);
               // menu=getIntent().getStringExtra("MENU");
               // i.putExtra("MENU",menu);
                category=sessionId;
                i.putExtra("CATEGORY",category);
                i.putExtra("DATE",s);
                i.putExtra("UserName",username);
                i.putExtra("EXTRA_SESSION_ID",parlourname);
                i.putExtra("Email",mail);
                startActivity(i);
            }
        });
    }
}
