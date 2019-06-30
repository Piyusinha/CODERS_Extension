package com.piyu.uidashboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    Button btn_profile, btn_hkr, btn_health, btn_goals, btn_finance, btn_comfort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_profile = findViewById(R.id.buttonprofile);
       Button logout=(Button)findViewById(R.id.maintologin);
        btn_hkr = findViewById(R.id.buttonphacker);
        btn_health = findViewById(R.id.buttonhealth);
//        btn_goals = findViewById(R.id.buttongoals);
//        btn_comfort = findViewById(R.id.buttoncomfort);
//        btn_finance = findViewById(R.id.buttonfinance);
        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "CodeChef", Toast.LENGTH_SHORT).show();
                Intent k = new Intent(MainActivity.this, CodeChef.class);
                k.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(k);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
        });
         logout.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                    FirebaseAuth.getInstance().signOut();
                 Intent k=new Intent(MainActivity.this,otp.class);
                 k.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
                 startActivity(k);
                 overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
             }
         });
         btn_hkr.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Toast.makeText(MainActivity.this, "HackerRank", Toast.LENGTH_SHORT).show();
                 Intent k = new Intent(MainActivity.this, hackerranksite.class);
                 k.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
                 startActivity(k);
                 overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
             }
         });
//        btn_finance.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "FINANCE", Toast.LENGTH_SHORT).show();
//            }
//        });
//        btn_goals.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "GOALS", Toast.LENGTH_SHORT).show();
//            }
//        });
//        btn_comfort.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "COMFORT", Toast.LENGTH_SHORT).show();
//            }
//        });
        btn_health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Code Forces", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onClick: health ");
                Intent k1 = new Intent(MainActivity.this, CodeForces.class);
                startActivity(k1);
                k1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
        });
//        btn_education.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "EDUCATION", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(FirebaseAuth.getInstance().getCurrentUser()==null )
        {
            Intent k=new Intent(MainActivity.this,onAppOpen.class);
                  k.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(k);
        }
    }
}
