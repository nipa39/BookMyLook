package com.example.uzma.bookmylook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

//Individual service list of the clicked parlour(user end e pg - 4)
public class ParlourMenu extends AppCompatActivity {

    ListView listView;

    ArrayList<String> list;
    ArrayList<String> list1;
    ArrayAdapter<String> adapter;
    Service service;
    String sessionId;
    String username;
    Button b1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parlour_menu);
        username=getIntent().getStringExtra("UserName");
        b1=findViewById(R.id.bt);
        service=new Service();
        sessionId=getIntent().getStringExtra("EXTRA_SESSION_ID");
        listView = findViewById(R.id.listView1);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        //   database = FirebaseDatabase.getInstance();


        //   ref=FirebaseDatabase.getInstance().getReference("Services").child(sessionId);
        list1=new ArrayList<>();
        list=new ArrayList<>();
        adapter=new ArrayAdapter<String>(this,R.layout.rowlayout,R.id.txt_lan,list);

        FirebaseDatabase.getInstance().getReference("Services").child(sessionId)
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // System.out.println("Hello");

               /* for (DataSnapshot ds: dataSnapshot.getChildren())
                {
                    service=ds.getValue(Service.class);
                 //   Toast.makeText(ParlourMenu.this, "HEY", Toast.LENGTH_SHORT).show();
                   list.add(service.getS1().toString());
                }
                listView.setAdapter(adapter);*/

                        service=dataSnapshot.getValue(Service.class);
                        list.add(service.getS1().toString());
                        list.add(service.getS2().toString());
                        list.add(service.getS3().toString());
                        list.add(service.getS4().toString());
                        list.add(service.getS5().toString());

                        listView.setAdapter(adapter);


                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=((CheckedTextView)view).getText().toString();
                if(list1.contains(selectedItem)){
                    list1.remove(selectedItem);
                    // list.notifyDataSetChanged();//uncheck item
                    Toast.makeText(ParlourMenu.this, "OK", Toast.LENGTH_SHORT).show();
                }
                else {
                    list1.add(selectedItem);
                }

            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSelectedItems(view);
            }
        });
    }

    public void showSelectedItems(View view){
        String items="";
        for (String item:list1){
            items+="-"+item+" "+"\n";
        }
        Toast.makeText(this,"You have selected \n "+items, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), Appoinment.class);
        intent.putExtra("SelectedItems", items);
        // Toast.makeText(this, username, Toast.LENGTH_SHORT).show();
        intent.putExtra("UserName",username);
        intent.putExtra("EXTRA_SESSION_ID",sessionId);
        // Toast.makeText(Retrieve.this, id1, Toast.LENGTH_SHORT).show();
        startActivity(intent);

    }

}

