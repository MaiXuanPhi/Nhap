package com.example.nhap.button_animation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintSet;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import com.example.nhap.R;

public class ButtonAnimation extends AppCompatActivity {

    Button buttonPlay;
    Animation scaleUp, scaleDown;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_animation);

        buttonPlay = findViewById(R.id.button_play);

        scaleUp = AnimationUtils.loadAnimation(this,R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(this,R.anim.scale_down);

        buttonPlay.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_UP){
                    buttonPlay.startAnimation(scaleUp);
                }else if (event.getAction()==MotionEvent.ACTION_DOWN){
                    buttonPlay.startAnimation(scaleDown);
                }
                return true;
            }
        });
    }

    public void toast(View view) {
        Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();
    }
}