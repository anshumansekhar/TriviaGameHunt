package com.horizon.treasurehunt;


import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Anshuman-HP on 11-02-2018.
 */

public class QuestionCardFragment extends Fragment {
    TextView questionTextBox;
    EditText answerEditText;
    FloatingActionButton fab;

    int position;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.question_card,container,false);
        position=getArguments().getInt("position");
        questionTextBox=(TextView)v.findViewById(R.id.questionText);
        answerEditText=(EditText)v.findViewById(R.id.answerEditText);
        fab=(FloatingActionButton)v.findViewById(R.id.floatingActionButton);
        fab.setImageResource(R.drawable.ic_play_arrow_black_24dp);
        questionTextBox.setText(MainActivity.pagerAdapter.question.get(position));
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String answer=answerEditText.getText().toString().trim();
                Log.e("dgf",answer);
                if(!MainActivity.isStopped) {
                    if (answer.equalsIgnoreCase(MainActivity.pagerAdapter.answers.get(position))) {
                        //TODO play a sound
                        if(position!=0) {
                            Toast.makeText(getActivity(), "Right Answer", Toast.LENGTH_SHORT).show();
                        }
                        if (MainActivity.question.size() > position ) {
                            if(position==0){
                                MainActivity.timer.setBase(SystemClock.elapsedRealtime());
                                MainActivity.timer.start();
                            }
                            MainActivity.pagerAdapter.addItem(MainActivity.question.get(position), MainActivity.answers.get(position));
                            MainActivity.pagerAdapter.notifyDataSetChanged();
                            MainActivity.pager.setCurrentItem(position + 1);
                        }
                        else{
                            Intent i=new Intent(getActivity(),End.class);
                            i.putExtra("text","Congratulations,\n"+"You Won!!!");
                            startActivity(i);
                            getActivity().finish();
                        }
                    } else {
                        //TODO play a sound
                        Toast.makeText(getActivity(),"Wrong Code!",Toast.LENGTH_SHORT).show();


                    }
                }else{
                    Toast.makeText(getActivity(),"Times Up!!",Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(getActivity(),End.class);
                    i.putExtra("text","Thank You \n For Playing...");
                    startActivity(i);
                    getActivity().finish();
                }

            }
        });

        return v ;
    }

    public void showEndView(boolean isWinner){
        if(isWinner){

        }

    }
}
