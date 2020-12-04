package com.example.ecofreak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText mtextusername;
    EditText mtextpassword;
    EditText mtextconfirmpassword;
    Button msignup;
    TextView mtextviewlogin;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mtextusername= findViewById(R.id.TextUsername);
        mtextpassword= findViewById(R.id.TextPassword);
        mtextconfirmpassword= findViewById(R.id.editTextCnfPassword);
        msignup= findViewById(R.id.button_sign_up);
        mtextviewlogin= findViewById(R.id.TextView_Login);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mtextviewlogin.setOnClickListener(v -> {

            Intent loginintent= new Intent(RegisterActivity.this, com.example.ecofreak.MainActivity.class);
            startActivity(loginintent);
        });


        msignup.setOnClickListener(v -> {
            String Username= mtextusername.getText().toString().trim();
            String Password = mtextpassword.getText().toString().trim();
            String Confirm_Password=mtextconfirmpassword.getText().toString().trim();
            if(Password.equals(Confirm_Password)){
                long val= db.adduser(Username,Password);
                if(val>0){
                    Toast.makeText(RegisterActivity.this,"Registeration successful",Toast.LENGTH_SHORT).show();
                    Intent move_to_login=new Intent(RegisterActivity.this, com.example.ecofreak.MainActivity.class);
                    startActivity(move_to_login);
                }
                else{
                    Toast.makeText(RegisterActivity.this,"Registration Unsuccessful",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}