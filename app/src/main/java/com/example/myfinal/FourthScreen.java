package com.example.myfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import android.widget.Toast;

import java.lang.reflect.Type;
import java.util.ArrayList;

//This class holds the functionality for the saving of user input numbers
//Specifically for the addtion option
public class FourthScreen extends AppCompatActivity {

    private static final String SHARED_PREFS = "persist data";
    private static final String SHARED_PREFS_KEY = "list";

    //Instantiation of features that are used on the screen
    Button addSaveBackB;
    Button addSaveButton;
    EditText historyInput;
    ListView listView;
    ArrayList<String> items = new ArrayList<>(); //String is a parameter :DD
    ArrayAdapter<String> listAdapter;


    //this will supplement all the activity happening in this class
    //including back and forth between screens
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_screen);

        //justifying the features that will be used on the screen
        addSaveBackB = (Button) findViewById(R.id.addSaveBackB);
        addSaveButton = (Button) findViewById(R.id.addSaveButton);
        historyInput = (EditText) findViewById(R.id.addTextInput);
        listView = (ListView) findViewById(R.id.listView);

        //these hold the user input
        listAdapter = new ArrayAdapter<>(FourthScreen.this, android.R.layout.simple_list_item_1, items);

        listView.setAdapter(listAdapter);

        //load data
        loadData();

    //when this is clicked, the user can go back the the previous screen (addition)
    addSaveBackB.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(FourthScreen.this, SecondScreen.class);
            startActivity(intent);
        }//end of onClick method
    });//end of addSaveBack buttons functionality

    //when this is clicked, the user's inputted anything will be saved within the list
    addSaveButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String text = historyInput.getText().toString();

            //if there is no item being put into the list, it will show this message
            if ((text == null) || text.trim().equals("")) { //USE OF STRING METHOD
                Toast.makeText(FourthScreen.this, "Item is empty.", Toast.LENGTH_SHORT).show();
                return;
            }

            //if the item is already in the list, and will be "repeated"
            //it will not be added, and show that message
            if (items.contains(text)) { //HEY USE OF STRING METHOD
                Toast.makeText(FourthScreen.this, "Item has already been added.", Toast.LENGTH_SHORT).show();
                return;
            }


            //i dont know what this does but i assume that it sets the text in someway..
            items.add(text);
            listAdapter.notifyDataSetChanged();
            historyInput.setText("");

            //sava data (called)
            saveData();
        }//end of OnClick method
    });//end of OnCreate method
}
    //this will save the data in some way..
    private void saveData() {
        SharedPreferences sp = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        Gson gson = new Gson();
        String jsonString = gson.toJson(items);
        editor.putString(SHARED_PREFS_KEY, jsonString);
        editor.apply();
    }//end of saveData method

    //this will load the data in some way...
    private void loadData() {
        SharedPreferences sp = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sp.getString(SHARED_PREFS_KEY,"");

        if (json.isEmpty()) {
            return;
        }

        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        items.addAll((gson.fromJson(json, type)));
    }//end of loadData method
}//end of FourthScreen class