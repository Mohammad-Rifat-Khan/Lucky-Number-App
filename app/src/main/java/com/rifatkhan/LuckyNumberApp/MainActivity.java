package com.rifatkhan.LuckyNumberApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textview;
    EditText editText;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview= findViewById(R.id.textview);
        editText= findViewById(R.id.editText);
        btn= findViewById(R.id.press_button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_name= editText.getText().toString();

                //explicit intent:
                Intent i = new Intent(getApplicationContext(),
                        SecondPage.class);

                //passing the name
                i.putExtra("name",user_name);

                startActivity(i);

            }

        });


    }
    
}