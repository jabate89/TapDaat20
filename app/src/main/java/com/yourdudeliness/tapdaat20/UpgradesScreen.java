package com.yourdudeliness.tapdaat20;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.view.Window;
import android.widget.Button;

/**
 * Created by Awesomeness on 12/9/15.
 */
public class UpgradesScreen extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upgrades_screen_layout);

        Button home = (Button) findViewById(R.id.goto_main);
        Button good = (Button) findViewById(R.id.good);
        Button evil = (Button) findViewById(R.id.evil);

        home.setOnClickListener(this);
        good.setOnClickListener(this);
        evil.setOnClickListener(this);

    }






    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.goto_main:
                Intent intent = new Intent(v.getContext(), PlayScreen.class);
                startActivity(intent);
                break;
            case R.id.good:
                PlayScreen.pathosChosen = 0;
                PlayScreen.pathosEnabled = true;
                Update.pathos(0);
                break;
            case R.id.evil:
                PlayScreen.pathosChosen = 1;
                PlayScreen.pathosEnabled = true;
                Update.pathos(1);
                break;
        }

    }



}

