package com.piyu.uidashboard;

import android.arch.core.executor.TaskExecutor;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.chaos.view.PinView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class otp extends AppCompatActivity implements View.OnClickListener {
    private PinView pinView;
    private Button next;
    private  String otpsend;
    //  private TextView toptext;
//  private EditText;
    private LinearLayout first, second;
    private EditText username, phoneno;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        mAuth=FirebaseAuth.getInstance();
        pinView = (PinView) findViewById(R.id.pinview);
        next = (Button) findViewById(R.id.button);
        username = (EditText) findViewById(R.id.username);
        phoneno = (EditText) findViewById(R.id.userphoneno);
        first = (LinearLayout) findViewById(R.id.linearLayout1);
        second = (LinearLayout) findViewById(R.id.linearLayout2);
        first.setVisibility(View.VISIBLE);

        next.setOnClickListener(this);

    }
    private void sendcode(String no)
    {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(no,60, TimeUnit.SECONDS, TaskExecutors.MAIN_THREAD,mCallBack);
    }
    private  void verification(String enterotp)
    {
        PhoneAuthCredential credential=PhoneAuthProvider.getCredential(otpsend,enterotp);
        SingnWithCredential(credential);
    }
    private void SingnWithCredential(PhoneAuthCredential credential)
    {
      mAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
          @Override
          public void onComplete(@NonNull Task<AuthResult> task) {
              if(task.isSuccessful())
              {
                  Intent k = new Intent(otp.this, MainActivity.class);
                  k.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK );
                  startActivity(k);
                  overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
              }
              else
              {   pinView.setLineColor(Color.RED);
                  Toast.makeText(otp.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
              }
          }
      });
    }
  private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallBack=new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

      @Override
      public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
//          super.onCodeSent(s, forceResendingToken);
          otpsend=s;
      }

      @Override
      public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
           String code=phoneAuthCredential.getSmsCode();
           pinView.setText(code);
      }

      @Override
      public void onVerificationFailed(FirebaseException e) {
          Toast.makeText(otp.this, e.getMessage(), Toast.LENGTH_SHORT).show();

      }
  };

    @Override
    public void onClick(View v) {
        if (next.getText().equals("LET'S GO")) {
            String name = username.getText().toString();
            String phone = phoneno.getText().toString();
            if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(phone) && phone.length() == 13) {
                first.setVisibility(View.GONE);
                second.setVisibility(View.VISIBLE);
                sendcode(phone);
                next.setText("Verify");
            } else {
                if (phone.length() < 13 || phone.length() > 13) {
                    if (phone.length() == 10) {
                        Toast.makeText(this, "Please Add Country Code", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(otp.this, "Enter Valid No", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(otp.this, "Please Enter Details", Toast.LENGTH_SHORT).show();
                }
            }


        } else if (next.getText().equals("Verify")) {
            String otp = pinView.getText().toString();
                verification(otp);

        }

    }
}
