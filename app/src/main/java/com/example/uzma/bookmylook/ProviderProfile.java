package com.example.uzma.bookmylook;

//Provider er homepage jekhane show korbe or all customer der booking er list

//*******************

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ProviderProfile extends AppCompatActivity {

    ListView listView;
    String username,userid,pmail,cu_email;
   // FirebaseDatabase database;
   // DatabaseReference ref;
    ArrayList<String> list;
    ArrayList<String> list1;
    ArrayAdapter<String> adapter;
    Customers customers;
    Button b1,b2;
    TextView t1,t2;
    ImageView nav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_profile);

        nav=findViewById(R.id.nav1);

        b1=findViewById(R.id.btserviced);
        b2=findViewById(R.id.btnnotify);
        t1=findViewById(R.id.txtlogout);
     //   t2=findViewById(R.id.editprofile);

        username=getIntent().getStringExtra("ProviderName");
        userid=getIntent().getStringExtra("Uid");
        pmail=getIntent().getStringExtra("Mail");

       Toast.makeText(this, "Hey "+username, Toast.LENGTH_SHORT).show();


        customers=new Customers();

        listView = findViewById(R.id.listView1);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
      //  database = FirebaseDatabase.getInstance();
      //  ref=database.getReference("Customers").child(username);
        list=new ArrayList<>();
        list1=new ArrayList<>();
        adapter=new ArrayAdapter<String>(this,R.layout.rowlayout,R.id.txt_lan,list);
       FirebaseDatabase.getInstance().getReference("Customers").child(username)
                .addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds: dataSnapshot.getChildren())
                {
                    customers=ds.getValue(Customers.class);

                   list.add(customers.getCust_id().toString()+"\n"+customers.getCust_mail().toString()+"\n"+customers.getCustomername().toString()+"\n"+customers.getAppointment_date().toString()
                   +"\n"+customers.getAppointment_time().toString()+"\n"+customers.getBooked_service().toString());
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
                String selectedItem=((CheckedTextView)view).getText().toString();
                if(list1.contains(selectedItem)){
                    list1.remove(selectedItem);
                    // list.notifyDataSetChanged();//uncheck item
                  //  Toast.makeText(ParlourMenu.this, "OK", Toast.LENGTH_SHORT).show();
                }
                else {
                    list1.add(selectedItem);
                }

            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteCustomer();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emailnotify();
            }
        });
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // mAuth.getCurrentUser().getEmail();
                Toast.makeText(ProviderProfile.this, "Signed Out", Toast.LENGTH_SHORT).show();
                finish();
                startActivity(new Intent(ProviderProfile.this,ProviderLoginPg.class));
            }
        });
        nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), EditProfile.class);
                //  Toast.makeText(UserLoginPg.this,username, Toast.LENGTH_SHORT).show();
                intent.putExtra("Parlourname",username);

                intent.putExtra("Uid",userid);
                intent.putExtra("Mail",pmail);
                startActivity(intent);
            }
        });


    }


    public void emailnotify(){

        for (String item:list1) {
            // items+="-"+item+" "+"\n";
            String[] a = item.split("\n", 0);
             cu_email = a[1];
            //  Toast.makeText(this, cu_id, Toast.LENGTH_SHORT).show();
            //  DatabaseReference drCust= FirebaseDatabase.getInstance().getReference("Customers").child(username).child(cu_id);
        }


        Intent intent=new Intent(getApplicationContext(),EmailNotification.class);
        intent.putExtra("Mail",pmail);
        intent.putExtra("Umail",cu_email);
        startActivity(intent);
    }

    public void deleteCustomer(){

       /* for (String item:list1){
           if(list.contains(item))
           {
               list.remove(item);
               adapter.remove(item);
           }
        }*/


         /* if(list.contains(item)){
            adapter.remove(item);
        }*/

        for (String item:list1){
           // items+="-"+item+" "+"\n";
            String[] a = item.split("\n",0);
            String cu_id=a[0];
          //  Toast.makeText(this, cu_id, Toast.LENGTH_SHORT).show();
            DatabaseReference drCust= FirebaseDatabase.getInstance().getReference("Customers").child(username).child(cu_id);
            drCust.removeValue();
        }


       FirebaseDatabase.getInstance().getReference("Customers").child(username)
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        list1.clear();
                        list.clear();
                        for (DataSnapshot ds: dataSnapshot.getChildren())
                        {
                            customers=ds.getValue(Customers.class);

                            list.add(customers.getCust_id().toString()+"\n"+customers.getCust_mail().toString()+"\n"+customers.getCustomername().toString()+"\n"+customers.getAppointment_date().toString()
                                    +"\n"+customers.getAppointment_time().toString()+"\n"+customers.getBooked_service().toString());
                        }
                        listView.setAdapter(adapter);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        System.out.println("errorindata");
                    }
                });

        Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();

     //   adapter.notifyDataSetChanged();


    }



}
