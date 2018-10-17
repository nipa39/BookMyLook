package com.example.uzma.bookmylook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EmailNotification extends AppCompatActivity {

    private EditText txtto,txtsub,txtmess,txtfrom;
    String umail,pmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_notification);
        umail=getIntent().getStringExtra("Umail");
        pmail=getIntent().getStringExtra("Mail");

        txtto=findViewById(R.id.email);
        txtto.setText(umail);
        txtsub=findViewById(R.id.subject);
        txtmess=findViewById(R.id.txtmessage);
        txtfrom=findViewById(R.id.fromemail);
        txtfrom.setText(pmail);

        Button butnsend=findViewById(R.id.btnsend);
        butnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMail();
            }
        });
    }

    private void sendMail(){
        String from=txtfrom.getText().toString();
        String recipientlist=txtto.getText().toString();
       String[] recipients=recipientlist.split(",");

        String subject=txtsub.getText().toString();

        String message=txtmess.getText().toString();

        Intent intent=new Intent(Intent.ACTION_SEND);
     //   intent.putExtra(Intent.EXTRA_EMAIL,from);
        intent.putExtra(Intent.EXTRA_EMAIL,recipients);
        intent.putExtra(Intent.EXTRA_SUBJECT,subject);
        intent.putExtra(Intent.EXTRA_TEXT,message);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent,"Choose an email client"));

    }
}
