package com.example.uzma.bookmylook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Fixit extends AppCompatActivity {

    Button b1;
    String menu,category,s="",date;
    EditText t1,t2,t3,t4,t5,t6,t7;
    Spinner sp;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixit);

        t1= findViewById(R.id.cust);
        t2= findViewById(R.id.serv);
        t3= findViewById(R.id.date);
        t4= findViewById(R.id.time);
        t5= findViewById(R.id.total);
        t6= findViewById(R.id.adv);
        t7= findViewById(R.id.gross);


        menu=getIntent().getStringExtra("MENU");
        category=getIntent().getStringExtra("CATEGORY");
        s=menu+"("+category+")";
        t2.setText(s);

        sp=(Spinner) findViewById(R.id.spinner);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                // Notify the selected item text
                //Toast.makeText(getApplicationContext(), "Time Selected : " + selectedItemText, Toast.LENGTH_SHORT).show();
                t4.setText(selectedItemText);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        date=getIntent().getStringExtra("DATE");
        t3.setText(date);
        t5.setText("1000 BDT");
        t6.setText("500 BDT");
        t7.setText("500 BDT");
        b1=findViewById(R.id.confirm);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i=new Intent(getApplicationContext(), AdvancePayment.class);
                startActivity(i);
            }
        });
    }
}
