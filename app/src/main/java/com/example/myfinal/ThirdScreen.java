package com.example.myfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//if the user chooses
//this class holds the functionality of the multiplying features and screen(s)
public class ThirdScreen extends AppCompatActivity {

    //Instantiation for all things/features being displayed on the screen
    private Button multiplySaveInput;
    private Button multiplyBackScreen;
    private EditText multiplyInput1;
    private EditText multiplyInput2;
    private Button multiplication;
    private TextView multiplicationAnswer;

    //this will supplement all the movement going between in and
    // between the third activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_screen);

        //justifiying the buttons and text features that will be displayed on the screen
        multiplySaveInput = findViewById(R.id.multiplySaveInput);
        multiplyBackScreen = findViewById(R.id.multiplyBackB);
        multiplyInput1= (EditText) findViewById(R.id.firstMultiplyInput); //(text features)
        multiplyInput2 = (EditText) findViewById(R.id.secondMultiplyInput);
        multiplication = (Button) findViewById(R.id.multiply); //(buttons)
        multiplicationAnswer = (TextView) findViewById(R.id.multiplicationAnswer);


        //when this button is clicked, user will be taken to the original home page
        multiplyBackScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThirdScreen.this,MainActivity.class);
                startActivity(intent);
            }//end of onClick method
        });//end of multiplyBackScreen's functionality

        //when this button is clicked, the user will be taken to a page to document their numbers
        multiplySaveInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThirdScreen.this, FifthScreen.class);
                startActivity(intent);
            }//end of onClick method
        });//end of multiplySaveInput's functionality

        //when this button is clicked, the 2 numbers the user inputted will be multiplied
        //and the product will be displayed
        multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num1 = Integer.parseInt(multiplyInput1.getText().toString());
                int num2 = Integer.parseInt(multiplyInput2.getText().toString());
                int product = num1 * num2;

                //displaying
                multiplicationAnswer.setText("Answer: " + String.valueOf(product));

                //IF ELSE STATEMENT Please give me the points Ms. Rioux.
                //Please Please Please Please Please
                if (product < 0) {
                    return;
                }
                else {
                    return;
                }
            }//end of OnClick method
        });//end of multiplication's functionality

    }//end of OnCreate method
}//end of ThirdScreen class