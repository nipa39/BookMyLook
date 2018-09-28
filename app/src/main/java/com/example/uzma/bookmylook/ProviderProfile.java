package com.example.uzma.bookmylook;

//Provider er homepage jekhane show korbe or all customer der booking er list

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ProviderProfile extends AppCompatActivity {

    ListView listView;
    //   SearchView sv;
    String username;
    FirebaseDatabase database;
    DatabaseReference ref;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_profile);

        // username=getIntent().getStringExtra("UserName");



        listView = findViewById(R.id.listView1);
        database = FirebaseDatabase.getInstance();
        // ref=database.getReference("Customers").child();
        list=new ArrayList<>();
        adapter=new ArrayAdapter<String>(this,R.layout.user_info,R.id.userInfo,list);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                System.out.println("hello");
                for (DataSnapshot ds: dataSnapshot.getChildren())
                {
                    // user=ds.getValue(User.class);

                    // list.add(user.getName().toString());
                }
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("errorindata");
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final String Parlourname = list.get(position);
                //Toast.makeText(getApplicationContext(),Parlourname+" "+position,Toast.LENGTH_LONG).show();
                // Toast.makeText(getApplicationContext(), position+"", Toast.LENGTH_SHORT).show();
                final DatabaseReference mDatabaseRef =FirebaseDatabase.getInstance().getReference("ServiceProviders");

                //    Query query=mDatabaseRef.orderByChild("name").equalTo(Parlourname);

                mDatabaseRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for (DataSnapshot data:dataSnapshot.getChildren()) {
                            //  user = data.getValue(User.class);

                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }

                });

            }
        });


    }

}

