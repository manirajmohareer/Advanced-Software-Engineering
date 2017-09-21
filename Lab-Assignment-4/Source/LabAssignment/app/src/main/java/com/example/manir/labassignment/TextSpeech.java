package com.example.manir.labassignment;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class TextSpeech extends AppCompatActivity {
    TextToSpeech toSpeech;
    int result;
    EditText editText;
    String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_speech);
        editText=(EditText)findViewById(R.id.editText);
        toSpeech=new TextToSpeech(TextSpeech.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status==TextToSpeech.SUCCESS)
                {
                    result= toSpeech.setLanguage(Locale.UK);

                }
                else
                    Toast.makeText(getApplicationContext(),"Feature Not Supppoted",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void TTS(View view){
        switch (view.getId()){

            case R.id.button3:
                if(result==TextToSpeech.LANG_MISSING_DATA||result==TextToSpeech.LANG_NOT_SUPPORTED)
                {
                    Toast.makeText(getApplicationContext(), "Feature Not Supppoted", Toast.LENGTH_SHORT).show();
                }
                else {
                   text=editText.getText().toString();
                    toSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null);
                }
                break;
            case R.id.button4:
                if(toSpeech!=null)
                {
                    toSpeech.stop();
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(toSpeech!=null)
        {
            toSpeech.stop();
            toSpeech.shutdown();
        }
    }
}
