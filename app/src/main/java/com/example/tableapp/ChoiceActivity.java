package com.example.tableapp;

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
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.Random;

public class ChoiceActivity extends MyAbstractClass {

    ArrayList<Integer> drawables; // примеры
    ArrayList<Integer> rights; // правильные ответы

    Button option1, option2, option3;


    ProgressBar progressBar;
    CountDownTimer timer;

    int test = 0;
    int i = 0;
    int right; // правильный ответ

    Random random = new Random();
    Button result;
    Button incorrect1;
    Button incorrect2;

    ImageView example;

    ArrayList<Button> options; // варианты ответа
    ArrayList<Integer> number; // для определения кнопки с правильным ответом
    int numb; // переменная для наполнения number
    ArrayList<Integer> number2; // для выбора неверных ответов
    int numb2; // переменная для наполнения number2

    ConstraintLayout background;
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        incorrectListQuestion.clear();
        incorrectListAnswer.clear();
        Intent intent = new Intent(this, TeachActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        getAppLevelChallenge();

    }

    @Override
    public void onStart() {
        Log.d(TAG, "Сработал метод onStart ...");
        super.onStart();

        }

    @Override
    protected void onPause() {
        super.onPause();
        timer_stop();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "Сработал метод OnCreate ...");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);



        options = new ArrayList<>(3);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        background = findViewById(R.id.linearLayout);
        example = findViewById(R.id.example);

        drawables = new ArrayList<>();
        rights = new ArrayList<>();
        // открывается нужный пример в зависимости от выбраной таблицы в TeachActivity
        if (incorrectListQuestion.isEmpty()) {
            Log.d(TAG, " Метод onCreate: Тест ...");
            switch (choiceTable) {

                case 1:
                    // примеры
                    drawables.add(0, R.drawable.e1x1);
                    drawables.add(1, R.drawable.e1x2);
                    drawables.add(2, R.drawable.e1x3);
                    drawables.add(3, R.drawable.e1x4);
                    drawables.add(4, R.drawable.e1x5);
                    drawables.add(5, R.drawable.e1x6);
                    drawables.add(6, R.drawable.e1x7);
                    drawables.add(7, R.drawable.e1x8);
                    drawables.add(8, R.drawable.e1x9);
                    drawables.add(9, R.drawable.e1x10);

                    // правильные ответы
                    rights.add(0, 1);
                    rights.add(1, 2);
                    rights.add(2, 3);
                    rights.add(3, 4);
                    rights.add(4, 5);
                    rights.add(5, 6);
                    rights.add(6, 7);
                    rights.add(7, 8);
                    rights.add(8, 9);
                    rights.add(9, 10);

                    setting_image(drawables, rights);
                    setting_the_value_button();
                    break;

                case 2:
                    drawables.add(0, R.drawable.e2x1); // примеры
                    drawables.add(1, R.drawable.e2x2);
                    drawables.add(2, R.drawable.e2x3);
                    drawables.add(3, R.drawable.e2x4);
                    drawables.add(4, R.drawable.e2x5);
                    drawables.add(5, R.drawable.e2x6);
                    drawables.add(6, R.drawable.e2x7);
                    drawables.add(7, R.drawable.e2x8);
                    drawables.add(8, R.drawable.e2x9);
                    drawables.add(9, R.drawable.e2x10);

                    // правильные ответы
                    rights.add(0, 2);
                    rights.add(1, 4);
                    rights.add(2, 6);
                    rights.add(3, 8);
                    rights.add(4, 10);
                    rights.add(5, 12);
                    rights.add(6, 14);
                    rights.add(7, 16);
                    rights.add(8, 18);
                    rights.add(9, 20);

                    setting_image(drawables, rights);
                    setting_the_value_button();
                    break;
                case 3:
                    drawables.add(0, R.drawable.e3x1); // примеры
                    drawables.add(1, R.drawable.e3x2);
                    drawables.add(2, R.drawable.e3x3);
                    drawables.add(3, R.drawable.e3x4);
                    drawables.add(4, R.drawable.e3x5);
                    drawables.add(5, R.drawable.e3x6);
                    drawables.add(6, R.drawable.e3x7);
                    drawables.add(7, R.drawable.e3x8);
                    drawables.add(8, R.drawable.e3x9);
                    drawables.add(9, R.drawable.e3z10);

                    // правильные ответы
                    rights.add(0, 3);
                    rights.add(1, 6);
                    rights.add(2, 9);
                    rights.add(3, 12);
                    rights.add(4, 15);
                    rights.add(5, 18);
                    rights.add(6, 21);
                    rights.add(7, 24);
                    rights.add(8, 27);
                    rights.add(9, 30);

                    setting_image(drawables, rights);
                    setting_the_value_button();
                    break;
                case 4:
                    drawables.add(0, R.drawable.e4x1); // примеры
                    drawables.add(1, R.drawable.e4x2);
                    drawables.add(2, R.drawable.e4x3);
                    drawables.add(3, R.drawable.e4x4);
                    drawables.add(4, R.drawable.e4x5);
                    drawables.add(5, R.drawable.e4x6);
                    drawables.add(6, R.drawable.e4x7);
                    drawables.add(7, R.drawable.e4x8);
                    drawables.add(8, R.drawable.e4x9);
                    drawables.add(9, R.drawable.e4x10);

                    // правильные ответы
                    rights.add(0, 4);
                    rights.add(1, 8);
                    rights.add(2, 12);
                    rights.add(3, 16);
                    rights.add(4, 20);
                    rights.add(5, 24);
                    rights.add(6, 28);
                    rights.add(7, 32);
                    rights.add(8, 36);
                    rights.add(9, 40);

                    setting_image(drawables, rights);
                    setting_the_value_button();
                    break;
                case 5:
                    drawables.add(0, R.drawable.e5x1); // примеры
                    drawables.add(1, R.drawable.e5x2);
                    drawables.add(2, R.drawable.e5x3);
                    drawables.add(3, R.drawable.e5x4);
                    drawables.add(4, R.drawable.e5x5);
                    drawables.add(5, R.drawable.e5x6);
                    drawables.add(6, R.drawable.e5x7);
                    drawables.add(7, R.drawable.e5x8);
                    drawables.add(8, R.drawable.e5x9);
                    drawables.add(9, R.drawable.e5x10);

                    // правильные ответы
                    rights.add(0, 5);
                    rights.add(1, 10);
                    rights.add(2, 15);
                    rights.add(3, 20);
                    rights.add(4, 25);
                    rights.add(5, 30);
                    rights.add(6, 35);
                    rights.add(7, 40);
                    rights.add(8, 45);
                    rights.add(9, 50);

                    setting_image(drawables, rights);
                    setting_the_value_button();
                    break;
                case 6:
                    drawables.add(0, R.drawable.e6x1); // примеры
                    drawables.add(1, R.drawable.e6x2);
                    drawables.add(2, R.drawable.e6x3);
                    drawables.add(3, R.drawable.e6x4);
                    drawables.add(4, R.drawable.e6x5);
                    drawables.add(5, R.drawable.e6x6);
                    drawables.add(6, R.drawable.e6x7);
                    drawables.add(7, R.drawable.e6x8);
                    drawables.add(8, R.drawable.e6x9);
                    drawables.add(9, R.drawable.e6x10);

                    // правильные ответы
                    rights.add(0, 6);
                    rights.add(1, 12);
                    rights.add(2, 18);
                    rights.add(3, 24);
                    rights.add(4, 30);
                    rights.add(5, 36);
                    rights.add(6, 42);
                    rights.add(7, 48);
                    rights.add(8, 54);
                    rights.add(9, 60);

                    setting_image(drawables, rights);
                    setting_the_value_button();

                    break;
                case 7:
                    drawables.add(0, R.drawable.e7x1); // примеры
                    drawables.add(1, R.drawable.e7x2);
                    drawables.add(2, R.drawable.e7x3);
                    drawables.add(3, R.drawable.e7x4);
                    drawables.add(4, R.drawable.e7x5);
                    drawables.add(5, R.drawable.e7x6);
                    drawables.add(6, R.drawable.e7x7);
                    drawables.add(7, R.drawable.e7x8);
                    drawables.add(8, R.drawable.e7x9);
                    drawables.add(9, R.drawable.e7x10);

                    // правильные ответы
                    rights.add(0, 7);
                    rights.add(1, 14);
                    rights.add(2, 21);
                    rights.add(3, 28);
                    rights.add(4, 35);
                    rights.add(5, 42);
                    rights.add(6, 49);
                    rights.add(7, 56);
                    rights.add(8, 63);
                    rights.add(9, 70);

                    setting_image(drawables, rights);
                    setting_the_value_button();

                    break;
                case 8:
                    // примеры
                    drawables.add(0, R.drawable.e8x1);
                    drawables.add(1, R.drawable.e8x2);
                    drawables.add(2, R.drawable.e8x3);
                    drawables.add(3, R.drawable.e8x4);
                    drawables.add(4, R.drawable.e8x5);
                    drawables.add(5, R.drawable.e8x6);
                    drawables.add(6, R.drawable.e8x7);
                    drawables.add(7, R.drawable.e8x8);
                    drawables.add(8, R.drawable.e8x9);
                    drawables.add(9, R.drawable.e8x10);

                    // правильные ответы
                    rights.add(0, 8);
                    rights.add(1, 16);
                    rights.add(2, 24);
                    rights.add(3, 32);
                    rights.add(4, 40);
                    rights.add(5, 48);
                    rights.add(6, 56);
                    rights.add(7, 64);
                    rights.add(8, 72);
                    rights.add(9, 80);

                    setting_image(drawables, rights);
                    setting_the_value_button();

                    break;
                case 9:
                    drawables.add(0, R.drawable.e9x1); // примеры
                    drawables.add(1, R.drawable.e9x2);
                    drawables.add(2, R.drawable.e9x3);
                    drawables.add(3, R.drawable.e9x4);
                    drawables.add(4, R.drawable.e9x5);
                    drawables.add(5, R.drawable.e9x6);
                    drawables.add(6, R.drawable.e9x7);
                    drawables.add(7, R.drawable.e9x8);
                    drawables.add(8, R.drawable.e9x9);
                    drawables.add(9, R.drawable.e9x10);

                    // правильные ответы
                    rights.add(0, 9);
                    rights.add(1, 18);
                    rights.add(2, 27);
                    rights.add(3, 36);
                    rights.add(4, 45);
                    rights.add(5, 54);
                    rights.add(6, 63);
                    rights.add(7, 72);
                    rights.add(8, 81);
                    rights.add(9, 90);

                    setting_image(drawables, rights);
                    setting_the_value_button();

                    break;

                // В default прописать какой пример открыть если в предыдущем Activity не выбрано
            }}
        else {
            Log.d(TAG, " Метод onCreate: РНО ...");
            test = 1;
            setting_image(incorrectListQuestion, incorrectListAnswer);
            setting_the_value_button();
        }

    }

    // установка Image и правильного ответа
    public void setting_image(ArrayList<Integer> arrayListQuestion, ArrayList<Integer> arrayListAnswer){
            Log.d(TAG, " Метод setting_image: установка изображения вопроса и назначение правильного ответа ...");
            example.setImageResource(arrayListQuestion.get(0));
            right = arrayListAnswer.get(0);
            timer_start(getAppLevelChallenge());

    }

    // запуск таймера
    public void timer_start(int i) {
        Log.d(TAG, "Сработал метод timer_start");
        switch (i) {
            case (1):
                Log.d(TAG, "Запущен таймер - 1");
                progressBar = findViewById(R.id.progressBar);
                progressBar.setVisibility(View.VISIBLE);
                timer = new CountDownTimer(3100, 50) {

                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onTick(long l) {
                        progressBar.setProgress((int) l / 30, true);
                    }

                    @Override
                    public void onFinish() {
                        Log.d(TAG, "Вышло время таймера - 1");
                        if(test == 1) {
                            incorrect_click(incorrectListQuestion);
                        }else{
                            incorrect_click(drawables);
                        }
                    }
                }.start();
                break;

            case (2):
                Log.d(TAG, "Запущен таймер - 2");
                progressBar = findViewById(R.id.progressBar);
                progressBar.setVisibility(View.VISIBLE);
                timer = new CountDownTimer(1600, 50) {

                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onTick(long l) {
                        progressBar.setProgress((int) l / 15, true);
                    }

                    @Override
                    public void onFinish() {
                        Log.d(TAG, "Вышло время таймера - 2");
                        if(test == 1) {
                            incorrect_click(incorrectListQuestion);
                        }else{
                            incorrect_click(drawables);
                        }
                    }
                }.start();
                break;
        }
    }

    //остановка таймера
    public void timer_stop(){
        Log.d(TAG, "Сработал метод timer_stop");
        if (timer != null) {
            timer.cancel();
            Log.d(TAG, "таймер остановлен");
        }
    }

    // установка значения кнопок
    public void setting_the_value_button() {
        Log.d(TAG, "Устонавливаем значения для кнопок");
    // варианты ответа
        options.add(0, option1);
        options.add(1, option2);
        options.add(2, option3);

    // определяем какая кнопка будет с правильным ответом, а какие с неверным
        number = new ArrayList<>();
        while (number.size() != 3) {
            numb = random.nextInt(3);
            if (!number.contains(numb)) {
                number.add(numb);
            }
        }
        result = options.get(number.get(0));
        incorrect1 = options.get(number.get(1));
        incorrect2 = options.get(number.get(2));

// присваиваем этим кнопкам необходимые значения

        result.setText(Integer.toString(right)); // правильный ответ

        number2 = new ArrayList<>();
        while (number2.size() != 2) {
            int a;
            int b;
            if (right <= 5){
                a = 1;
            }else {
                a = right - 5;
            }
            b = right + 5;
            numb2 = a + random.nextInt(b - a + 1);
            if (numb2 != right && !number2.contains(numb2)) {
                number2.add(numb2);
            }
        }
        incorrect1.setText(Integer.toString(number2.get(0)));
        incorrect2.setText(Integer.toString(number2.get(1)));

    }

    // обработка нажатий вариантов ответа
    public void click_on_option(View view) {
        Log.d(TAG, "Сработал обработчик нажатия кнопок");
        // получаем текст из нажатой кнопки
        Button button = (Button) view;
        int buttonText = Integer.parseInt(button.getText().toString());
        // Если строка на нажатой кнопке соответствует текущему правильному ответу -> try
        if (buttonText == right) {
            Log.d(TAG, "Ответ верный");
            if(rights.contains(right)){
                right_click(drawables, rights);
                }else {
                    right_click(incorrectListQuestion, incorrectListAnswer);
            }
        } else {
            Log.d(TAG, "Ответ неверный");
            if(rights.contains(right)){
                incorrect_click(drawables);
                }else {
                    incorrect_click(incorrectListQuestion);
            }
        }
    }

    // обработка правильного ответа
    public void right_click(ArrayList<Integer> arrayListQuestion, ArrayList<Integer> arrayListAnswer) {
        Log.d(TAG, "Вызов метода right_click");
        // Кратковременно меням фон на зеленый
        background.setBackgroundResource(R.drawable.right_option);
        // Меняем фон на стандартный через 120 мс
        final Handler handler = new Handler();
        handler.postDelayed(() ->
                background.setBackgroundResource(R.drawable.choice_activity), 120);
        number.clear();
        number2.clear();
        // останавливаем предыдущий таймер
        timer_stop();
        // очищаем
        arrayListQuestion.remove(0);
        arrayListAnswer.remove(0);
        // продолжаем переход на следующий пример, пока примеры не закончились
        if (!arrayListQuestion.isEmpty()) {
            Log.d(TAG, "Метод right_click: arrayListQuestion не пустой");
            // установка изображения с новым примером
            setting_image(arrayListQuestion, arrayListAnswer);
            // установка значений для неправильных ответов
            setting_the_value_button();
            // если примеры закончились, переходим на Interim1.Activity
        } else {
            Log.d(TAG, "Метод right_click: arrayListQuestion пустой");
            Intent intentInterim1 = new Intent(ChoiceActivity.this, Interim1.class);
            startActivity(intentInterim1);

        }
    }

    // обработка неверного ответа
    public void incorrect_click(ArrayList<Integer> arrayListQuestion) {
        Log.d(TAG, "Сработал метод incorrect_click");
        // останавливаем предыдущий таймер
        timer_stop();

        //включаем вибрацию
        long millis = 100;
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if (vibrator.hasVibrator()) {
            vibrator.vibrate(millis);
        }
        //меняем фон на красный
        background.setBackgroundResource(R.drawable.incorrect_option);

        // меняем фон обратно на стандартный через 120 мс
        final Handler handler = new Handler();
        handler.postDelayed(() ->
                background.setBackgroundResource(R.drawable.choice_activity), 120);


        // если это РНО
        if(arrayListQuestion.equals(incorrectListQuestion)){
            Log.d(TAG, "Метод incorrect_click: РНО");

            // в конец списка добавляем неверный ответ и удаляем текущий
            incorrectListQuestion.add(incorrectListQuestion.get(0));
            incorrectListAnswer.add(incorrectListAnswer.get(0));
            incorrectListQuestion.remove(0);
            incorrectListAnswer.remove(0);
            // устонавливаем новые значения
            setting_image(incorrectListQuestion, incorrectListAnswer);
            setting_the_value_button();
        }

        // если это Тест
        else if (arrayListQuestion.equals(drawables) && getAppLevelChallenge() > 0) {
            Log.d(TAG, "Метод incorrect_click: Тест");
            Log.d(TAG, "Метод incorrect_click: Уровень > 0");
            // добавление ответа в incorrectList
            incorrectListQuestion.add(drawables.get(0));
            incorrectListAnswer.add(rights.get(0));
            Log.d(TAG, "Метод incorrect_click: размер incorrectListQuestion = " + incorrectListQuestion.size());
            Log.d(TAG, "Метод incorrect_click: правильный ответ = " + incorrectListAnswer.get(incorrectListAnswer.size() - 1));

            // очищаем
            drawables.remove(0);
            rights.remove(0);

            // очищаем значения кнопок
            number.clear();
            number2.clear();

            //переход на следующий пример, пока примеры не закончились
            if (!arrayListQuestion.isEmpty()) {
                Log.d(TAG, "Метод incorrect_click: arrayListQuestion не пустой");
                // установка изображения с новым примером
                setting_image(drawables, rights);

                // установка значений для неправильных ответов
                setting_the_value_button();
            }
            // если примеры закончились, переходим на Interim1.Activity
            else {
                Log.d(TAG, "Метод incorrect_click: drawables пустой");

                // переходим на промежуточное Активити
                Intent intentInterim1 = new Intent(this, Interim1.class);
                startActivity(intentInterim1);
            }
        }
    }
}


