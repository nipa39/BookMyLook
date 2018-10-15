package com.example.uzma.bookmylook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ClientHistory extends AppCompatActivity {

    String parname;
    ListView listView;
    FirebaseDatabase database;
    DatabaseReference ref;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    Customers customers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_history);
        parname=getIntent().getStringExtra("Pname");
       // rating=getIntent().getStringExtra("Parlourname");

        listView = findViewById(R.id.listView1);
        database = FirebaseDatabase.getInstance();
        ref=database.getReference("CustHistory").child(parname);
        list=new ArrayList<>();
        adapter=new ArrayAdapter<String>(this,R.layout.rating_info,R.id.userInfo,list);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
               // System.out.println("hello");
                for (DataSnapshot ds: dataSnapshot.getChildren())
                {
                    customers=ds.getValue(Customers.class);

                    list.add(customers.getCust_mail().toString()+"\n"+customers.getCustomername().toString()+"\n"
                            +customers.getBooked_service().toString()+"\n"+"Date :"+customers.getAppointment_date().toString());
                }
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("errorindata");
            }
        });

    }

}
