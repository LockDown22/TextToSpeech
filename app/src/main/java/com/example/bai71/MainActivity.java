package com.example.bai71;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextToSpeech tts;
    EditText nhap;
    Button speech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    public void init(){
        nhap = findViewById(R.id.edtNhap);
        speech = findViewById(R.id.btnSpeech);
        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                            if(i!=TextToSpeech.ERROR){
                                tts.setLanguage(Locale.ENGLISH);
                            }
            }
        });

        speech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String toSpeak = nhap.getText().toString();
                tts.speak(toSpeak,TextToSpeech.QUEUE_FLUSH,null,null);
            }
        });



    }
}