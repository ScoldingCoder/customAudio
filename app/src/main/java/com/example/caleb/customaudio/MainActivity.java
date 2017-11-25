package com.example.caleb.customaudio;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import static android.R.attr.button;
import static android.R.attr.checked;

public class MainActivity extends AppCompatActivity {

     RadioGroup group1;
    RadioButton option1, option2;
    MediaPlayer t_1;
    MediaPlayer t_2;
    MediaPlayer selected;


    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        group1 = (RadioGroup) findViewById(R.id.select_Tone);
        option1 = (RadioButton) findViewById(R.id.radioButton1);
        option2 = (RadioButton) findViewById(R.id.radioButton2);


        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        t_1 = MediaPlayer.create(this, R.raw.t_1);
        t_2 = MediaPlayer.create(this, R.raw.t_2);

    ;

        group1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {


                        if (option1.isChecked()) {

                            if (selected != null) {
                                //previous ringTone is playing,
                                //stop it first
                                selected.stop();
                                try {
                                    selected.prepare();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }

                            selected = MediaPlayer.create(getApplicationContext(),R.raw.t_1);

                            selected.start();




                            Toast.makeText(MainActivity.this, "Tone 1 playing", Toast.LENGTH_SHORT).show();
                        } else if (option2.isChecked()) {


                            if (selected != null) {
                                //previous ringTone is playing,
                                //stop it first
                                selected.stop();
                                try {
                                    selected.prepare();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            //t_1.stop();
                            selected = MediaPlayer.create(getApplicationContext(),R.raw.t_2);

                            selected.start();

                            Toast.makeText(MainActivity.this, "Tone 2 playing", Toast.LENGTH_SHORT).show();


                        }
                    }




        });
    }}