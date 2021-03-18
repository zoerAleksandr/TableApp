package com.example.tableapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.Timer;

import static com.example.tableapp.InputActivity.elementary;

public class MyAbstractClass extends AppCompatActivity {
    // из TeachActivity
    public static final String APP_LEVEL = "myLevel";
    public static final String APP_LEVEL_CHALLENGE = "levelChallenge";
    public static final String TAG = "myLogs";
    public static final String TAG_TEACH_LEVEL = "myLevel";
    CountDownTimer timer;

    public static int choiceTable; // переменная != 0 если выбрана таблица для изучения

    public static final String TEACH_LEVEL = "myTeachLevel";
    public static final String TEACH_LEVEL_CHALLENGE_1 = "TeachLevel_1";
    public static final String TEACH_LEVEL_CHALLENGE_2 = "TeachLevel_2";
    public static final String TEACH_LEVEL_CHALLENGE_3 = "TeachLevel_3";
    public static final String TEACH_LEVEL_CHALLENGE_4 = "TeachLevel_4";
    public static final String TEACH_LEVEL_CHALLENGE_5 = "TeachLevel_5";
    public static final String TEACH_LEVEL_CHALLENGE_6 = "TeachLevel_6";
    public static final String TEACH_LEVEL_CHALLENGE_7 = "TeachLevel_7";
    public static final String TEACH_LEVEL_CHALLENGE_8 = "TeachLevel_8";
    public static final String TEACH_LEVEL_CHALLENGE_9 = "TeachLevel_9";

    public static ArrayList<Integer> incorrectListQuestion = new ArrayList<>(); // неверные вопросы
    public static ArrayList<Integer> incorrectListAnswer = new ArrayList<>(); // неверные ответы

    public static HashMap<Integer, String> incorrectMapQuestion = new HashMap<>(); // неверные ответы

    public static SharedPreferences preferences;
    public static SharedPreferences preferencesTeach;

    public static SharedPreferences.Editor editor, editorTeach;

    static int appLevel; // уровень сложности

    public static int teachLevel; // для установки достигнутого уровня

    // для получения текущего APP_LEVEL_CHALLENGE
    public static int getAppLevelChallenge() {
        if (preferences.contains(APP_LEVEL_CHALLENGE)) {
            appLevel = preferences.getInt(APP_LEVEL_CHALLENGE, 0);
            Log.d(TAG, "Уровень равен - " + appLevel);
        }
        return appLevel;
    }

    // для записи APP_LEVEL_CHALLENGE
    public static void setAppLevelChallenge(int i) {
        editor = preferences.edit();
        editor.putInt(APP_LEVEL_CHALLENGE, i);
        editor.apply();
    }

