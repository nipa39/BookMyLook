package com.example.uzma.bookmylook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MyUserBookings extends AppCompatActivity {

    ListView listView;
    //SearchView sv;
    String username,mail;
    FirebaseDatabase database;
    DatabaseReference ref;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    // User user;
    RateComment rc;
    TextView share,avgRating;
    // UserId userId;
    String rating,count,summm;
    Customers customers;
    float sum=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_user_bookings);
        username=getIntent().getStringExtra("UserName");
      //  avgRating=findViewById(R.id.avgRating);
      //  rc=new RateComment();
        customers=new Customers();
        listView = findViewById(R.id.listView1);
        database = FirebaseDatabase.getInstance();
        ref=database.getReference("Bookings").child(username);
        list=new ArrayList<>();
        adapter=new ArrayAdapter<String>(this,R.layout.rating_info,R.id.userInfo,list);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                System.out.println("hello");
                for (DataSnapshot ds: dataSnapshot.getChildren())
                {
                    customers=ds.getValue(Customers.class);
                    list.add(customers.getAppointment_date().toString()
                            +"\n"+customers.getAppointment_time().toString()+"\n"+customers.getBooked_service().toString());
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
