package com.appeteria.loadingbuttonexample;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.dd.CircularProgressButton;

public class LoginActivity extends AppCompatActivity {

    CircularProgressButton circularProgressButton;
    EditText etUserName, etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        circularProgressButton = (CircularProgressButton ) findViewById(R.id.cpbLogin);
        etUserName = (EditText)findViewById(R.id.etUserName);
        etPassword= (EditText)findViewById(R.id.etPassword);

        circularProgressButton.setIndeterminateProgressMode(true);

        circularProgressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(circularProgressButton.getProgress()==0)
                {
                    circularProgressButton.setProgress(30);
                }
                else if (circularProgressButton.getProgress()==-1)
                {
                    circularProgressButton.setProgress(0);
                }
                else if (circularProgressButton.getProgress()==100)
                {
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(etUserName.getText().toString().equals("Lee") && etPassword.getText().toString().equals("123"))
                        {
                            circularProgressButton.setProgress(100);
                        }
                        else
                        {
                            circularProgressButton.setProgress(-1);
                        }
                    }
                },3000);
            }
        });
    }
}
