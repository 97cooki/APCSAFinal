package com.example.myfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//if the user chooses
//this holds the functionality of the addition features and screen(s)
public class SecondScreen extends AppCompatActivity {

    //Instantiation for all things/features being displayed on the screen
    private Button addBackScreen; //(buttons)
    private EditText addInput1; //(user inputs)
    private EditText addInput2;
    private Button addition;
    private TextView additionAnswer; //(only viewing texts), this is the answer box
    private Button addSaveButton;

    //this will create all the movement going between in and between the second activity
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);

        //justifiying the buttons and text features that will be displayed on the screen
        addBackScreen = findViewById(R.id.addBackB);
        addInput1 = (EditText) findViewById(R.id.firstAddInput);
        addInput2 = (EditText) findViewById(R.id.secondAddInput);
        addition = (Button) findViewById(R.id.addition);
        additionAnswer = (TextView) findViewById(R.id.additionAnswer);
        addSaveButton = (Button) findViewById(R.id.addSaveInput);

        //when this button is clicked, it will take the user back to the original page
        addBackScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondScreen.this,MainActivity.class);
                startActivity(intent);
            }//end of OnClick method
        });//end of addBackScreen's functionality

        //when this button is clicked, it will take the user to a new page, to document numbers
        addSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondScreen.this, FourthScreen.class);
                startActivity(intent);
            }//end of OnClick method
        });//end of addSaveButton's functionality

        //when this button is clicked, it will add the 2 numbers that the
        // user inputted into the text boxes
        //the sum will be displayed
        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num1 = Integer.parseInt(addInput1.getText().toString());
                int num2 = Integer.parseInt(addInput2.getText().toString());
                int sum = num1 + num2;

                //displaying
                additionAnswer.setText("Answer: " + String.valueOf(sum));
            }//end of OnClick method
        });//end of addition's functionality

    }//end of OnCreate method
}//end of SecondScreen Class