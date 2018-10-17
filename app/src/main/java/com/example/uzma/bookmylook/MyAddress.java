package com.example.uzma.bookmylook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MyAddress extends AppCompatActivity {

    TextView address;
    Button update;
    DatabaseReference ref;
    private FirebaseAuth mAuth;
    User user;
    String userid,pmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_address);

        address=findViewById(R.id.etaddress);
        update=findViewById(R.id.update);

        userid = getIntent().getStringExtra("Uid");
        String p=getIntent().getStringExtra("Pname");
        //  Toast.makeText(this, userid, Toast.LENGTH_SHORT).show();


        ref= FirebaseDatabase.getInstance().getReference("Address").child(p);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String s=address.getText().toString();
                ref.setValue(s);

                Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
