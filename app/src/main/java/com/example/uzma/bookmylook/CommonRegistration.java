package com.example.uzma.bookmylook;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class CommonRegistration extends AppCompatActivity implements View.OnClickListener{

    private EditText etname,etEmail,etpass,etPhone;
    // private TextView t1;
    String id1;
    String id2;//default

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_registration);
        etEmail=findViewById(R.id.editTextEmail);
        etname=findViewById(R.id.editTextName);
        etpass=findViewById(R.id.editTextPassword);
        etPhone=findViewById(R.id.edit_text_phone);
        //    t1=findViewById(R.id.txt1);

        mAuth=FirebaseAuth.getInstance();

        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.txt1).setOnClickListener(this);
        findViewById(R.id.txtuser).setOnClickListener(this);



    }

    @Override
    protected void onStart() {
        super.onStart();

        if(mAuth.getCurrentUser()==null){
            id2="No";
            //cvshb
            Intent intent = new Intent(getApplicationContext(),Retrieve.class);
            //   intent.putExtra("EXTRA_SESSION_ID", id1);
            intent.putExtra("UserName",id2);
            // startActivity(intent);

        }

    }

    private void registerUser(){
        final String name = etname.getText().toString().trim();
        final String email = etEmail.getText().toString().trim();
        String password = etpass.getText().toString().trim();
        final String phone = etPhone.getText().toString().trim();

        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){

                            final User user = new User(
                                    name,
                                    email,
                                    phone
                            );

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        String username=user.getName();
                                        Toast.makeText(CommonRegistration.this, "Success ! Done", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(),UserLoginPg.class);
                                        //   intent.putExtra("EXTRA_SESSION_ID", id1);
                                        //   intent.putExtra("UserName",username);
                                        startActivity(intent);
                                    }
                                }
                            });



                        }
                        else {
                            Toast.makeText(CommonRegistration.this,task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

    private void registerServiceProvider(){
        final String name = etname.getText().toString().trim();
        final String email = etEmail.getText().toString().trim();
        String password = etpass.getText().toString().trim();
        final String phone = etPhone.getText().toString().trim();

        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){

                            final User user = new User(
                                    name,
                                    email,
                                    phone
                            );

                            FirebaseDatabase.getInstance().getReference("ServiceProviders")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        id1=user.getName();
                                        // id1=user.getEmail();
                                        Intent intent = new Intent(getApplicationContext(), MyService.class);
                                        intent.putExtra("EXTRA_SESSION_ID", id1);
                                        startActivity(intent);
                                        // finish();
                                        // startActivity(new Intent(getApplicationContext(),MyServices.class));
                                    }
                                }
                            });

                            //   FirebaseDatabase.getInstance().getReference("Services").setValue(user.getName());



                        }
                        else {
                            Toast.makeText(CommonRegistration.this,task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn1){
            registerUser();
        }
        else if(v.getId()==R.id.btn2){
            registerServiceProvider();
        }
        else if(v.getId()==R.id.txtuser){
            finish();
            startActivity(new Intent(this,UserLoginPg.class));
            // Intent i=new Intent(this,Retrieve.class);
            // startActivity(i);
        }
        else if(v.getId()==R.id.txt1){
            finish();
            startActivity(new Intent(this,ProviderLoginPg.class));
            // Intent i=new Intent(this,Retrieve.class);
            // startActivity(i);
        }

    }
}
