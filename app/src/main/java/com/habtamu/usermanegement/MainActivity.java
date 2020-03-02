package com.habtamu.usermanegement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button login;
    Button register;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=(Button) findViewById(R.id.loginFirst);
        register=(Button) findViewById(R.id.registerfirst);
        image=findViewById(R.id.users_image);


    }

    public void clicklogin(View view) {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,UserLoginActivity.class);
                startActivity(intent);
            }
        });
    }

    public void onclickregister(View view) {
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,UserRegisterActivity.class);
                startActivity(intent);
            }
        });

    }

}
