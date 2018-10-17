package com.example.uzma.bookmylook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

//all users der homepage e all parlours der name ashar list(user end e pg 3)
public class Retrieve extends AppCompatActivity {

    ListView listView;
    SearchView sv;
    String username,mail,userid;
    FirebaseDatabase database;
    DatabaseReference ref;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    User user;
    TextView share;
   // UserId userId;
    ImageView nav;
    String id1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve);

    //    share=findViewById(R.id.txtshare);
      /*  share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), UserPicUpload.class);
                intent.putExtra("EXTRA_SESSION_ID", id1);
                //  Toast.makeText(Retrieve.this,username, Toast.LENGTH_SHORT).show();
                intent.putExtra("UserName",username);

                // Toast.makeText(Retrieve.this, id1, Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });*/

        username=getIntent().getStringExtra("UserName");
        mail=getIntent().getStringExtra("Email");
        userid=getIntent().getStringExtra("Uid");



        nav=findViewById(R.id.nav);
        nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), UserNav.class);
                //  Toast.makeText(UserLoginPg.this,username, Toast.LENGTH_SHORT).show();
                intent.putExtra("UserName",username);
                intent.putExtra("Uid",userid);
                intent.putExtra("EXTRA_SESSION_ID", id1);
               // intent.putExtra("Uid",username);
                intent.putExtra("Email",mail);
                startActivity(intent);
            }
        });

        sv=findViewById(R.id.sc1);
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });

        user=new User();
      //  userId=new UserId();
        listView = findViewById(R.id.listView1);
        database = FirebaseDatabase.getInstance();
        ref=database.getReference("ServiceProviders");
        list=new ArrayList<>();
        adapter=new ArrayAdapter<String>(this,R.layout.user_info,R.id.userInfo,list);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                System.out.println("hello");
                for (DataSnapshot ds: dataSnapshot.getChildren())
                {
                    user=ds.getValue(User.class);
                    Log.d("list", user.getName());
                    System.out.println(user.getName());
                    list.add(user.getName().toString());
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
                final DatabaseReference mDatabaseRef = FirebaseDatabase.getInstance().getReference("ServiceProviders");

            //    Query query=mDatabaseRef.orderByChild("name").equalTo(Parlourname);

                mDatabaseRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for (DataSnapshot data:dataSnapshot.getChildren()){
                            user=data.getValue(User.class);

                            if(Parlourname == user.getName())
                            {
                                //userId=data.getValue(UserId.class);
                               //userId=data.getChildren(UserId.class);
                               // id1 = data.getChildren().iterator().next().getKey();
                              //  userId=data.getChildren().iterator().next().getValue(UserId.class);
                              //  id1=userId.getUserid();
                               // System.out.println(id1);

                               // id1=user.getName();

                                id1=user.getName();

                                Intent intent = new Intent(getApplicationContext(), ImagesActivity.class);
                                intent.putExtra("EXTRA_SESSION_ID", id1);
                               // Toast.makeText(Retrieve.this,username, Toast.LENGTH_SHORT).show();
                                intent.putExtra("UserName",username);
                                intent.putExtra("Email",mail);
                                intent.putExtra("Pname",id1);
                                // Toast.makeText(Retrieve.this, id1, Toast.LENGTH_SHORT).show();
                                startActivity(intent);

                                break;

                            }

                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }

                });
//                Toast.makeText(getApplicationContext(),Parlourname+" "+id1,Toast.LENGTH_LONG).show();
             //   Toast.makeText(Retrieve.this,"This id "+id1, Toast.LENGTH_SHORT).show();
               // Toast.makeText(Retrieve.this,list.get(position), Toast.LENGTH_SHORT).show();

            }
        });


    }


}
