package com.khezu.felicitacionnavidena;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp;
    ImageButton boton;
    int numero = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton = (ImageButton)findViewById(R.id.boton);
        mp = MediaPlayer.create(this, R.raw.jingle_bell_rock);
        mp.start();
        mp.setLooping(true);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(numero == 1){
                    pausar();
                } else{
                    reanudar();
                }
            }
        });
    }

    public void reanudar() {
        mp.seekTo(mp.getCurrentPosition());
        mp.start();
        numero = 1;
    }

    public void pausar() {
        mp.pause();
        numero = 2;
    }

}
