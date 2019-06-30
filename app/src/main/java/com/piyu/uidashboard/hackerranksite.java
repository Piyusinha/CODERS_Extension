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
    private List<hackerrankresponse> hackerrankresponseList;
    private RecyclerView hackerrankRecyclerView;
    private GridLayoutManager gridLayoutManager;
    private  hackerrankadapter adapter;
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
        new openurl().execute();
        new parseJson().execute();
        hackerrankresponseList =new ArrayList<>();
        gridLayoutManager =new GridLayoutManager(this,GridLayoutManager.VERTICAL);
        hackerrankRecyclerView.setLayoutManager(gridLayoutManager);
        adapter =new hackerrankadapter(this ,hackerrankresponseList);
        hackerrankRecyclerView.setAdapter(adapter);
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
    private class openurl extends AsyncTask<String,Void, String>
    {
        private static final String TAG = "openurl";
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }

        @Override
        protected String doInBackground(String... strings) {
            try
            {
                URL url =new URL("http://3.219.6.94/phpcurl/hackerrank.php");
                HttpURLConnection connection= (HttpURLConnection) url.openConnection();
                connection.connect();
                if( connection.getResponseCode() == HttpURLConnection.HTTP_OK ){
                    InputStream is = connection.getInputStream();
                }else{
                    InputStream err = connection.getErrorStream();
                }
                Log.d(TAG, "doInBackground: done executing");
                connection.disconnect();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            return  null;

        }
    }
    private  class parseJson extends AsyncTask<String,Void,String>
    {
        @Override
        protected void onPostExecute(String s) {
            adapter.notifyDataSetChanged();
            progressBar.setVisibility(View.GONE);
        }

        @Override
        protected String doInBackground(String... strings) {
            OkHttpClient client =new OkHttpClient();
            Request request =new Request.Builder().url("http://3.219.6.94/phpcurl/hackerrank.json").build();
            try {
                Response response=client.newCall(request).execute();
                JSONArray array= null;
                try {
                    array = new JSONArray(response.body().string());
                } catch (JSONException e) {

                }
                for(int i=0;i<array.length();i++)
                {

                    JSONObject array1= null;
                    try {


                        array1 = array.getJSONObject(i);


                            hackerrankresponse response1= null;
//                       if(array1.getString("ended").equals("false")) {
                           response1 = new hackerrankresponse(array1.getString("name"), array1.getString("description"), array1.getString("get_starttimeiso"), array1.getString("get_endtimeiso"), array1.getString("slug"));
                           hackerrankresponseList.add(response1);
//                       }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }




                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
