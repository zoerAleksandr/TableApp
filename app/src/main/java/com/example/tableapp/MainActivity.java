package com.example.tableapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView buttonTeach, buttonRepeat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonTeach = findViewById(R.id.buttonTeach);
        buttonRepeat = findViewById(R.id.buttonRepeat);

    }

    public void menu(View view){
        switch (view.getId()){
            case R.id.buttonTeach:
                Intent intentTeach = new Intent(this, TeachActivity.class);
                startActivity(intentTeach);
                break;
            case R.id.buttonRepeat:
                Intent intentRepeat = new Intent(this, RepeatActivity.class);
                startActivity(intentRepeat);
                break;
        }
    }
}