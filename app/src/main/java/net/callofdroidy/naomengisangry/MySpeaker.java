package net.callofdroidy.naomengisangry;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.util.Log;

import java.util.Locale;

/**
 * Created by admin on 08/04/16.
 */
public class MySpeaker implements TextToSpeech.OnInitListener{
    private static final String TAG = "MySpeaker";

    private TextToSpeech textToSpeech;

    public MySpeaker(Context context){
        textToSpeech = new TextToSpeech(context, this);
    }

    @Override
    public void onInit(int status){
        if(status != TextToSpeech.ERROR){
            textToSpeech.setLanguage(Locale.CANADA);
            Log.e(TAG, "onInit: Text-To-Speech is ready");
        }else
            Log.e(TAG, "onInit: Text-To-Speech init failed");
    }

    public void speak(String content){
        textToSpeech.speak("speak", TextToSpeech.QUEUE_FLUSH, null, "SpeakID_general");
    }
}
