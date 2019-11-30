package com.example.test_to_speech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {
Button b1;
EditText e1,e2;
String s1,s2;
String s3="Correct";
String s4="Incorrect";
TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tts=new TextToSpeech(MainActivity.this,this);
        b1=findViewById(R.id.a2);
        e1=findViewById(R.id.a1);
        e2=findViewById(R.id.a3);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1 = e1.getText().toString();
                s2 = e2.getText().toString();
                if (s1.contentEquals("Mansi") && s2.contentEquals("12345678")) {
                    tts.speak(s3, TextToSpeech.QUEUE_ADD, null);
                } else {
                    tts.speak(s4, TextToSpeech.QUEUE_ADD, null);
                }
            }
        });
    }

    @Override
    public void onInit(int i) {
        tts.setLanguage(Locale.US);
        tts.setSpeechRate(0.8f);
    }
}
