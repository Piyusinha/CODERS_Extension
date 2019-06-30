package com.piyu.uidashboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class onAppOpen extends AppCompatActivity {
   private Button otpmenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_app_open);
        otpmenu=(Button) findViewById(R.id.registermenu);
        otpmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k =new  Intent(onAppOpen.this,otp.class);
                startActivity(k);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
;
            }
        });

    }
}
