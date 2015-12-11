package com.yourdudeliness.tapdaat20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.*;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.TextView;

public class PlayScreen extends AppCompatActivity implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {

    public final Handler scoreHandler = new Handler();
    private final static int SECOND = 800;
    public static Buildings neutral1, neutral2, neutral3, pathos1, pathos2, pathos3, deity;
    private Intent upScreenIntent, trophyScreenIntent;

    /*
    References to elements within the layout
     */
    private PopupMenu menu;
    private static TextView scoreBox;
    protected static Button n1, n2, n3, p1, p2, p3, dt, cp1, cp2, cp3;
    protected static ImageButton mainButton;
    public static ProgressBar manaBar;

    /*
    SCORING VARIABLES
     */
    protected static double currScore = 0;
    private static double currClickVal = 25;
    private static double totalClicks;
    private static double totalClickValue;
    private static double currPassive;
    private static double currMana;
    private static double currPassiveMana;

    private static boolean threadSet = false;
    private static int coinChance = 2;//Drop rate for coins
    private static boolean pathosEnabled = false;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_screen_layout);//choose xml file to use as activity layout




        initializeMenu();

        initializeBuildings();
        View view = (View) this.findViewById(android.R.id.content).getRootView();
        initializeButtons(view);

        scoreBox = (TextView) findViewById(R.id.score_box);
        scoreBox.setText("Score is " + currScore);//Set the text on creation of the activity

        if(!threadSet) {
            initializePassive(); //only start a thread if no thread has been previously started
        }


    }











    /*
    Determines actions taken when a button on the play_screen is pressed.
     */
    @Override
    public void onClick(View v) {

        //Check id of clicked element
        switch (v.getId()) {

            case R.id.menu:
                menu.show();
                break;
            case R.id.main_button:
                //incrementScore();
                printScore();
                totalClicks++;
               /* switch(totalClicks){
                    case 100:
                        UpgradesFragment.nextUpgrade("ClickingNumber",0);
                        break;
                    case 500:
                        UpgradesFragment.nextUpgrade("ClickingNumber",1);
                        break;
                    case 2500:
                        UpgradesFragment.nextUpgrade("ClickingNumber",2);
                }
                */
                break;
            case R.id.neutral_1:
                neutral1.build();
                //updateButton("neutral1");
                break;
            case R.id.neutral_2:
                neutral2.build();
                //updateButton("neutral2");
                break;
            case R.id.neutral_3:
                neutral3.build();
                //updateButton("neutral3");
                break;
            case R.id.pathos_1:
                if(pathosEnabled){
                    pathos1.build();
                    //updateButton("p1");
                }
                break;
            case R.id.pathos_2:
                if(pathosEnabled){
                    pathos2.build();
                    //updateButton("p2");
                }
                break;

            case R.id.pathos_3:
                if(pathosEnabled){
                    pathos3.build();
                    //updateButton("p3");
                }
                break;
            case R.id.deity:
                if(pathosEnabled){
                    deity.build();
                    //updateButton("deity");
                }
                break;
            case R.id.power_1:
                //SpellCast.power1();
                break;
            case R.id.power_2:
                if(pathosEnabled){
                    //SpellCast.power2();
                }
                break;
            case R.id.power_3:
                if(pathosEnabled){
                    //SpellCast.power3();
                }
                break;
        }

    }




    /*
    Calls startActivity() on a specific Intent depending on the menu
    item id() selected
     */
    @Override
    public boolean onMenuItemClick(MenuItem item){

        switch (item.getItemId()) {
            case 1:
                startActivity(upScreenIntent);
                break;
            case 2:
                startActivity(trophyScreenIntent);
                break;

        }

        return false;
    }


    protected static void printScore(){
        currScore += currClickVal;
        totalClickValue += currClickVal;
        totalClicks += 1;
        scoreBox.setText("Score is " + currScore);
        //primary_activity.testbox.setText(Integer.toString(MainActivity.totalClickValue));

        //checkUpgrades();

        /*
        isCoin = coinGen.nextInt(100);//generate random number < 100

        if(isCoin < coinChance){
            //generate a coin if rand is less than the percentage chance of receiving a coin
            coinCollection.generateCoin(coinGen.nextInt(3));
        }

        checkFunds();
        */


    }

    protected static void checkFunds(){

    }

    protected static void updatePassive(){
        if(pathosEnabled){
            currPassive = neutral1.getCumulativePassive()
                    + neutral2.getCumulativePassive()
                    + neutral3.getCumulativePassive()
                    + pathos1.getCumulativePassive()
                    + pathos2.getCumulativePassive()
                    + pathos3.getCumulativePassive()
                    + deity.getCumulativePassive();
        } else {
            currPassive = neutral1.getCumulativePassive()
                    + neutral2.getCumulativePassive()
                    + neutral3.getCumulativePassive();
        }
    }



    /*
   Uses the Handler to start a background thread which handles the passive
   incrementation of score and mana
    */
    private void initializePassive(){

        threadSet = true;
        scoreHandler.postDelayed(new Runnable() {

            @Override
            public void run() {
                if (true) {

                    currScore += currPassive;
                    scoreBox.setText("Score is " + currScore);


                }
                scoreHandler.postDelayed(this, SECOND);
            }
        }, SECOND); // tells it to run itself again in 1 second
    }


    private void initializeButtons(View view){

        mainButton = (ImageButton) view.findViewById(R.id.main_button);
        n1 = (Button) view.findViewById(R.id.neutral_1);
        n2 = (Button) view.findViewById(R.id.neutral_2);
        n3 = (Button) view.findViewById(R.id.neutral_3);

        p1 = (Button) view.findViewById(R.id.pathos_1);
        p2 = (Button) view.findViewById(R.id.pathos_2);
        p3 = (Button) view.findViewById(R.id.pathos_3);
        dt = (Button) view.findViewById(R.id.deity);

        mainButton.setOnClickListener(this);
        n1.setOnClickListener(this);
        n2.setOnClickListener(this);
        n3.setOnClickListener(this);
        p1.setOnClickListener(this);
        p2.setOnClickListener(this);
        p3.setOnClickListener(this);
        dt.setOnClickListener(this);






    }


    private void initializeBuildings(){

        neutral1 = new Buildings("Farm", 10, 1);
        neutral2 = new Buildings("Inn", 30, 5);
        neutral3 = new Buildings("Blacksmith", 50, 20);
        //coinCollection = new PathosCoins();

    }


    /*
    Initializes the menu object, adds two dropdown items to it, and sets onClick listeners
    Also initializes the Intents for use
     */
    private void initializeMenu(){

        menu = new PopupMenu(this, findViewById(R.id.menu));

        //No idea about Menu.NONE, but 1 is the id, while "Upgrades" is displayed in the UI dropdown list
        menu.getMenu().add(Menu.NONE, 1, Menu.NONE, "Upgrades");
        menu.getMenu().add(Menu.NONE, 2, Menu.NONE, "Trophies");

        //Initialize a View variable containing the current view
        //############ CHECK IF THIS IS GOOD OR NOT, MIGHT WANT MOST CURENT CONTEXT   ##########   DOUBLECHECK
        View thisView = (View) this.findViewById(android.R.id.content).getRootView();

        //Initialize the Intents, using individual intents for travel to each activity
        upScreenIntent = new Intent(thisView.getContext(), UpgradesScreen.class);
        trophyScreenIntent = new Intent(thisView.getContext(), TrophyScreen.class);

        //Set onClick for the dropdown menu, then for individual menu elements respectively
        findViewById(R.id.menu).setOnClickListener(this);
        menu.setOnMenuItemClickListener(this);
    }
}
