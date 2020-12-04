package com.example.ecofreak;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText mTextUsername ;
    EditText mTextPassword;
    Button  mButtonLogin;
    TextView mTextViewCreateAnAccount;

    DatabaseHelper db;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mTextUsername= findViewById(R.id.editTextUsername);
        mTextPassword= findViewById(R.id.editTextPassword);
        mButtonLogin= findViewById(R.id.button_sign_in);
        mTextViewCreateAnAccount= findViewById(R.id.TextView_Register);
        db=new DatabaseHelper(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextViewCreateAnAccount.setOnClickListener(view -> {
            Intent registerIntent=new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(registerIntent);


        });


        mButtonLogin.setOnClickListener(v -> {
            String User= mTextUsername.getText().toString().trim();
            String password= mTextPassword.getText().toString().trim();
            boolean res= db.CheckUser(User,password);
            if(res){
                Toast.makeText(MainActivity.this,"Successfully Logged in",Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(MainActivity.this,"Error in login",Toast.LENGTH_SHORT).show();

            }
        });


    }
}