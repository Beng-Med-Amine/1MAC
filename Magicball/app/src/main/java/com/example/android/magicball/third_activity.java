package com.example.android.magicball;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class third_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_activity);
        Intent myIntent = getIntent();
        int choice= myIntent.getIntExtra("choice",0);
        Resources res = getResources();
        String[] symbols = res.getStringArray(R.array.string_array_symbol);
        TextView tv=(TextView)findViewById(R.id.txt1);
        tv.setText(symbols[choice]);
    }

    public void backToSecond(View view) {
         Intent in = new Intent(third_activity.this,second_activity.class);
         startActivity(in);
         finish();
    }
}
