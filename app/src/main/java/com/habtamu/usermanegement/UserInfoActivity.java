package com.habtamu.usermanegement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class UserInfoActivity extends AppCompatActivity {
    EditText fullName,UserName;
    RecyclerView recyclerView;
    UserAddapter addapter;
    ArrayList<Model> models=new ArrayList<Model>();
    SharePreferenceIdentity sharePreferenceIdentity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        addapter=new UserAddapter(this,models);
        retrieve();
        sharePreferenceIdentity=new SharePreferenceIdentity(this);
        if (!sharePreferenceIdentity.getUserLogged()){
            logout();
        }

    }
    private void retrieve(){

        DatabaseAddapter database=new DatabaseAddapter(this);
        Cursor cursor=database.getAllmodels();
        while (cursor.moveToNext()){
            int id=cursor.getInt(0);
            String fullName=cursor.getString(1);
            String userName=cursor.getString(2);
            String email=cursor.getString(3);
            String password=cursor.getString(4);
            String cinfirmation=cursor.getString(5);
            String phone_number=cursor.getString(6);
            String gender=cursor.getString(7);
            Model model=new Model(fullName,userName,email,
                    password,phone_number,
                    gender);
            models.add(model);
        }
        if(!(models.size()<1)){
            recyclerView.setAdapter(addapter);

        }
    }

    private  void  logout(){
        sharePreferenceIdentity.setLogin(false);
        SharedPreferences sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.remove("USERNAMEV");
        editor.remove("USERPASSWORDV");
        editor.commit();
        Toast.makeText(getBaseContext(),"your credentals are deleted from shared preference",Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(UserInfoActivity.this,UserLoginActivity.class);
        startActivity(intent);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.logout_mainu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemLogout:
                logout();

        }
        return true;

}}
