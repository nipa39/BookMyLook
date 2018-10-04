package com.example.uzma.bookmylook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Rating extends AppCompatActivity {
    String username,mail,parlourname;
    public Button rate;
    private EditText comment;
    private RatingBar ratingbar;


    private DatabaseReference mDatabaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        parlourname=getIntent().getStringExtra("EXTRA_SESSION_ID");
        username=getIntent().getStringExtra("UserName");
        mail=getIntent().getStringExtra("Email");

        rate=findViewById(R.id.submitbtn);

        comment=findViewById(R.id.comment);
        ratingbar=findViewById(R.id.ratingbar);
        mDatabaseRef= FirebaseDatabase.getInstance().getReference("Rating").child(parlourname);

        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=username;
                String cmnt=comment.getText().toString();
                float rateme=ratingbar.getRating();
                String uploadId = mDatabaseRef.push().getKey();
                RateComment rc=new RateComment(name,cmnt,rateme);
                mDatabaseRef.child(uploadId).setValue(rc);

                Toast.makeText(Rating.this, "Thank you for rating us!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
