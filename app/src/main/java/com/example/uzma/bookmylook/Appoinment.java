package com.example.uzma.bookmylook;

import android.content.Intent;
import java.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.widget.DatePicker.OnDateChangedListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

public class Appoinment extends AppCompatActivity {

    String menu,category,s;
    Button b1;
    DatePicker dp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appoinment);
        dp=(DatePicker) findViewById(R.id.datepicker);
        //s=dp.getDayOfMonth()+"/"+(dp.getMonth()+1)+"/"+dp.getYear();
       // Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
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
                menu=getIntent().getStringExtra("MENU");
                i.putExtra("MENU",menu);
                category=getIntent().getStringExtra("CATEGORY");
                i.putExtra("CATEGORY",category);
                i.putExtra("DATE",s);
                startActivity(i);
            }
        });
    }
}
