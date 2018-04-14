package com.horizon.treasurehunt;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<String> question=new ArrayList<>();
    public static ArrayList<String> answers=new ArrayList<>();
    public static ViewPager pager;
    public static pagerAdapter pagerAdapter;
    public static Chronometer timer;
    Long time;
    public  static boolean isStopped=true;

    ConstraintLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        time=new Long("4500000");
        pager=(ViewPager) findViewById(R.id.pager);
        timer=(Chronometer)findViewById(R.id.timer);
        mainLayout=(ConstraintLayout)findViewById(R.id.main_layout);
        timer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if(SystemClock.elapsedRealtime()-chronometer.getBase()>time) {
                    chronometer.stop();
                    isStopped = true;
                    Toast.makeText(getApplicationContext(),"Times Up!!",Toast.LENGTH_SHORT).show();
                }
                else{
                    Log.e("sfhh","sgh");
                }
            }
        });
        isStopped=false;
        pagerAdapter=new pagerAdapter(getSupportFragmentManager());
        String instructions="Instructions\n"+getResources().getString(R.string.Instructions1)
                +getResources().getString(R.string.Instructions2)
                +getResources().getString(R.string.Instructions3)
                +getResources().getString(R.string.Instructions4);
        pagerAdapter.addItem(instructions,"Start");
        pagerAdapter.notifyDataSetChanged();
        addData();
        pager.setAdapter(pagerAdapter);
        pager.setPageTransformer(true,new ZoomOutPageTransformer());


    }
    public class ZoomOutPageTransformer implements ViewPager.PageTransformer{
        private static final float MIN_SCALE=0.85f;
        private static final float MIN_ALPHA=0.5f;

    @Override
    public void transformPage(View page, float position) {
        int pageWidth=page.getWidth();
        int pageHeight=page.getHeight();


        if(position < -1){
            page.setAlpha(0);
        }else if(position <=1){
            float scaleFactor=Math.max(MIN_SCALE,1-Math.abs(position));
            float vertMargin=pageHeight * (1-scaleFactor)/2;
            float hortMargin=pageWidth * (1-scaleFactor)/2;

            if(position <0){
                page.setTranslationX(hortMargin-vertMargin /2);

            }else{
                page.setTranslationX(-hortMargin+vertMargin /2);
            }
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);

            page.setAlpha(MIN_ALPHA +(scaleFactor - MIN_SCALE)/(1-MIN_SCALE)*(1-MIN_ALPHA));
        }else{
            page.setAlpha(0);
        }

    }
}

    public void addData(){
        //TODO add codes
        question.add("Go The Distance\n"
        +"Somewhere hiding in the Trees \n" +
                "I am harbouring something \n" +
                "which gives you some relief");
        answers.add("HUNT IS ON");
        question.add("I was here for a purpose but have been used for another \n" +
                "Your need is my service \n" +
                "I wish the suspension will soon be put off me ");
        answers.add("90S GROOVE");
        question.add("So far so good their visualisation is treat to the eye\n" +
                "looks for the clue in the colourful Inscriptions which took us to something new");
        answers.add("81018I261014");
        question.add("Be it Banquet\n" +
                "Be it a gathering\n" +
                "Experiencing social intercations is my thing");
        answers.add("REACH D TREASURE SWEET D PLEASURE");
        question.add("The Glory of me is the Prominence of this place erect\n" +
                "Standing on my Pillar\n" +
                "Pacing my eyes on each face");
        answers.add("DREAM DARE DERIVE");
        question.add("She is the new Bride to The place so old\n" +
                "She is wanted by all but remains cold");
        answers.add("JAY MAA CHINNAMASTA");
        question.add("");
        answers.add("");

    }
}
