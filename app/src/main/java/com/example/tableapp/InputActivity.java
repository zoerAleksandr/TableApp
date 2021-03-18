package com.example.tableapp;

import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class InputActivity extends MyAbstractClass {

    Button button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8, button_9, button_0, btn_back, btn_enter;
    TextView textView;
    ConstraintLayout background;
    ProgressBar progressBar;
    String stringInput = "";
    String s = "";
    String result = s + stringInput;
    public static int elementary; // шаг правильных ответов
    int i; // правильный ответ
    HashMap<Integer, String> exampleHash;
    String test;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        incorrectMapQuestion.clear();
        Intent intent = new Intent(this, TeachActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        timerStop();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        Log.d(TAG_TEACH_LEVEL, "Запущен метод onCreate / Уровень = " + getAppLevelChallenge());

        button_1 = findViewById(R.id.input1);
        button_2 = findViewById(R.id.input2);
        button_3 = findViewById(R.id.input3);
        button_4 = findViewById(R.id.input4);
        button_5 = findViewById(R.id.input5);
        button_6 = findViewById(R.id.input6);
        button_7 = findViewById(R.id.input7);
        button_8 = findViewById(R.id.input8);
        button_9 = findViewById(R.id.input9);
        button_0 = findViewById(R.id.input0);
        btn_enter = findViewById(R.id.button_enter);
        btn_back = findViewById(R.id.button_back);
        progressBar = findViewById(R.id.progressBar_input);
        textView = findViewById(R.id.textView);
        exampleHash = new HashMap<>();
        background = findViewById(R.id.background_input);

// ТЕСТ
        if(incorrectMapQuestion.isEmpty()){
            Log.d(TAG_TEACH_LEVEL, "Запущен метод onCreate / ТЕСТ");
            test = "test";
            i = choiceTable;
            elementary = i;
            switch (choiceTable){
                case 1:
                    exampleHash.put(1, "1 * 1 = ");
                    exampleHash.put(2, "1 * 2 = ");
                    exampleHash.put(3, "1 * 3 = ");
                    exampleHash.put(4, "1 * 4 = ");
                    exampleHash.put(5, "1 * 5 = ");
                    exampleHash.put(6, "1 * 6 = ");
                    exampleHash.put(7, "1 * 7 = ");
                    exampleHash.put(8, "1 * 8 = ");
                    exampleHash.put(9, "1 * 9 = ");
                    exampleHash.put(10, "1 * 10 = ");
                    break;
                case 2:
                    exampleHash.put(2, "2 * 1 = ");
                    exampleHash.put(4, "2 * 2 = ");
                    exampleHash.put(6, "2 * 3 = ");
                    exampleHash.put(8, "2 * 4 = ");
                    exampleHash.put(10, "2 * 5 = ");
                    exampleHash.put(12, "2 * 6 = ");
                    exampleHash.put(14, "2 * 7 = ");
                    exampleHash.put(16, "2 * 8 = ");
                    exampleHash.put(18, "2 * 9 = ");
                    exampleHash.put(20, "2 * 10 = ");
                    break;
                case 3:
                    exampleHash.put(3, "3 * 1 = ");
                    exampleHash.put(6, "3 * 2 = ");
                    exampleHash.put(9, "3 * 3 = ");
                    exampleHash.put(12, "3 * 4 = ");
                    exampleHash.put(15, "3 * 5 = ");
                    exampleHash.put(18, "3 * 6 = ");
                    exampleHash.put(21, "3 * 7 = ");
                    exampleHash.put(24, "3 * 8 = ");
                    exampleHash.put(27, "3 * 9 = ");
                    exampleHash.put(30, "3 * 10 = ");
                    break;
                case 4:
                    exampleHash.put(4, "4 * 1 = ");
                    exampleHash.put(8, "4 * 2 = ");
                    exampleHash.put(12, "4 * 3 = ");
                    exampleHash.put(16, "4 * 4 = ");
                    exampleHash.put(20, "4 * 5 = ");
                    exampleHash.put(24, "4 * 6 = ");
                    exampleHash.put(28, "4 * 7 = ");
                    exampleHash.put(32, "4 * 8 = ");
                    exampleHash.put(36, "4 * 9 = ");
                    exampleHash.put(40, "4 * 10 = ");
                    break;
                case 5:
                    exampleHash.put(5, "5 * 1 = ");
                    exampleHash.put(10, "5 * 2 = ");
                    exampleHash.put(15, "5 * 3 = ");
                    exampleHash.put(20, "5 * 4 = ");
                    exampleHash.put(25, "5 * 5 = ");
                    exampleHash.put(30, "5 * 6 = ");
                    exampleHash.put(35, "5 * 7 = ");
                    exampleHash.put(40, "5 * 8 = ");
                    exampleHash.put(45, "5 * 9 = ");
                    exampleHash.put(50, "5 * 10 = ");
                    break;
                case 6:
                    exampleHash.put(6, "6 * 1 = ");
                    exampleHash.put(12, "6 * 2 = ");
                    exampleHash.put(18, "6 * 3 = ");
                    exampleHash.put(24, "6 * 4 = ");
                    exampleHash.put(30, "6 * 5 = ");
                    exampleHash.put(36, "6 * 6 = ");
                    exampleHash.put(42, "6 * 7 = ");
                    exampleHash.put(48, "6 * 8 = ");
                    exampleHash.put(54, "6 * 9 = ");
                    exampleHash.put(60, "6 * 10 = ");
                    break;
                case 7:
                    exampleHash.put(7, "7 * 1 = ");
                    exampleHash.put(14, "7 * 2 = ");
                    exampleHash.put(21, "7 * 3 = ");
                    exampleHash.put(28, "7 * 4 = ");
                    exampleHash.put(35, "7 * 5 = ");
                    exampleHash.put(42, "7 * 6 = ");
                    exampleHash.put(49, "7 * 7 = ");
                    exampleHash.put(56, "7 * 8 = ");
                    exampleHash.put(63, "7 * 9 = ");
                    exampleHash.put(70, "7 * 10 = ");
                    break;
                case 8:
                    exampleHash.put(8, "8 * 1 = ");
                    exampleHash.put(16, "8 * 2 = ");
                    exampleHash.put(24, "8 * 3 = ");
                    exampleHash.put(32, "8 * 4 = ");
                    exampleHash.put(40, "8 * 5 = ");
                    exampleHash.put(48, "8 * 6 = ");
                    exampleHash.put(56, "8 * 7 = ");
                    exampleHash.put(64, "8 * 8 = ");
                    exampleHash.put(72, "8 * 9 = ");
                    exampleHash.put(80, "8 * 10 = ");
                    break;
                case 9:
                    exampleHash.put(9, "9 * 1 = ");
                    exampleHash.put(18, "9 * 2 = ");
                    exampleHash.put(27, "9 * 3 = ");
                    exampleHash.put(36, "9 * 4 = ");
                    exampleHash.put(45, "9 * 5 = ");
                    exampleHash.put(54, "9 * 6 = ");
                    exampleHash.put(63, "9 * 7 = ");
                    exampleHash.put(72, "9 * 8 = ");
                    exampleHash.put(81, "9 * 9 = ");
                    exampleHash.put(90, "9 * 10 = ");
                    break;
            }
            s = exampleHash.get(i);
            if(getAppLevelChallenge() > 0){
                timerStop();
                timerStart(getAppLevelChallenge(), progressBar);
            }
        }

// РНО
        else {
            Log.d(TAG_TEACH_LEVEL, "Запущен метод onCreate / РНО. Количество ошибок = " + incorrectMapQuestion.size());
            test = "rno";
            keySet = incorrectMapQuestion.keySet();
            keyArray = new ArrayList<>(keySet);
            s = incorrectMapQuestion.get(keyArray.get(0));
            i = keyArray.get(0);
        }
        textView.setText(s);
        if(getAppLevelChallenge() > 0){
            timerStop();
            timerStart(getAppLevelChallenge(), progressBar);
        }
    }

// обработчик клавишей ввода
    public void input(View view){
        switch (view.getId()){
            case (R.id.input1):
                stringInput = inputNumber(stringInput, "1");
                result = s + stringInput;
                textView.setText(result);
                break;
            case (R.id.input2):
                stringInput = inputNumber(stringInput, "2");
                result = s + stringInput;
                textView.setText(result);
                break;
            case (R.id.input3):
                stringInput = inputNumber(stringInput, "3");
                result = s + stringInput;
                textView.setText(result);
                break;
            case (R.id.input4):
                stringInput = inputNumber(stringInput, "4");
                result = s + stringInput;
                textView.setText(result);
                break;
            case (R.id.input5):
                stringInput = inputNumber(stringInput, "5");
                result = s + stringInput;
                textView.setText(result);
                break;
            case (R.id.input6):
                stringInput = inputNumber(stringInput, "6");
                result = s + stringInput;
                textView.setText(result);
                break;
            case (R.id.input7):
                stringInput = inputNumber(stringInput, "7");
                result = s + stringInput;
                textView.setText(result);
                break;
            case (R.id.input8):
                stringInput = inputNumber(stringInput, "8");
                result = s + stringInput;
                textView.setText(result);
                break;
            case (R.id.input9):
                stringInput = inputNumber(stringInput, "9");
                result = s + stringInput;
                textView.setText(result);
                break;
            case (R.id.input0):
                stringInput = inputNumber(stringInput, "0");
                result = s + stringInput;
                textView.setText(result);
                break;

        // удаление
            case (R.id.button_back):
                stringInput = delete(stringInput);
                result = s + stringInput;
                textView.setText(result);
                break;

        // ответ
            case (R.id.button_enter):
            // ТЕСТ
                if(test.equals("test")){
                // верно
                    if(stringInput.equals(Integer.toString(i))){
                        rightAnswerTest();
                        /*//меняем фон на зеленый
                        background.setBackgroundResource(R.drawable.background_input_right);

                        // меняем фон обратно на стандартный через 120 мс
                        final Handler handler = new Handler();
                        handler.postDelayed(() ->
                                background.setBackgroundResource(R.drawable.background_input_basic), 120);
                        // если вопросы закончились, переход в Interim1
                        if (elementary * 10 == i) {
                            Intent intent = new Intent(this, Interim1.class);
                            startActivity(intent);
                        }else {
                            // иначе установка следующего вопроса
                            i = i + elementary;
                            s = exampleHash.get(i);
                        }*/
                    }
                // неверно
                    else {
                        incorrectAnswerTest();
                        /*//включаем вибрацию
                        long millis = 100;
                        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                        if (vibrator.hasVibrator()) {
                            vibrator.vibrate(millis);
                        }
                        //меняем фон на красный
                        background.setBackgroundResource(R.drawable.background_input_incorrect);

                        // меняем фон обратно на стандартный через 120 мс
                        final Handler handler = new Handler();
                        handler.postDelayed(() ->
                                background.setBackgroundResource(R.drawable.background_input_basic), 120);
                        // если 2 или 3 уровень:
                        if(getAppLevelChallenge() > 0){
                            incorrectMapQuestion.put(i, exampleHash.get(i));
                            Log.d(TAG_TEACH_LEVEL, "Добавление в incorrectMapQuestion " + exampleHash.get(i));
                            // если вопросы закончились, переход в Interim1
                            if (elementary * 10 == i) {
                                Intent intent = new Intent(this, Interim1.class);
                                startActivity(intent);
                            } else {
                                // иначе установка следующего вопроса
                                i = i + elementary;
                                s = exampleHash.get(i);
                            }
                        }*/
                    }
                }

            // РНО
                else if (test.equals("rno")){
                // верно
                    if(stringInput.equals(Integer.toString(i))){
                        rightAnswerRNO();
                        /*//меняем фон на зеленый
                        background.setBackgroundResource(R.drawable.background_input_right);

                        // меняем фон обратно на стандартный через 120 мс
                        final Handler handler = new Handler();
                        handler.postDelayed(() ->
                                background.setBackgroundResource(R.drawable.background_input_basic), 120);
                        // удаляем отвеченый вопрос
                        incorrectMapQuestion.remove(i);
                        keyArray.remove(0);
                        // если список incorrectMapQuestion пустой
                        if(incorrectMapQuestion.isEmpty()){
                            Intent intent = new Intent(this, Interim1.class);
                            startActivity(intent);
                        }
                        else {
                            i = keyArray.get(0);
                            s = incorrectMapQuestion.get(keyArray.get(0));
                        }*/
                    }
                // неверно
                    else {
                        incorrectAnswerRno();
                        /*//включаем вибрацию
                        long millis = 100;
                        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                        if (vibrator.hasVibrator()) {
                            vibrator.vibrate(millis);
                        }
                        //меняем фон на красный
                        background.setBackgroundResource(R.drawable.background_input_incorrect);

                        // меняем фон обратно на стандартный через 120 мс
                        final Handler handler = new Handler();
                        handler.postDelayed(() ->
                                background.setBackgroundResource(R.drawable.background_input_basic), 120);

                        keyArray.add(keyArray.get(0));
                        keyArray.remove(0);
                        i = keyArray.get(0);
                        s = incorrectMapQuestion.get(keyArray.get(0));*/
                    }
                }

                stringInput = "";
                textView.setText(s);
                if(getAppLevelChallenge() > 0){
                    timerStop();
                    timerStart(getAppLevelChallenge(), progressBar);
                }
                break;
        }
    }

// удаление введенный данных
    public String delete (String str){
        if (str.length() != 0 )
            str = str.substring(0, str.length() - 1);
        return str;
    }

// добавление введенных данный в textView
    public String inputNumber(String str, String strNew){
        str = str + strNew;
        return str;
    }

    public void timerStart(int time, ProgressBar view){
        view.setVisibility(View.VISIBLE);
        switch (time){
            case (1):
                timer = new CountDownTimer(3100, 50) {

                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onTick(long l) {
                        view.setProgress((int) l / 30, true);
                    }

                    @Override
                    public void onFinish() {
                        Log.d(TAG_TEACH_LEVEL, "Вышло время таймера - 1");
                        if(test.equals("test")){
                            incorrectAnswerTest();
                        }else {
                            incorrectAnswerRno();
                        }
                        stringInput = "";
                        textView.setText(s);
                        timerStart(getAppLevelChallenge(), progressBar);
                    }
                }.start();
                break;
            case (2):
                timer = new CountDownTimer(1600, 50) {

                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onTick(long l) {
                        view.setProgress((int) l / 15, true);
                    }

                    @Override
                    public void onFinish() {
                        Log.d(TAG, "Вышло время таймера - 2");
                        if(test.equals("test")){
                            incorrectAnswerTest();
                        }else {
                            incorrectAnswerRno();
                        }
                        stringInput = "";
                        textView.setText(s);
                        timerStart(getAppLevelChallenge(), progressBar);
                    }
                }.start();
                break;
        }
    }

    public void timerStop(){
        if(timer != null){
            timer.cancel();
        }
    }

// РНО неверный ответ
    public void incorrectAnswerRno(){
        //включаем вибрацию
        long millis = 100;
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if (vibrator.hasVibrator()) {
            vibrator.vibrate(millis);
        }
        //меняем фон на красный
        background.setBackgroundResource(R.drawable.background_input_incorrect);

        // меняем фон обратно на стандартный через 120 мс
        final Handler handler = new Handler();
        handler.postDelayed(() ->
                background.setBackgroundResource(R.drawable.background_input_basic), 120);

        keyArray.add(keyArray.get(0));
        keyArray.remove(0);
        i = keyArray.get(0);
        s = incorrectMapQuestion.get(keyArray.get(0));
    }

// РНО верный ответ
    public  void rightAnswerRNO(){
        //меняем фон на зеленый
        background.setBackgroundResource(R.drawable.background_input_right);

        // меняем фон обратно на стандартный через 120 мс
        final Handler handler = new Handler();
        handler.postDelayed(() ->
                background.setBackgroundResource(R.drawable.background_input_basic), 120);
        // удаляем отвеченый вопрос
        incorrectMapQuestion.remove(i);
        keyArray.remove(0);
        // если список incorrectMapQuestion пустой
        if(incorrectMapQuestion.isEmpty()){
            Intent intent = new Intent(this, Interim1.class);
            startActivity(intent);
        }
        else {
            i = keyArray.get(0);
            s = incorrectMapQuestion.get(keyArray.get(0));
        }
    }

// ТЕСТ неверный ответ
    public void incorrectAnswerTest(){
        //включаем вибрацию
        long millis = 100;
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if (vibrator.hasVibrator()) {
            vibrator.vibrate(millis);
        }
        //меняем фон на красный
        background.setBackgroundResource(R.drawable.background_input_incorrect);

        // меняем фон обратно на стандартный через 120 мс
        final Handler handler = new Handler();
        handler.postDelayed(() ->
                background.setBackgroundResource(R.drawable.background_input_basic), 120);
        // если 2 или 3 уровень:
        if(getAppLevelChallenge() > 0){
            incorrectMapQuestion.put(i, exampleHash.get(i));
            Log.d(TAG_TEACH_LEVEL, "Добавление в incorrectMapQuestion " + exampleHash.get(i));
            // если вопросы закончились, переход в Interim1
            if (elementary * 10 == i) {
                Intent intent = new Intent(this, Interim1.class);
                startActivity(intent);
            } else {
                // иначе установка следующего вопроса
                i = i + elementary;
                s = exampleHash.get(i);
            }
        }
    }

// ТЕСТ верный ответ
    public void rightAnswerTest(){
        //меняем фон на зеленый
        background.setBackgroundResource(R.drawable.background_input_right);

        // меняем фон обратно на стандартный через 120 мс
        final Handler handler = new Handler();
        handler.postDelayed(() ->
                background.setBackgroundResource(R.drawable.background_input_basic), 120);
        // если вопросы закончились, переход в Interim1
        if (elementary * 10 == i) {
            Intent intent = new Intent(this, Interim1.class);
            startActivity(intent);
        }else {
            // иначе установка следующего вопроса
            i = i + elementary;
            s = exampleHash.get(i);
        }
    }
}