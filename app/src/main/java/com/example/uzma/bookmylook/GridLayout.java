package com.example.uzma.bookmylook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class GridLayout extends AppCompatActivity {

    ImageView rateus,locate;
    String sessionId;
    String username,mail,pname,value,sp;
    // Write a message to the database

    DatabaseReference ref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_layout);
        rateus=findViewById(R.id.rateus);
        username=getIntent().getStringExtra("UserName");
        mail=getIntent().getStringExtra("Email");
        sessionId=getIntent().getStringExtra("EXTRA_SESSION_ID");
        pname=getIntent().getStringExtra("Pname");
        rateus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Rating.class);
                intent.putExtra("EXTRA_SESSION_ID", sessionId);
                intent.putExtra("UserName",username);
                intent.putExtra("Email",mail);
                startActivity(intent);
            }
        });
        locate=findViewById(R.id.locate);
        locate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref= FirebaseDatabase.getInstance().getReference("Address").child(pname);
                Toast.makeText(GridLayout.this,pname,Toast.LENGTH_SHORT).show();
                // Read from the database
                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                         value = dataSnapshot.getValue(String.class);
                        // Log.d(TAG, "Value is: " + value);
                       // Toast.makeText(GridLayout.this,value,Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(GridLayout.this,MapsActivity.class);
                        i.putExtra("Add",value);
                       // Toast.makeText(GridLayout.this, sp, Toast.LENGTH_SHORT).show();
                        startActivity(i);

                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        //  Log.w(TAG, "Failed to read value.", error.toException());
                    }
                });

            }
        });


    }
}
