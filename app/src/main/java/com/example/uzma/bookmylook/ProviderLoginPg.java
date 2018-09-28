package com.example.uzma.bookmylook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

//Service provider er login pg(after registration)
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class ProviderLoginPg extends AppCompatActivity implements View.OnClickListener {

    private Button b1;
    private EditText e1;
    private EditText e2;
    private TextView t1;
    private ProgressDialog p1;
    private FirebaseAuth f1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_login_pg);

        f1=FirebaseAuth.getInstance();

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
                            Toast.makeText(ProviderLoginPg.this, "Ok", Toast.LENGTH_SHORT).show();
                            finish();
                            startActivity(new Intent(getApplicationContext(),ProviderProfile.class));
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
            startActivity(new Intent(this,CommonRegistration.class));
        }
    }
}

