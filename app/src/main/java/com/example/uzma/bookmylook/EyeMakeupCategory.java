package com.example.uzma.bookmylook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class EyeMakeupCategory extends AppCompatActivity {

    Button b1;
    String menu,category;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eye_makeup_category);
        b1=findViewById(R.id.imakeupSimple);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i=new Intent(getApplicationContext(), Appoinment.class);
                menu=getIntent().getStringExtra("MENU");
                i.putExtra("MENU",menu);
                category=b1.getText().toString();
                i.putExtra("CATEGORY",category);
                startActivity(i);
            }
        });

    }
}
