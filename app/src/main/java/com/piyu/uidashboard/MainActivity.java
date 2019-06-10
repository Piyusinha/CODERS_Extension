package com.piyu.uidashboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    Button btn_profile, btn_education, btn_health, btn_goals, btn_finance, btn_comfort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_profile = findViewById(R.id.buttonprofile);
//        btn_education = findViewById(R.id.buttoneducation);
        btn_health = findViewById(R.id.buttonhealth);
//        btn_goals = findViewById(R.id.buttongoals);
//        btn_comfort = findViewById(R.id.buttoncomfort);
//        btn_finance = findViewById(R.id.buttonfinance);
        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "CodeChef", Toast.LENGTH_SHORT).show();
                Intent k = new Intent(MainActivity.this, CodeChef.class);
                startActivity(k);
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
            }
        });
//        btn_education.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "EDUCATION", Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}
