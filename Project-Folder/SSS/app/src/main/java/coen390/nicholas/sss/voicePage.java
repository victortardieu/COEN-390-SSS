package coen390.nicholas.sss;

import android.content.Intent;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;
import java.util.Random;

public class voicePage extends AppCompatActivity
{
    //--------------------------------------------Declaring variables----------------------------------------------
    //-------for objects needed in the home page-------
    TextView title = null;
    TextView voice = null;
    Button getVLetter = null;

    //--------to LOG textPage events-----------
    protected static final String TAG = "textActivity";

    //------------Voice variable-----------------
    TextToSpeech t1;

    //---------------------------------------Function for when the activity is created--------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice_page);
        Log.d(TAG,"The onCreate() event");

        hash.setAlphabets();

        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.UK);
                }
            }
        });

        setupUI();
    }

    //---------------------------Function that links the objects to their xml definitions-----------------------------
    protected void setupUI()
    {
        title = (TextView) findViewById(R.id.voiceTitle);
        voice = (TextView) findViewById(R.id.viewLetter);
        getVLetter = (Button) findViewById(R.id.getLetterV);
    }

    //-----------------------------------Functions for when the user presses the items--------------------------------------
    //------when the action button gets pressed--------
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu, menu);

        return true;
    }

    //-----------when items are selected----------------
    public boolean onOptionsItemSelected(MenuItem item)
    {
        Log.d(TAG, "The onOptions event");
        switch (item.getItemId())
        {
            //action to switch to settings gets pressed
            case R.id.goSettings:
                Intent startIntent = new Intent(voicePage.this, settings.class);
                startActivity(startIntent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //-------------------------------------Function for getting and outputting a letter----------------------------------------
    public void outputVoice(View view)
    {
        //-------Generate a random number from 1-26 for the indexes---------
        Random rndIndex = new Random();
        int hashIndex = rndIndex.nextInt(26) + 1;

        String letter = hash.getAlphabets(hashIndex);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            t1.speak(letter,TextToSpeech.QUEUE_FLUSH,null,null);
        } else {
            t1.speak(letter, TextToSpeech.QUEUE_FLUSH, null);
        }
    }
}
