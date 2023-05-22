package com.rifatkhan.LuckyNumberApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class SecondPage extends AppCompatActivity {
    TextView welcome_txt, result_txt;
    Button share_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);

        welcome_txt = findViewById(R.id.textView1);
        result_txt = findViewById(R.id.textView2);
        share_btn = findViewById(R.id.share_btn);

        Intent i = getIntent();
        String userName = i.getStringExtra("name");

        int random_Num = generateRandomNumber();

        result_txt.setText("" + random_Num);

        share_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareData(userName, random_Num);
            }
        });


    }

    public int generateRandomNumber() {

        Random random = new Random();
        int upper_limit = 1000;

        int randomNumberGenerated = random.nextInt(upper_limit);
        return randomNumberGenerated;
    }

    public void shareData(String userName, int randomNum) {

        // Implicit Intents
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");

        // convert the int to string
        String number = String.valueOf(randomNum);

        i.putExtra(Intent.EXTRA_SUBJECT, userName + " got lucky today!");
        i.putExtra(Intent.EXTRA_TEXT, "His lucky number is: " + number);


        startActivity(Intent.createChooser(i, "Choose a platform"));


    }

}