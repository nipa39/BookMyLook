package com.example.uzma.bookmylook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

//Uploaded pic gula recycler view te show korar pg
public class ImagesActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ImageAdapter mAdapter;

    private DatabaseReference mDatabaseRef;
    private List<Upload> mUploads;
    String sessionId;
    String username,mail,pname;

    private TextView t1,t2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);

        username=getIntent().getStringExtra("UserName");
        mail=getIntent().getStringExtra("Email");

        t1=findViewById(R.id.placeorder);
        t2=findViewById(R.id.rate);

        pname=getIntent().getStringExtra("Pname");

        sessionId=getIntent().getStringExtra("EXTRA_SESSION_ID");

        mRecyclerView= findViewById(R.id.recview);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mUploads =  new ArrayList<>();

        mDatabaseRef= FirebaseDatabase.getInstance().getReference("Works").child(sessionId);
       // Toast.makeText(ImagesActivity.this, sessionId, Toast.LENGTH_SHORT).show();

        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot postSnapshot : dataSnapshot.getChildren()){
                    Upload upload = postSnapshot.getValue(Upload.class);
                    mUploads.add(upload);

                }

                mAdapter= new ImageAdapter(ImagesActivity.this,mUploads);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Toast.makeText(ImagesActivity.this,databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ParlourMenu.class);
                intent.putExtra("EXTRA_SESSION_ID", sessionId);
               // Toast.makeText(ImagesActivity.this,username, Toast.LENGTH_SHORT).show();
                intent.putExtra("UserName",username);
                intent.putExtra("Email",mail);
                startActivity(intent);
            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), GridLayout.class);
                intent.putExtra("EXTRA_SESSION_ID", sessionId);
                intent.putExtra("UserName",username);
                intent.putExtra("Email",mail);
                intent.putExtra("Pname",pname);
                startActivity(intent);

            }
        });

    }
}