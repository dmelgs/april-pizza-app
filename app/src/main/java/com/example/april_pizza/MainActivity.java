package com.example.april_pizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    CheckBox hawaiian, cheese, buffalo, meat, pepperoni, water, coke, sprite;
    Button order;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ref();
        String uname =User.getUsername();
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double total=0;
                methods method = new methods();

                StringBuilder result=new StringBuilder();
                //todo check user is logged in or null
                if(uname == null){
                    result.append("\n No user logged in");
                    Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_SHORT).show();
                    BackToLogin();
                }

                try{
                   if(!cb_validator()){
                       result.append("No Items Selected");
                       Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_SHORT).show();
                       return;
                   }
                        result.append("Order Receipt: ");
                        if(hawaiian.isChecked()){
                            result.append("\n Hawaiian Pizza 300Php");
                            total+=300;
                            method.addOrder(hawaiian.getText());
                        }
                        if(cheese.isChecked()){
                            result.append("\n Cheese Pizza 270Php");
                            total+=270;
                            method.addOrder(cheese.getText());
                        }
                        if(pepperoni.isChecked()){
                            result.append("\n Pepperoni Pizza 320Php");
                            total+=320;
                            method.addOrder(pepperoni.getText());
                        }
                        if(buffalo.isChecked()){
                            result.append("\n Buffalo Pizza 310Php");
                            total+=310;
                            method.addOrder(buffalo.getText());
                        }
                        if(meat.isChecked()){
                            result.append("\n Meat Pizza 330Php");
                            total+=330;
                            method.addOrder(meat.getText());
                        }
                        if(water.isChecked()){
                            result.append("\n Water Bottle 20Php");
                            total+=20;
                            method.addOrder(water.getText());
                        }
                        if(coke.isChecked()){
                            result.append("\n Coke Bottle 30Php");
                            total+=30;
                            method.addOrder(coke.getText());
                        }
                        if(sprite.isChecked()){
                            result.append("\n Sprite Bottle 30Php");
                            total+=30;
                            method.addOrder(sprite.getText());
                        }
                        result.append("\nTotal: "+total+ "Php");
                        Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_LONG).show();
                        System.out.println();
                        method.getTotal(total);
                        clear();

                }
                catch (Error e){
                    System.out.println(e);
                }
            }
        });

    }

    public void ref(){
        //checkboxes
        hawaiian = findViewById(R.id.hawaiian_cb);
        cheese = findViewById(R.id.cheese_cb);
        buffalo = findViewById(R.id.buffalo_cb);
        meat = findViewById(R.id.meat_cb);
        pepperoni = findViewById(R.id.pepperoni_cb);
        water = findViewById(R.id.water_rb);
        coke = findViewById(R.id.coke_rb);
        sprite = findViewById(R.id.sprite_rb);

        //button
        order = findViewById(R.id.order_button);
    }
    public void BackToLogin(){
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
    }
    public boolean cb_validator(){
        if(!hawaiian.isChecked() && !cheese.isChecked() && !buffalo.isChecked() &&
        !meat.isChecked() && !pepperoni.isChecked()){
            return false;
        }else {
            return true;
        }
    }
    public void clear(){
        hawaiian.setChecked(false);
        cheese.setChecked(false);
        buffalo.setChecked(false);
        meat.setChecked(false);
        pepperoni.setChecked(false);
        water.setChecked(false);
        coke.setChecked(false);
        sprite.setChecked(false);
    }
}