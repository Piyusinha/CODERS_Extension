package com.piyu.uidashboard;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class hackerranksite extends AppCompatActivity {

    private RecyclerView hackerrankRecyclerView;
    private GridLayoutManager gridLayoutManager;

    private ProgressBar progressBar;
 private Button mback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hackerranksite);
        progressBar =(ProgressBar)findViewById(R.id.hackerrankprogress);
        progressBar.setVisibility(View.VISIBLE);
        hackerrankRecyclerView=(RecyclerView) findViewById(R.id.hackerankrecy);
        hackerrankRecyclerView.setHasFixedSize(true);


        gridLayoutManager =new GridLayoutManager(this,GridLayoutManager.VERTICAL);
        hackerrankRecyclerView.setLayoutManager(gridLayoutManager);

        mback =(Button) findViewById(R.id.hackerrantoback);
        mback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k=new Intent(hackerranksite.this,MainActivity.class);
                k.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(k);
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);

            }
        });
    }

}
