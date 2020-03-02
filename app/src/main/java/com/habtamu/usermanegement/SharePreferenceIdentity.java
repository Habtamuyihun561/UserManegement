package com.habtamu.usermanegement;

import android.content.Context;
import android.content.SharedPreferences;

public class SharePreferenceIdentity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;

    public SharePreferenceIdentity(Context context) {
        this.context = context;
        sharedPreferences=context.getSharedPreferences("MyData",Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
    }
    public  void setLogin(boolean loginvalue){
        editor.putBoolean("LoginKey",loginvalue);
        editor.commit();
    }
    public boolean getUserLogged(){
        return sharedPreferences.getBoolean("LoginKey",false);

        }

}
