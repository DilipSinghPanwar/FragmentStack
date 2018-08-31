package com.androiddevs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.androiddevs.activities.SignInActivity;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    startActivity(new Intent(SplashActivity.this,SignInActivity.class));
                    SplashActivity.this.finish();
                }
            }
        }).start();
    }
}
