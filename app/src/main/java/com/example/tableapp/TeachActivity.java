package com.example.tableapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class TeachActivity extends MyAbstractClass {

    Intent intentNext;

    Button table_x1, table_x2, table_x3, table_x4, table_x5, table_x6, table_x7, table_x8, table_x9, reset, buttonBack, buttonVoice, buttonNext;

    ImageView imageView_x1, imageView_x2, imageView_x3, imageView_x4, imageView_x5, imageView_x6, imageView_x7, imageView_x8, imageView_x9;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Сработал метод onDestroy");

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "Сработал метод onCreate TeachActivity");
        super.onCreate(savedInstanceState);
        preferencesTeach = getSharedPreferences(TEACH_LEVEL, Context.MODE_PRIVATE);
        preferences = getSharedPreferences(APP_LEVEL, Context.MODE_PRIVATE);
        setAppLevelChallenge(0);
        setContentView(R.layout.activity_teach);
        buttonBack = findViewById(R.id.buttonBack);
        buttonVoice = findViewById(R.id.buttonVoice);
        buttonNext = findViewById(R.id.buttonNext);
        reset = findViewById(R.id.reset);

        table_x1 = findViewById(R.id.x1);
        table_x2 = findViewById(R.id.x2);
        table_x3 = findViewById(R.id.x3);
        table_x4 = findViewById(R.id.x4);
        table_x5 = findViewById(R.id.x5);
        table_x6 = findViewById(R.id.x6);
        table_x7 = findViewById(R.id.x7);
        table_x8 = findViewById(R.id.x8);
        table_x9 = findViewById(R.id.x9);

        imageView_x1 = findViewById(R.id.imageView_x1);
        imageView_x2 = findViewById(R.id.imageView_x2);
        imageView_x3 = findViewById(R.id.imageView_x3);
        imageView_x4 = findViewById(R.id.imageView_x4);
        imageView_x5 = findViewById(R.id.imageView_x5);
        imageView_x6 = findViewById(R.id.imageView_x6);
        imageView_x7 = findViewById(R.id.imageView_x7);
        imageView_x8 = findViewById(R.id.imageView_x8);
        imageView_x9 = findViewById(R.id.imageView_x9);

        teachLevelHash.put(1, getTeachLevelChallenge(1));
        teachLevelHash.put(2, getTeachLevelChallenge(2));
        teachLevelHash.put(3, getTeachLevelChallenge(3));
        teachLevelHash.put(4, getTeachLevelChallenge(4));
        teachLevelHash.put(5, getTeachLevelChallenge(5));
        teachLevelHash.put(6, getTeachLevelChallenge(6));
        teachLevelHash.put(7, getTeachLevelChallenge(7));
        teachLevelHash.put(8, getTeachLevelChallenge(8));
        teachLevelHash.put(9, getTeachLevelChallenge(9));

        Log.d(TAG_TEACH_LEVEL, MyAbstractClass.teachLevelHash.toString());

    }

    public void menuTeach(View view){
        switch (view.getId()){
            case R.id.buttonBack:
                Intent intentBack = new Intent(this, MainActivity.class);
                startActivity(intentBack);
                break;
            case R.id.buttonVoice:
                // воспроизведение голоса
                Toast.makeText(this, "Воспроизведение голоса в разработке", Toast.LENGTH_LONG).show();
                break;
            case R.id.buttonNext:
                if (choiceTable != 0) {
                    switch (getTeachLevelChallenge(choiceTable)){
                        case (0):
                            intentNext = new Intent(this, ChoiceActivity.class);
                            startActivity(intentNext);
                            break;
                        case (1):
                            // в активити ввода
                            Toast.makeText(this, "Эта страница в разработке", Toast.LENGTH_SHORT).show();
                            intentNext = new Intent(this, InputActivity.class);
                            startActivity(intentNext);
                            break;
                        case (2):
                            // в активити на слух
                            Toast.makeText(this, "3 LEVEL", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            }
    }

    public void tableChoice(View view){
        switch (view.getId()){
            case R.id.x1:
                choiceTable = 1;
                table_x1.setVisibility(View.INVISIBLE);
                imageView_x1.setVisibility(View.VISIBLE);
                table_x2.setClickable(false);
                table_x3.setClickable(false);
                table_x4.setClickable(false);
                table_x5.setClickable(false);
                table_x6.setClickable(false);
                table_x7.setClickable(false);
                table_x8.setClickable(false);
                table_x9.setClickable(false);
                imageView_x1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageView_x1.setVisibility(View.GONE);
                        table_x1.setVisibility(View.VISIBLE);
                        table_x2.setClickable(true);
                        table_x3.setClickable(true);
                        table_x4.setClickable(true);
                        table_x5.setClickable(true);
                        table_x6.setClickable(true);
                        table_x7.setClickable(true);
                        table_x8.setClickable(true);
                        table_x9.setClickable(true);
                        choiceTable = 0;
                    }
                });
            break;

            case R.id.x2:
                choiceTable = 2;
                table_x2.setVisibility(View.INVISIBLE);
                imageView_x2.setVisibility(View.VISIBLE);
                table_x1.setClickable(false);
                table_x3.setClickable(false);
                table_x4.setClickable(false);
                table_x5.setClickable(false);
                table_x6.setClickable(false);
                table_x7.setClickable(false);
                table_x8.setClickable(false);
                table_x9.setClickable(false);
                imageView_x2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageView_x2.setVisibility(View.GONE);
                        table_x2.setVisibility(View.VISIBLE);
                        table_x1.setClickable(true);
                        table_x3.setClickable(true);
                        table_x4.setClickable(true);
                        table_x5.setClickable(true);
                        table_x6.setClickable(true);
                        table_x7.setClickable(true);
                        table_x8.setClickable(true);
                        table_x9.setClickable(true);
                        choiceTable = 0;
                    }
                });
                break;

            case R.id.x3:
                choiceTable = 3;
                table_x3.setVisibility(View.INVISIBLE);
                imageView_x3.setVisibility(View.VISIBLE);
                table_x1.setClickable(false);
                table_x2.setClickable(false);
                table_x4.setClickable(false);
                table_x5.setClickable(false);
                table_x6.setClickable(false);
                table_x7.setClickable(false);
                table_x8.setClickable(false);
                table_x9.setClickable(false);
                imageView_x3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageView_x3.setVisibility(View.GONE);
                        table_x3.setVisibility(View.VISIBLE);
                        table_x1.setClickable(true);
                        table_x2.setClickable(true);
                        table_x4.setClickable(true);
                        table_x5.setClickable(true);
                        table_x6.setClickable(true);
                        table_x7.setClickable(true);
                        table_x8.setClickable(true);
                        table_x9.setClickable(true);
                        choiceTable = 0;
                    }
                });
                break;

            case R.id.x4:
                choiceTable = 4;
                table_x4.setVisibility(View.INVISIBLE);
                imageView_x4.setVisibility(View.VISIBLE);
                table_x1.setClickable(false);
                table_x2.setClickable(false);
                table_x3.setClickable(false);
                table_x5.setClickable(false);
                table_x6.setClickable(false);
                table_x7.setClickable(false);
                table_x8.setClickable(false);
                table_x9.setClickable(false);
                imageView_x4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageView_x4.setVisibility(View.GONE);
                        table_x4.setVisibility(View.VISIBLE);
                        table_x1.setClickable(true);
                        table_x2.setClickable(true);
                        table_x3.setClickable(true);
                        table_x5.setClickable(true);
                        table_x6.setClickable(true);
                        table_x7.setClickable(true);
                        table_x8.setClickable(true);
                        table_x9.setClickable(true);
                        choiceTable = 0;
                    }
                });
                break;

            case R.id.x5:
                choiceTable = 5;
                table_x5.setVisibility(View.INVISIBLE);
                imageView_x5.setVisibility(View.VISIBLE);
                table_x1.setClickable(false);
                table_x2.setClickable(false);
                table_x3.setClickable(false);
                table_x4.setClickable(false);
                table_x6.setClickable(false);
                table_x7.setClickable(false);
                table_x8.setClickable(false);
                table_x9.setClickable(false);
                imageView_x5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageView_x5.setVisibility(View.GONE);
                        table_x5.setVisibility(View.VISIBLE);
                        table_x1.setClickable(true);
                        table_x2.setClickable(true);
                        table_x3.setClickable(true);
                        table_x4.setClickable(true);
                        table_x6.setClickable(true);
                        table_x7.setClickable(true);
                        table_x8.setClickable(true);
                        table_x9.setClickable(true);
                        choiceTable = 0;
                    }
                });
                break;

            case R.id.x6:
                choiceTable = 6;
                table_x6.setVisibility(View.INVISIBLE);
                imageView_x6.setVisibility(View.VISIBLE);
                table_x1.setClickable(false);
                table_x2.setClickable(false);
                table_x3.setClickable(false);
                table_x4.setClickable(false);
                table_x5.setClickable(false);
                table_x7.setClickable(false);
                table_x8.setClickable(false);
                table_x9.setClickable(false);
                imageView_x6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageView_x6.setVisibility(View.GONE);
                        table_x6.setVisibility(View.VISIBLE);
                        table_x1.setClickable(true);
                        table_x2.setClickable(true);
                        table_x3.setClickable(true);
                        table_x4.setClickable(true);
                        table_x5.setClickable(true);
                        table_x7.setClickable(true);
                        table_x8.setClickable(true);
                        table_x9.setClickable(true);
                        choiceTable = 0;
                    }
                });

                break;

            case R.id.x7:
                choiceTable = 7;
                table_x7.setVisibility(View.INVISIBLE);
                imageView_x7.setVisibility(View.VISIBLE);
                table_x1.setClickable(false);
                table_x2.setClickable(false);
                table_x3.setClickable(false);
                table_x4.setClickable(false);
                table_x5.setClickable(false);
                table_x6.setClickable(false);
                table_x8.setClickable(false);
                table_x9.setClickable(false);
                imageView_x7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageView_x7.setVisibility(View.GONE);
                        table_x7.setVisibility(View.VISIBLE);
                        table_x1.setClickable(true);
                        table_x2.setClickable(true);
                        table_x3.setClickable(true);
                        table_x4.setClickable(true);
                        table_x5.setClickable(true);
                        table_x6.setClickable(true);
                        table_x8.setClickable(true);
                        table_x9.setClickable(true);
                        choiceTable = 0;
                    }
                });
                break;

            case R.id.x8:
                choiceTable = 8;
                table_x8.setVisibility(View.INVISIBLE);
                imageView_x8.setVisibility(View.VISIBLE);
                table_x1.setClickable(false);
                table_x2.setClickable(false);
                table_x3.setClickable(false);
                table_x4.setClickable(false);
                table_x5.setClickable(false);
                table_x6.setClickable(false);
                table_x7.setClickable(false);
                table_x9.setClickable(false);
                imageView_x8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageView_x8.setVisibility(View.GONE);
                        table_x8.setVisibility(View.VISIBLE);
                        table_x1.setClickable(true);
                        table_x2.setClickable(true);
                        table_x3.setClickable(true);
                        table_x4.setClickable(true);
                        table_x5.setClickable(true);
                        table_x6.setClickable(true);
                        table_x7.setClickable(true);
                        table_x9.setClickable(true);
                        choiceTable = 0;
                    }
                });
                break;

            case R.id.x9:
                choiceTable = 9;
                table_x9.setVisibility(View.INVISIBLE);
                imageView_x9.setVisibility(View.VISIBLE);
                table_x1.setClickable(false);
                table_x2.setClickable(false);
                table_x3.setClickable(false);
                table_x4.setClickable(false);
                table_x5.setClickable(false);
                table_x6.setClickable(false);
                table_x7.setClickable(false);
                table_x8.setClickable(false);
                imageView_x9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageView_x9.setVisibility(View.GONE);
                        table_x9.setVisibility(View.VISIBLE);
                        table_x1.setClickable(true);
                        table_x2.setClickable(true);
                        table_x3.setClickable(true);
                        table_x4.setClickable(true);
                        table_x5.setClickable(true);
                        table_x6.setClickable(true);
                        table_x7.setClickable(true);
                        table_x8.setClickable(true);
                        choiceTable = 0;
                    }
                });
                break;
        }
    }

    public void setReset(View view){
        editorTeach = preferencesTeach.edit();
        editorTeach.putInt(TEACH_LEVEL_CHALLENGE_1, 1);
        editorTeach.apply();

    }
}