package com.example.tableapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Interim1 extends MyAbstractClass {

    Button button_continue;
    int i;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "Сработал метод onCreate Interim1");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interim1);
        preferences = getSharedPreferences(APP_LEVEL, Context.MODE_PRIVATE);
        preferencesTeach = getSharedPreferences(TEACH_LEVEL, Context.MODE_PRIVATE);
        button_continue = findViewById(R.id.button_continue);

        // если неверных ответов не было, переходим к следующему уровню
        if(incorrectMapQuestion.isEmpty() & getAppLevelChallenge() < 2 ) {
                setAppLevelChallenge(getAppLevelChallenge() + 1);
                i = 1;

            }else if(incorrectMapQuestion.isEmpty() & getAppLevelChallenge() == 2){
                i = 2;
                setAppLevelChallenge(0);
                setTeachLevelChallenge(choiceTable);

            }else if(!incorrectMapQuestion.isEmpty()){
                i = 3;
        }

        switch (getTeachLevelChallenge(choiceTable)){
            case (0):
                intent = new Intent(this, ChoiceActivity.class);
                break;
            case (1):
                intent = new Intent(this, InputActivity.class);
                break;
            case (2):
                Toast.makeText(this, "3 LEVEL", Toast.LENGTH_SHORT).show();
        }

    }
    // обработчик нажатия кнопки продолжить
    public void nextActivity(View view){
        // переход на следующую активити
        if(i == 1 || i == 3){
            startActivity(intent);
        }else if(i == 2){
            Intent intent = new Intent(this, TeachActivity.class);
            startActivity(intent);
        }
        /*if(getTeachLevelChallenge(choiceTable) <= 2) {
            Intent intent = new Intent(this, ChoiceActivity.class);
            startActivity(intent);
        }else {
            Intent intent = new Intent(this, TeachActivity.class);
            startActivity(intent);
        }*/

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, TeachActivity.class);
        startActivity(intent);
    }
}
