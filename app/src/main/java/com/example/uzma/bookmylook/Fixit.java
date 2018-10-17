package com.example.uzma.bookmylook;

//order er complete list ta show kore(pg-7 of user)

//********************

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Fixit extends AppCompatActivity {

    FirebaseAuth mAuth;
    User user;
    private DatabaseReference mDatabaseRef;
    private DatabaseReference custHistory;
    private DatabaseReference custBookings;
    private DatabaseReference ref;

    Button b1,logout;
    String menu,category,s="",date,parlourname;
    EditText t0,t1,t2,t3,t4,t5,t6,t7;
    Spinner sp;
    ArrayAdapter<String> adapter;
    String username,mail,parlourmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixit);

        user=new User();

        ref=FirebaseDatabase.getInstance().getReference("ServiceProviders");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    user = data.getValue(User.class);
                    if (parlourname.equals(user.getName())) {
                        parlourmail = user.getEmail();
                        break;
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        parlourname=getIntent().getStringExtra("EXTRA_SESSION_ID");
        username=getIntent().getStringExtra("UserName");
        mail=getIntent().getStringExtra("Email");

    //    Toast.makeText(this, username, Toast.LENGTH_SHORT).show();

       // FirebaseDatabase.getInstance().getReference("Users").child(mAuth.getCurrentUser().getUid());

        mAuth= FirebaseAuth.getInstance();
        mDatabaseRef= FirebaseDatabase.getInstance().getReference("Customers").child(parlourname);
        custHistory= FirebaseDatabase.getInstance().getReference("CustHistory").child(parlourname);
        custBookings=FirebaseDatabase.getInstance().getReference("Bookings").child(username);

        logout=findViewById(R.id.logout);

        t0=findViewById(R.id.pname);


        t1= findViewById(R.id.cust);
        t2= findViewById(R.id.serv);
        t3= findViewById(R.id.date);
        t4= findViewById(R.id.time);
        t5= findViewById(R.id.total);
        t6= findViewById(R.id.adv);
        t7= findViewById(R.id.gross);


       // menu=getIntent().getStringExtra("MENU");
       // username=getIntent().getStringExtra("UserName");
        category=getIntent().getStringExtra("CATEGORY");
       // s=menu+"("+category+")";
        t0.setText(parlourname);
          t1.setText(username);
        t2.setText(category);

        String[] a = category.split(" ",0);

        int sum=0;
       // int i=0;
        for(String total : a)
        {
            if(isInteger(total))
            {
               // Toast.makeText(this,"entry", Toast.LENGTH_SHORT).show();
                sum=sum+Integer.parseInt(total);

             }
        }




        sp=(Spinner) findViewById(R.id.spinner);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                // Notify the selected item text
                //Toast.makeText(getApplicationContext(), "Time Selected : " + selectedItemText, Toast.LENGTH_SHORT).show();
                t4.setText(selectedItemText);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        date=getIntent().getStringExtra("DATE");
        t3.setText(date);
         t5.setText(String.valueOf(sum));
         double advance=0.3*(double) sum;
        t6.setText(String.valueOf(advance));
        double rem=(double)sum-advance;
        t7.setText(String.valueOf(rem));
        b1=findViewById(R.id.confirm);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String custname=t1.getText().toString();
                String date=t3.getText().toString();
                String time=t4.getText().toString();
                String service=t2.getText().toString();




                String uploadId = mDatabaseRef.push().getKey();

                String cust_id=uploadId;

                Customers customers=new Customers(cust_id,mail,custname,date,time,service);

                mDatabaseRef.child(uploadId).setValue(customers);
                custHistory.child(uploadId).setValue(customers);
                custBookings.child(uploadId).setValue(customers);

                SendMail sm = new SendMail(Fixit.this, parlourmail," subject", "New Booking Placed.Please check it!", "Your  appointment request is in queue!", "Your booking  is placed!");
                sm.execute();

              //  Toast.makeText(Fixit.this, "Booking Placed!", Toast.LENGTH_SHORT).show();

              //  FirebaseDatabase.getInstance().getReference("Customers").child(parlourname).push().getKey()

            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // mAuth.getCurrentUser().getEmail();
                Toast.makeText(Fixit.this, "Signed Out", Toast.LENGTH_SHORT).show();
                finish();
                startActivity(new Intent(Fixit.this,UserLoginPg.class));
            }
        });
    }
    public static boolean isInteger(String s){
        try {
            Integer.parseInt(s);
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }
}
