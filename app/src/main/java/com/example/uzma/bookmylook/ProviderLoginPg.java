package com.example.uzma.bookmylook;

//Service provider er login pg(after registration)

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProviderLoginPg extends AppCompatActivity implements View.OnClickListener {

    private Button b1;
    private EditText e1;
    private EditText e2;
    private TextView t1;
    private ProgressDialog p1;
    private FirebaseAuth f1;
    private User user;
    String username,userid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_login_pg);

     //   userid=getIntent().getStringExtra("Uid");

        f1= FirebaseAuth.getInstance();

       // f1=FirebaseAuth.getInstance();

      /*  if(f1.getCurrentUser()!=null){
            finish();
            startActivity(new Intent(getApplicationContext(),Retrieve.class));
        }*/
        p1= new ProgressDialog(this);
        b1= findViewById(R.id.btn2);
        e1=findViewById(R.id.editTextEmail2);
        e2=findViewById(R.id.editTextPassword2);
        t1=findViewById(R.id.txt2);

        b1.setOnClickListener(this);
        t1.setOnClickListener(this);

    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
    private void userlog(){
        String email = e1.getText().toString().trim();
        String pass = e2.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Please enter your mail", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(pass)){
            Toast.makeText(this, "Enter pass pls", Toast.LENGTH_SHORT).show();
            return;
        }

        p1.setMessage("Logging user...");
        p1.show();

        f1.signInWithEmailAndPassword(email,pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task){
                        p1.dismiss();
                        if(task.isSuccessful()){


                            FirebaseDatabase.getInstance().getReference("ServiceProviders")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(DataSnapshot dataSnapshot) {
                                            user=dataSnapshot.getValue(User.class);
                                            username=user.getName();
                                            userid= FirebaseAuth.getInstance().getCurrentUser().getUid();
                                            Intent intent = new Intent(getApplicationContext(), ProviderProfile.class);
                                            //  Toast.makeText(ProviderLoginPg.this,username, Toast.LENGTH_SHORT).show();
                                            intent.putExtra("ProviderName",username);
                                            intent.putExtra("Uid",userid);
                                           // Toast.makeText(ProviderLoginPg.this, userid, Toast.LENGTH_SHORT).show();
                                            startActivity(intent);
                                           // Toast.makeText(ProviderLoginPg.this, username, Toast.LENGTH_SHORT).show();
                                        }

                                        @Override
                                        public void onCancelled(DatabaseError databaseError) {
                                            Toast.makeText(ProviderLoginPg.this, "Error", Toast.LENGTH_SHORT).show();
                                        }
                                    });

                            // Toast.makeText(ProviderLoginPg.this, "ok", Toast.LENGTH_SHORT).show();

                        }
                    }
                });


    }
    @Override
    public void onClick(View view) {
        if(view==b1){
            userlog();
        }
        if(view==t1){
            finish();
            startActivity(new Intent(this,MainActivity.class));
        }
    }
}
