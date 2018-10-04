package com.example.uzma.bookmylook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SharedMoments extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ImageAdapter mAdapter;

    private DatabaseReference mDatabaseRef;
    private List<Upload> mUploads;
    String sessionId;
    String username;

    private TextView t1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_moments);

        username=getIntent().getStringExtra("UserName");

      //  t1=findViewById(R.id.placeorder);

        sessionId=getIntent().getStringExtra("EXTRA_SESSION_ID");

        mRecyclerView= findViewById(R.id.recview);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mUploads =  new ArrayList<>();

        mDatabaseRef= FirebaseDatabase.getInstance().getReference("Moments");

        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot postSnapshot : dataSnapshot.getChildren()){
                    Upload upload = postSnapshot.getValue(Upload.class);
                    mUploads.add(upload);

                }

                mAdapter= new ImageAdapter(SharedMoments.this,mUploads);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Toast.makeText(SharedMoments.this,databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

     /*   t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Retrieve.class);
                intent.putExtra("EXTRA_SESSION_ID", sessionId);
                // Toast.makeText(ImagesActivity.this,username, Toast.LENGTH_SHORT).show();
                intent.putExtra("UserName",username);
                startActivity(intent);
            }
        });*/

    }
}
