package com.example.uzma.bookmylook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class GridLayout extends AppCompatActivity {

    ImageView rateus;
    String sessionId;
    String username,mail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_layout);
        rateus=findViewById(R.id.rateus);
        username=getIntent().getStringExtra("UserName");
        mail=getIntent().getStringExtra("Email");
        sessionId=getIntent().getStringExtra("EXTRA_SESSION_ID");
        rateus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Rating.class);
                intent.putExtra("EXTRA_SESSION_ID", sessionId);
                intent.putExtra("UserName",username);
                intent.putExtra("Email",mail);
                startActivity(intent);
            }
        });
    }
}
