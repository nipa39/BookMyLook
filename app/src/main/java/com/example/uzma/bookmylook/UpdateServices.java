package com.example.uzma.bookmylook;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

public class UpdateServices extends AppCompatActivity {

    public CheckBox chk1,chk2,chk3,chk4,chk5,chk6;
    private Button b;
    private EditText ed1,ed2,ed3,ed4,ed5;
    private Double val;
    private Double d1,d2,d3,d4,d5,d6;
    private TextView t;
    private String s1,s2,s3,s4,s5,s6;
    String test;//res1;
    String sessionId,uid;
    //  int res=0;
    // private FirebaseAuth mAuth;

    // DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_services);

        //   res=res+1;
        //   res1=Integer.toString(res);

       // sessionId=getIntent().getStringExtra("EXTRA_SESSION_ID");

        test=getIntent().getStringExtra("Pname");
      //  uid=getIntent().getStringExtra("Uid");
        //  Toast.makeText(this, test, Toast.LENGTH_SHORT).show();

        chk1=(CheckBox)findViewById(R.id.cb1);
        chk2=(CheckBox)findViewById(R.id.cb2);
        chk3=(CheckBox)findViewById(R.id.cb3);
        chk4=(CheckBox)findViewById(R.id.cb4);
        chk5=(CheckBox)findViewById(R.id.cb5);
        // chk6=(CheckBox)findViewById(R.id.cb6);

        b=(Button)findViewById(R.id.button01);

        ed1=(EditText)findViewById(R.id.e1);
        ed2=(EditText)findViewById(R.id.e2);
        ed3=(EditText)findViewById(R.id.e3);
        ed4=(EditText)findViewById(R.id.e4);
        ed5=(EditText)findViewById(R.id.e5);

        t=findViewById(R.id.txt01);

        // databaseReference = FirebaseDatabase.getInstance().getReference("hello");

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Toast.makeText(MainActivity.this, " hello ", Toast.LENGTH_SHORT).show();
                try{
                    s1="no";
                    s2="no";
                    s3="no";
                    s4="no";
                    s5="no";

                    t.setText("");
                    // val=Double.parseDouble(e.getText().toString().trim());
                    if(chk1.isChecked()== true){
                        //d1=(val+273);
                        //s1=val.toString() + " degree celcius is equal to "+ d1.toString() + " kelvin";
                        s1="EyeMakeup  "+ed1.getText().toString().trim();

                    }

                    if(chk2.isChecked()== true){
                        //d2=(val*1000);
                        // s2=val.toString() + " kilometer is equal to "+ d2.toString() + " meter";
                        //t.setText(s2+"\n");
                        s2="HairRebonding  "+ed2.getText().toString().trim();

                    }
                    if(chk3.isChecked()== true){
                        // d3=(val*16);
                        // s3=val.toString() + " pound is equal to "+ d3.toString() + " ounces";
                        //t.setText(s3+"\n");
                        s3="BridalMakeup  "+ed3.getText().toString().trim();

                    }
                    if(chk4.isChecked()== true){
                        // d4=(val*12);
                        // s4=val.toString() + " foot is equal to "+ d4.toString() + " inches";
                        // t.setText(s4+"\n");
                        s4="DesignerMehendi  "+ed4.getText().toString().trim();

                    }
                    if(chk5.isChecked()== true){
                        //  d5=(val*1.61);
                        //  s5=val.toString() + " mile is equal to "+ d5.toString() + " kilometers";
                        s5="Facial/Spa  "+ed5.getText().toString().trim();

                    }


                    //  t.setText(s1+"\n"+s2+"\n"+s3+"\n"+s4+"\n"+s5);

                    Service service = new Service(s1,s2,s3,s4,s5);

                    // String id = databaseReference.push().getKey();
                    // databaseReference.child(id).setValue(service);
                    FirebaseDatabase.getInstance().getReference("Services").child(test)
                            .setValue(service).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(UpdateServices.this, "Updated", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });



                }
                catch(Exception e){
                    e.printStackTrace();
                }

            }
        });
    }
}
