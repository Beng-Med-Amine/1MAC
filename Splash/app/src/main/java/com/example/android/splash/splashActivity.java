package com.example.android.splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class splashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE); // هذا السطر لنزع عنوان التطبيق  من الأكتيفيتي
		
        setContentView(R.layout.activity_splash); // جعل سبلاش لايوت كواجهة لهذه الأكتيفيتي

            Thread s = new Thread(){ // انشاء كائن من نوع ثريد  الذي يسمح لنا بتشغيله بشكل متزامن مع التطبيق

            @Override
            public void run() { // الدالة التي تستدع عن طريق ستارت

                                try {
                    sleep(3*1000); // وقت الانتظار
                    Intent i = new Intent(splashActivity.this,MainActivity.class); // انشاء انتنت لتوجيه من أكتيفيتي الحالية الى الأكتيفيتي الموالية
                    startActivity(i); 
                    finish(); // الأكتيفيتي الحالية
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

	    s.start();// استدعاء الدالة  run 

    }
}
