package com.piyu.uidashboard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.FloatRange;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.piyu.uidashboard.ApiInterface.ApiInterface;
import com.piyu.uidashboard.model.Application;
import com.piyu.uidashboard.model.Results;


import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    ApiInterface apiInterface;
    Button btn_profile, btn_hkr, btn_health, btn_goals, btn_finance, btn_comfort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        apiInterface=RetrofitClient.getClient(MainActivity.this).create(ApiInterface.class);
        apiInterface.getResults().subscribeOn(Schedulers.io())

                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Application>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Application results) {
                        Log.d(TAG, "onNext: "+ results.getResults().getUpcoming().get(0).getName());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: "+e.getLocalizedMessage() );
                    }

                    @Override
                    public void onComplete() {

                    }
                });

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