    // для получения текущего TEACH_LEVEL_CHALLENGE для определенной таблицы
    public static int getTeachLevelChallenge(int i) {
        switch (i) {
            case (1):
                if (preferencesTeach.contains(TEACH_LEVEL_CHALLENGE_1)) {
                    teachLevel = preferencesTeach.getInt(TEACH_LEVEL_CHALLENGE_1, 0);
                    Log.d(TAG, "TEACH_LEVEL_CHALLENGE_1 равен - " + teachLevel);
                }
                break;
            case (2):
                if (preferencesTeach.contains(TEACH_LEVEL_CHALLENGE_2)) {
                    teachLevel = preferencesTeach.getInt(TEACH_LEVEL_CHALLENGE_2, 0);
                    Log.d(TAG, "TEACH_LEVEL_CHALLENGE_2 равен - " + teachLevel);
                }
                break;
            case (3):
                if (preferencesTeach.contains(TEACH_LEVEL_CHALLENGE_3)) {
                    teachLevel = preferencesTeach.getInt(TEACH_LEVEL_CHALLENGE_3, 0);
                    Log.d(TAG, "TEACH_LEVEL_CHALLENGE_3 равен - " + teachLevel);
                }
                break;
            case (4):
                if (preferencesTeach.contains(TEACH_LEVEL_CHALLENGE_4)) {
                    teachLevel = preferencesTeach.getInt(TEACH_LEVEL_CHALLENGE_4, 0);
                    Log.d(TAG, "TEACH_LEVEL_CHALLENGE_4 равен - " + teachLevel);
                }
                break;
            case (5):
                if (preferencesTeach.contains(TEACH_LEVEL_CHALLENGE_5)) {
                    teachLevel = preferencesTeach.getInt(TEACH_LEVEL_CHALLENGE_5, 0);
                    Log.d(TAG, "TEACH_LEVEL_CHALLENGE_5 равен - " + teachLevel);
                }
                break;
            case (6):
                if (preferencesTeach.contains(TEACH_LEVEL_CHALLENGE_6)) {
                    teachLevel = preferencesTeach.getInt(TEACH_LEVEL_CHALLENGE_6, 0);
                    Log.d(TAG, "TEACH_LEVEL_CHALLENGE_6 равен - " + teachLevel);
                }
                break;
            case (7):
                if (preferencesTeach.contains(TEACH_LEVEL_CHALLENGE_7)) {
                    teachLevel = preferencesTeach.getInt(TEACH_LEVEL_CHALLENGE_7, 0);
                    Log.d(TAG, "TEACH_LEVEL_CHALLENGE_7 равен - " + teachLevel);
                }
                break;
            case (8):
                if (preferencesTeach.contains(TEACH_LEVEL_CHALLENGE_8)) {
                    teachLevel = preferencesTeach.getInt(TEACH_LEVEL_CHALLENGE_8, 0);
                    Log.d(TAG, "TEACH_LEVEL_CHALLENGE_8 равен - " + teachLevel);
                }
                break;
            case (9):
                if (preferencesTeach.contains(TEACH_LEVEL_CHALLENGE_9)) {
                    teachLevel = preferencesTeach.getInt(TEACH_LEVEL_CHALLENGE_9, 0);
                    Log.d(TAG, "TEACH_LEVEL_CHALLENGE_9 равен - " + teachLevel);
                }
                break;

        }
        return teachLevel;

    }

    // для увеличения на 1 TEACH_LEVEL_CHALLENGE
    public static void setTeachLevelChallenge(int i) {
        editorTeach = preferencesTeach.edit();
        // получаем текущий уровень
        int a = getTeachLevelChallenge(i);
        switch (i) {
            case 1:
                editorTeach.putInt(TEACH_LEVEL_CHALLENGE_1, a + 1);
                editorTeach.apply();
                break;
            case 2:
                editorTeach.putInt(TEACH_LEVEL_CHALLENGE_2, a + 1);
                editorTeach.apply();
                break;
            case 3:
                editorTeach.putInt(TEACH_LEVEL_CHALLENGE_3, a + 1);
                editorTeach.apply();
                break;
            case 4:
                editorTeach.putInt(TEACH_LEVEL_CHALLENGE_4, a + 1);
                editorTeach.apply();
                break;
            case 5:
                editorTeach.putInt(TEACH_LEVEL_CHALLENGE_5, a + 1);
                editorTeach.apply();
                break;
            case 6:
                editorTeach.putInt(TEACH_LEVEL_CHALLENGE_6, a + 1);
                editorTeach.apply();
                break;
            case 7:
                editorTeach.putInt(TEACH_LEVEL_CHALLENGE_7, a + 1);
                editorTeach.apply();
                break;
            case 8:
                editorTeach.putInt(TEACH_LEVEL_CHALLENGE_8, a + 1);
                editorTeach.apply();
                break;
            case 9:
                editorTeach.putInt(TEACH_LEVEL_CHALLENGE_9, a + 1);
                editorTeach.apply();
                break;

        }
    }


    // для InputActivity
    public static HashMap<Integer, Integer> teachLevelHash = new HashMap<>();
    Set<Integer> keySet;
    ArrayList<Integer> keyArray;


}

