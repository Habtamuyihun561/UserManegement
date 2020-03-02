package com.habtamu.usermanegement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UserLoginActivity extends AppCompatActivity {
    EditText userName;
    EditText password;
    Button login;
    Button cancel;
    String FullName;
    String UserPassword;
    SharePreferenceIdentity sharePreferenceIdentity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        password=(EditText) findViewById(R.id.password_entry);
        userName=(EditText) findViewById(R.id.UserName);
        login=(Button) findViewById(R.id.loginButton);
        cancel=(Button) findViewById(R.id.cancelButton);
        onclickCancel(cancel);
        loginInto(login);
        sharePreferenceIdentity=new SharePreferenceIdentity(this);
        if (sharePreferenceIdentity.getUserLogged()){
            startActivity(new Intent(getApplicationContext(),UserInfoActivity.class));
            finish();
        }

    }

    public void loginInto(View view) {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
               SharedPreferences sharedPreferences=getSharedPreferences("MyData", MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("USERNAMEV",userName.getText().toString());
                editor.putString("USERPASSWORDV",password.getText().toString());
                editor.commit();
                sharePreferenceIdentity.setLogin(true);

                Intent intent=new Intent(UserLoginActivity.this ,UserInfoActivity.class);
                startActivity(intent);
            }}
        });

    }

    public void onclickCancel(View view){
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(UserLoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
    public boolean validate(){
        boolean valid = false;
        DatabaseAddapter databaseAddapter=new DatabaseAddapter(this);
        Cursor cursor=databaseAddapter.getAllmodels();
        while (cursor.moveToNext()){
         String Username =cursor.getString(2);
         String Password=cursor.getString(4);
         if(Username.equals(userName.getText().toString()
                 )) {
             valid=true;
             userName.setError(null);
         }else{
             valid=false;
             userName.setError("please enter correct user name");}

         if(Password.equals(password.getText().toString())){
             valid=true;
            password.setError(null);
         }
         else {
             valid=false;
             password.setError("please enter the correct password");
         }

         }
        return valid;
    }

    }

