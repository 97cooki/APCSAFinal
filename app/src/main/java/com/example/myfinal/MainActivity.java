package com.example.myfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //Instantiation for the buttons used on the first screen
    private Button addScreen;
    private Button multiplyScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //justifying the buttons that will be used
        addScreen = findViewById(R.id.addScreenB);
        multiplyScreen = findViewById(R.id.multiplyScreenB);

        //when this button is clicked, it wil take you to the second screen with the addition
        addScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondScreen.class);
                startActivity(intent);
            }//end of OnClick
        });//end of addScreen's functionality

        //when this button is clicked, it wil take you to the third screen with multiplication
        multiplyScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ThirdScreen.class);
                startActivity(intent);
            }//end of OnClick
        });//end of multiply screen's functionality
    }//end of OnCreate method
}//end of MainActivity class