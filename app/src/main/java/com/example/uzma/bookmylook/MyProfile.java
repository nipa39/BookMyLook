package com.example.uzma.bookmylook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MyProfile extends AppCompatActivity {

    EditText n, p, e;
    Button b1;
    DatabaseReference ref;
    private FirebaseAuth mAuth;
    User user;
    String userid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        n = findViewById(R.id.etname);
        p = findViewById(R.id.etphn);
        e = findViewById(R.id.etemail);
        b1=findViewById(R.id.updateprof);

        userid = getIntent().getStringExtra("Uid");
      //  Toast.makeText(this, userid, Toast.LENGTH_SHORT).show();


          ref= FirebaseDatabase.getInstance().getReference("ServiceProviders").child(userid);

        //   mAuth = FirebaseAuth.getInstance();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user=new User(n.getText().toString(),e.getText().toString(),p.getText().toString());

                ref.setValue(user);

                Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_SHORT).show();
            }
        });




    }
}
