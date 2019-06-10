package com.piyu.uidashboard;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

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

public class CodeChef extends AppCompatActivity {
    private static final String TAG = "CodeChef";
    private List<jsonResponse> responseList;
    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    private  CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_chef);
        recyclerView=(RecyclerView) findViewById(R.id.codechefrecycler);
        recyclerView.setHasFixedSize(true);
        new openurl().execute();
        new parseJson().execute();
        new parssefuturejson().execute();
        responseList =new ArrayList<>();
        gridLayoutManager =new GridLayoutManager(this,GridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter =new CustomAdapter(this ,responseList);
        recyclerView.setAdapter(adapter);



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
               URL url =new URL("http://3.219.6.94/phpcurl");
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
       }

       @Override
       protected String doInBackground(String... strings) {
           OkHttpClient client =new OkHttpClient();
           Request request =new Request.Builder().url("http://3.219.6.94/phpcurl/present1.json").build();
           try {
               Response response=client.newCall(request).execute();
               JSONArray array= null;
               try {
                   array = new JSONArray(response.body().string());
               } catch (JSONException e) {

               }
               for(int i=0;i<array.length();i++)
               {
                   JSONArray array1= null;
                   try {
                       array1 = array.getJSONArray(i);
                   } catch (JSONException e) {
                       e.printStackTrace();
                   }
                   jsonResponse response1= null;
                   try {
                       response1 = new jsonResponse(array1.getString(0),array1.getString(1),array1.getString(2),array1.getString(3));
                   } catch (JSONException e) {
                       e.printStackTrace();
                   }
                   responseList.add(response1);

               }
           } catch (IOException e) {
               e.printStackTrace();
           }
           return null;
       }
   }
    private  class parssefuturejson extends AsyncTask<String,Void,String>
    {
        @Override
        protected void onPostExecute(String s) {
            adapter.notifyDataSetChanged();
        }

        @Override
        protected String doInBackground(String... strings) {
            OkHttpClient client =new OkHttpClient();
            Request request =new Request.Builder().url("http://3.219.6.94/phpcurl/future.json").build();
            try {
                Response response=client.newCall(request).execute();
                JSONArray array= null;
                try {
                    array = new JSONArray(response.body().string());
                } catch (JSONException e) {

                }
                for(int i=0;i<array.length();i++)
                {
                    JSONArray array1= null;
                    try {
                        array1 = array.getJSONArray(i);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    jsonResponse response1= null;
                    try {
                        response1 = new jsonResponse(array1.getString(0),array1.getString(1),array1.getString(2),array1.getString(3));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    responseList.add(response1);

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
