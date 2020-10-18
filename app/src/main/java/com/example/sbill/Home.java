package com.example.sbill;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class Home extends AppCompatActivity {
    GoogleSignInClient mGoogleSignInClient = null;
    TextView textView = (TextView)findViewById(R.id.textView);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        if (account == null){
            textView.setText(account.getEmail());
        }
        else {
            //user has signed in, direct to home page
        }

        Button button = (Button) findViewById(R.id.makePayment);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                gotoMakePayment(v);
            }
        });
    }
    public void gotoMakePayment(View view){
        Intent intent=new Intent(this,MakePayment.class);
        startActivity(intent);
    }
}