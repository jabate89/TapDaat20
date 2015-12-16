package com.yourdudeliness.tapdaat20;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 * Created by Awesomeness on 12/9/15.
 */
public class TrophyScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trophy_screen_layout);


        Button test = (Button) findViewById(R.id.goto_main_troph);

        test.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent returnTrophy = new Intent(v.getContext(), PlayScreen.class);
                                        startActivity(returnTrophy);
                                    }
                                }
        );
    }
}
