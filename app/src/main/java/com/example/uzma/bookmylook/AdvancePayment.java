package com.example.uzma.bookmylook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AdvancePayment extends AppCompatActivity {
     Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advance_payment);
        b1=findViewById(R.id.rok);
        b3=findViewById(R.id.mobikash);
        b2=findViewById(R.id.bkash);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AdvancePayment.this, "Thankyou for your order!Your appointment will b confirmed once the advance is received through email.", Toast.LENGTH_SHORT).show();
                Intent i;
                i = new Intent(getApplicationContext(), ProviderPg2.class);
                startActivity(i);

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AdvancePayment.this, "Thankyou for your order!Your appointment will b confirmed once the advance is received through email.", Toast.LENGTH_SHORT).show();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AdvancePayment.this, "Thankyou for your order!Your appointment will b confirmed once the advance is received through email.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

