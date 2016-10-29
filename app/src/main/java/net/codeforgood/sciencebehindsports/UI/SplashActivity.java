package net.codeforgood.sciencebehindsports.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.os.Handler;
import android.widget.TextView;

import net.codeforgood.sciencebehindsports.R;

public class SplashActivity extends AppCompatActivity {
    // Duration of wait
    private final int SPLASH_DISPLAY_LENGTH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        new Handler().postDelayed(new Runnable() {
            @Override

            //starts off with Splash Screen as main intent, then moves on to login activity to check
            //if user has logged in before
            public void run() {
                Intent mainIntent = new Intent(SplashActivity.this, LoginActivity.class);
                SplashActivity.this.startActivity(mainIntent);
                SplashActivity.this.finish();

            }
        }, SPLASH_DISPLAY_LENGTH);



    }

}
