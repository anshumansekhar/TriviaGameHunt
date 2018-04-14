package com.horizon.treasurehunt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class SplashActivity extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imageView=(ImageView)findViewById(R.id.imageView);
        Picasso.with(this)
                .load(R.drawable.image)
                .into(imageView);

        Thread background=new Thread(){
            public void run(){

                try{
                    sleep(3000);
                    startActivity(new Intent(SplashActivity.this,MainActivity.class));
                    finish();
                }catch (Exception e){

                }
            }
        };
        background.start();
    }
}
