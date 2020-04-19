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
import java.util.BitSet;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CodeChef extends AppCompatActivity {
    private static final String TAG = "CodeChef";

    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;

    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_chef);
        progressBar=(ProgressBar) findViewById(R.id.codechefprogress);
        progressBar.setVisibility(View.VISIBLE);
        Button btnback=(Button)findViewById(R.id.codecheftomain);
        recyclerView=(RecyclerView) findViewById(R.id.codechefrecycler);
        recyclerView.setHasFixedSize(true);


        gridLayoutManager =new GridLayoutManager(this,GridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k=new Intent(CodeChef.this,MainActivity.class);
                k.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(k);
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }
        });


    }

}
