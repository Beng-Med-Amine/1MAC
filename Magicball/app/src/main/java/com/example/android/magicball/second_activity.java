package com.example.android.magicball;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;
import java.lang.Math.*;
import java.util.ArrayList;
import java.util.Random;

public class second_activity extends AppCompatActivity {


    private static final String TAG = second_activity.class.getName();
    private LinearLayout layout2 ,layout1;
    private TextView tv1;
    private int choice=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activity);
        Resources res = getResources();
        String[] symbols = res.getStringArray(R.array.string_array_symbol);
        int value=0;

        layout1 = new LinearLayout(this);
        layout1.setOrientation(LinearLayout.VERTICAL);
        layout1.setBackgroundColor(Color.parseColor("#222f3e"));
        layout1.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        choice=(int)(Math.random()*symbols.length);
        for (int j = 0; j < 20; j++) {
            layout2 = new LinearLayout(this);
            layout2.setOrientation(LinearLayout.HORIZONTAL);
            layout2.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
            layout1.addView(layout2);
            for (int i = 0; i < 5; i++) {
                tv1 = new TextView(this);
                tv1.setGravity(Gravity.CENTER);
                tv1.setTextColor(Color.WHITE);
                tv1.setTextScaleX((float)1.25);
                value=(int)(Math.random()*symbols.length);
                if((i*20+j)%9==0){
                    value=choice;
                }
                tv1.setText("" + String.format("%02d",(i*20+j)) +symbols[value]);
                Log.i(TAG, i + " onCreate: " + value);
                tv1.setTextSize(16);

                tv1.setPadding(16, 8, 16, 0);
                tv1.setLayoutParams(new TableLayout.LayoutParams(0, LayoutParams.WRAP_CONTENT, 1f));

                layout2.addView(tv1);
            }


        }
        RelativeLayout relativeLayout1= new RelativeLayout(this);

        relativeLayout1.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        relativeLayout1.setGravity(Gravity.CENTER);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
        LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        params.addRule(RelativeLayout.CENTER_HORIZONTAL);
        ImageButton btn = new ImageButton(this);
        btn.setImageResource(R.drawable.magicball);
        btn.setLayoutParams(params);
        relativeLayout1.addView(btn);
        layout1.addView(relativeLayout1);
        setContentView(layout1);
        btn.setOnClickListener(ibLis);
    }


    private OnClickListener ibLis=new OnClickListener(){

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            //START YOUR ACTIVITY HERE AS
            Intent intent = new Intent(second_activity.this,third_activity.class);
            intent.putExtra("choice",choice);
            startActivity(intent);
            finish();
        }
    };

}
