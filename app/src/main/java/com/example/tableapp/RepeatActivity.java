package com.example.tableapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class RepeatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repeat);

        ImageView buttonBack = findViewById(R.id.buttonBack);
        ImageView buttonNext = findViewById(R.id.buttonNext);
        ImageView buttonChoice = findViewById(R.id.buttonChoice);
        ImageView buttonInput = findViewById(R.id.buttonInput);
        ImageView buttonByEar = findViewById(R.id.buttonByEar);
    }
    public void menuRepeat (View view){
        switch (view.getId()){
            case R.id.buttonBack:
                Intent intentBack = new Intent(this, MainActivity.class);
                startActivity(intentBack);
                break;
           /* case R.id.buttonNext:
                Intent intentBack = new Intent(this, MainActivity.class);
                startActivity(intentBack);
                break;
            case R.id.buttonChoice:
                Intent intentBack = new Intent(this, MainActivity.class);
                startActivity(intentBack);
                break;
            case R.id.buttonInput:
                Intent intentBack = new Intent(this, MainActivity.class);
                startActivity(intentBack);
                break;
            case R.id.buttonByEar:
                Intent intentBack = new Intent(this, MainActivity.class);
                startActivity(intentBack);
                break;*/

        }
    }
}