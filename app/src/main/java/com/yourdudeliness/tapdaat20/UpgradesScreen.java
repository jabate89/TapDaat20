package com.yourdudeliness.tapdaat20;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.widget.Button;

/**
 * Created by Awesomeness on 12/9/15.
 */
public class UpgradesScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upgrades_screen_layout);

        Button home = (Button) findViewById(R.id.goto_main);

        home.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent = new Intent(v.getContext(), PlayScreen.class);
                                        startActivity(intent);
                                    }
                                }
        );
    }
}

