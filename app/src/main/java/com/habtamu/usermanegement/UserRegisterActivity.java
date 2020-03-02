package com.habtamu.usermanegement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class UserRegisterActivity extends AppCompatActivity {
    TextView fullName,userName,email,password,cnfirmation,phoneNumber,gender;
    EditText fname,uNAme,emailAddress,userPassword,password_conformation,Pho_num;
    RadioGroup group;
    RadioButton registbuton,cancelbutton;
    Button userRegister,back;
    DatabaseAddapter helper;
    String Gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);
        helper=new DatabaseAddapter(this);
        fullName=(TextView) findViewById(R.id.fulname);
        userName=(TextView) findViewById(R.id.user_name);
        email=(TextView) findViewById(R.id.email_address);
        password=(TextView) findViewById(R.id.password);
        cnfirmation=(TextView) findViewById(R.id.confirm_password);
        phoneNumber=(TextView) findViewById(R.id.phone_number);
        gender=(TextView) findViewById(R.id.gender);

        fname=(EditText) findViewById(R.id.fname);
        uNAme=(EditText) findViewById(R.id.uname);
        emailAddress=(EditText)findViewById(R.id.emaddress);
        userPassword=(EditText) findViewById(R.id.upassword);
        password_conformation=(EditText) findViewById(R.id.confirmssword);
        Pho_num=(EditText) findViewById(R.id.phonom);
        userRegister=(Button) findViewById(R.id.user_registerbtn);
       back=(Button) findViewById(R.id.next_btn);
        group=(RadioGroup) findViewById(R.id.rgender);
        RadioButton checked;
        checked = findViewById(group.getCheckedRadioButtonId());
        Gender=checked.getText().toString();
       registbuton=(RadioButton) findViewById(R.id.male_radiButton);
    cancelbutton=(RadioButton) findViewById(R.id.female_radioButton);


        registerData(userRegister);
        backbtn(back);
    }
    public void registerData(View v){
        userRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                helper.insertData(fname.getText().toString(),
                        userName.getText().toString(),
                        emailAddress.getText().toString(),
                        userPassword.getText().toString(),
                        password_conformation.getText().toString(),
                        Pho_num.getText().toString(),Gender);
               Toast.makeText(getBaseContext(),"You Are successfuly registered",Toast.LENGTH_LONG).show();
      Intent intent=new Intent(UserRegisterActivity.this,UserLoginActivity.class) ;
            startActivity(intent);
            }}});


    }

        public boolean validate() {
            boolean valid = false;

            //Get values from EditText fields
            String FullName = fname.getText().toString();
            String UserName = uNAme.getText().toString();
            String Email = emailAddress.getText().toString();
            String Password = password.getText().toString();
            String Password_confirm = password_conformation.getText().toString();
            String Phonenum = Pho_num.getText().toString();
            String Gender=gender.getText().toString();

            //Handling validation for UserName field
            if (FullName.isEmpty()) {
                valid = false;
                fname.setError("Please enter valid username!");
            } else {
                if (FullName.length() > 4) {
                    valid = true;
                    fname.setError(null);
                } else {
                    valid = false;
                    fname.setError("Username is to short!");
                }
            }
            if (UserName.isEmpty()) {
                valid = false;
                uNAme.setError("Please enter valid name!");
            } else {
                if (UserName.length() > 4) {
                    valid = true;
                    uNAme.setError(null);
                } else {
                    valid = false;
                    uNAme.setError("Username is to short!");
                }
            }

            //Handling validation for Email field
            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
                valid = false;
                email.setError("Please enter valid email!");
            } else {
                valid = true;
                email.setError(null);
            }

            //Handling validation for Password field
            if (Password.isEmpty()) {
                valid = false;
                password.setError("Please enter valid password!");
            } else {
                if (Password.length() > 5) {
                    valid = true;
                    password.setError(null);
                } else {
                    valid = false;
                    password.setError("Password is to short!");
                }
            }
            if(Password_confirm==Password){
                valid=true;
            password_conformation.setError(null);}
            else {
                valid = false;
                password_conformation.setError("please enter the corect password");
            }
            if (Phonenum.isEmpty()) {
                valid = false;
                Pho_num.setError("Please enter valid phoe number!");
            } else {
                if (Phonenum.length() ==10) {
                    valid = true;
                    Pho_num.setError(null);
                } else {
                    valid = false;
                    Pho_num.setError("invalid phone number!");
                }
            }

            return valid;
        }
    public void backbtn(View view){
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(UserRegisterActivity.this,MainActivity.class);
           startActivity(intent); }
        });
    }

}