package com.horizon.treasurehunt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class End extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        textView=(TextView)findViewById(R.id.textView);
        textView.setText(getIntent().getStringExtra("text"));
    }
}
