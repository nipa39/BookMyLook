package com.example.uzma.bookmylook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MyRatings extends AppCompatActivity {

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
    float sum=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_ratings);
        rating=getIntent().getStringExtra("Parlourname");
        avgRating=findViewById(R.id.avgRating);
        rc=new RateComment();
        listView = findViewById(R.id.listView1);
        database = FirebaseDatabase.getInstance();
        ref=database.getReference("Rating").child(rating);
        list=new ArrayList<>();
        adapter=new ArrayAdapter<String>(this,R.layout.rating_info,R.id.userInfo,list);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                System.out.println("hello");
                for (DataSnapshot ds: dataSnapshot.getChildren())
                {
                    rc=ds.getValue(RateComment.class);

                    list.add("User :  "+rc.getUser().toString()+"\n"+"Comment : "+rc.getComment().toString()+
                    "\n"+"Rate : "+rc.getRatingbar());
                    sum=sum+rc.getRatingbar();
                }
                listView.setAdapter(adapter);
                int count=list.size();
                float avg=sum/count;
                avgRating.setText("Average Rating: "+Float.toString(avg)+"("+Integer.toString(count)+")");



            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("errorindata");
            }
        });

    }

    public double getTotal(ArrayList<RateComment> list){

        double total=0.0;
        for(int i=0;i<list.size();i++){
            total=total+(list.get(i).getRatingbar());
        }
        return total;
    }
}
