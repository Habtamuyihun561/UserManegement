package com.habtamu.usermanegement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

public class UserDetailActivity extends AppCompatActivity {
    TextView fullname,username,emailAddress,
            userpassword,phonenumber,
            usergender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        fullname=(TextView) findViewById(R.id.dfullName);
        username=(TextView) findViewById(R.id.duserName);
        emailAddress=(TextView) findViewById(R.id.demail);
        userpassword=(TextView) findViewById(R.id.dpassword);
        phonenumber=(TextView) findViewById(R.id.dphone_number);
        usergender=(TextView) findViewById(R.id.dgender);

      Intent intent=getIntent();
      fullname.setText("Full Name"+": "+intent.getStringExtra("FULLNAME"));
        username.setText("User Name"+": "+intent.getStringExtra("USERNAME"));
        emailAddress.setText("Email Address"+": "+intent.getStringExtra("EMAIL"));
        userpassword.setText("PassWord"+": "+intent.getStringExtra("PASSWORD"));
        phonenumber.setText("Phone Number"+": "+intent.getStringExtra("PHONENUMBER"));
        usergender.setText("Gende"+": "+intent.getStringExtra("GENDER"));

        }
    }

