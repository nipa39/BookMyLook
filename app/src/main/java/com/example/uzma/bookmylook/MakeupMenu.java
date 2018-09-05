package com.example.uzma.bookmylook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MakeupMenu extends AppCompatActivity {

    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makeup_menu);

        b1=findViewById(R.id.imakeup);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String menu=b1.getText().toString();
                Intent i;
                i=new Intent(getApplicationContext(), EyeMakeupCategory.class);
                i.putExtra("MENU",menu);
                startActivity(i);
            }
        });

    }
}
