package com.horizon.treasurehunt;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Anshuman-HP on 11-02-2018.
 */

public class pagerAdapter extends FragmentStatePagerAdapter {

    public  ArrayList<String> question=new ArrayList<>();
    public  ArrayList<String> answers=new ArrayList<>();

    public pagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Log.e("xz",""+position);
        QuestionCardFragment fragment=new QuestionCardFragment();
        Bundle b=new Bundle();
        b.putInt("position",position);
        fragment.setArguments(b);
        return fragment;
    }

    @Override
    public int getCount() {
        return question.size();
    }

    public void addItem(String questionString,String answerString){
        question.add(questionString);
        answers.add(answerString);
    }

}
