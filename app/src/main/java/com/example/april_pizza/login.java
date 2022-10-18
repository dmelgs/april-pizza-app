package com.example.april_pizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    EditText uname, pass;
    Button  login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ref(); //call ref method

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder result=new StringBuilder();
                String username = uname.getText().toString();
                String password = pass.getText().toString();
                if(!username.equals("") && !password.equals("")){
                    User user = new User(username, password);
                    user.setUsername(username);
                    user.setPassword(password);
                    OpenMainActivity();
                    result.append("Welcome! " + username);
                    Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_LONG).show();
                }else{
                    result.append("Invalid User or Password");
                    Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    public void ref(){
        //edit text
        uname =findViewById(R.id.username);
        pass = findViewById(R.id.password);

        //button
        login= findViewById(R.id.login);
    }

    //Function to open the main activity if logging in
    public void OpenMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}