package com.khezu.felicitacionnavidena;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp;
    ImageButton boton;
    int numero = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //MediaPlayer
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

        //Animaciones
        Animation animacionBoton = AnimationUtils.loadAnimation(this, R.anim.animacion_boton);
        boton.startAnimation(animacionBoton);

        TextView tv1 = (TextView) findViewById(R.id.tv1);
        TextView tv2 = (TextView) findViewById(R.id.tv2);
        TextView tv3 = (TextView) findViewById(R.id.tv3);

        Animation animacion1 = AnimationUtils.loadAnimation(this, R.anim.animacion_letras_1);
        Animation animacion2 = AnimationUtils.loadAnimation(this, R.anim.animacion_letras_2);

        tv1.startAnimation(animacion1);
        tv2.startAnimation(animacion2);
        tv3.startAnimation(animacion1);

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
