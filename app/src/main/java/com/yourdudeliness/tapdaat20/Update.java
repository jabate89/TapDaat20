package com.yourdudeliness.tapdaat20;

import android.view.View;

/**
 * Created by Awesomeness on 12/15/15.
 */
public class Update {

    protected static void button(View v){

        //Check id of clicked element
        switch (v.getId()) {

            case R.id.menu:
                PlayScreen.menu.show();
                break;
            case R.id.main_button:
                score();
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
                PlayScreen.neutral1.build();
                PlayScreen.n1.setText(PlayScreen.neutral1.printStats());
                break;
            case R.id.neutral_2:
                PlayScreen.neutral2.build();
                PlayScreen.n2.setText(PlayScreen.neutral2.printStats());
                break;
            case R.id.neutral_3:
                PlayScreen.neutral3.build();
                PlayScreen.n3.setText(PlayScreen.neutral3.printStats());
                break;
            case R.id.pathos_1:
                if (PlayScreen.pathosEnabled) {
                    PlayScreen.pathos1.build();
                }
                break;
            case R.id.pathos_2:
                if (PlayScreen.pathosEnabled) {
                    PlayScreen.pathos2.build();
                }
                break;

            case R.id.pathos_3:
                if (PlayScreen.pathosEnabled) {
                    PlayScreen.pathos3.build();
                }
                break;
            case R.id.deity:
                if (PlayScreen.pathosEnabled) {
                    PlayScreen.deity.build();
                }
                break;
            case R.id.power_1:
                //SpellCast.power1();
                break;
            case R.id.power_2:
                if (PlayScreen.pathosEnabled) {
                    //SpellCast.power2();
                }
                break;
            case R.id.power_3:
                if (PlayScreen.pathosEnabled) {
                    //SpellCast.power3();
                }
                break;
        }


    }



    protected static void score(){
        PlayScreen.currScore += PlayScreen.currClickVal;
        PlayScreen.totalClickValue += PlayScreen.currClickVal;
        PlayScreen.totalClicks += 1;
        printScore();
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

    protected static void printScore(){
        PlayScreen.scoreBox.setText("Total " + PlayScreen.currScore);
        PlayScreen.manaBar.setProgress(PlayScreen.currMana);
    }


    /*
    Updates the maximum possible Mana obtainable
     */
    protected static void mana(int newMax){
        PlayScreen.maxMana = newMax;
        PlayScreen.manaBar.setMax(newMax);
    }


    protected static void funds(){


        if(PlayScreen.currScore < PlayScreen.neutral1.getCostOfNext()){
            PlayScreen.n1.setEnabled(false);
        } else { PlayScreen.n1.setEnabled(true); }

        if(PlayScreen.currScore < PlayScreen.neutral2.getCostOfNext()){
            PlayScreen.n2.setEnabled(false);
        } else { PlayScreen.n2.setEnabled(true);}

        if(PlayScreen.currScore < PlayScreen.neutral3.getCostOfNext()){
            PlayScreen.n3.setEnabled(false);
        } else { PlayScreen.n3.setEnabled(true); }

        if(PlayScreen.currMana < 350){
            PlayScreen.cp1.setEnabled(false);
        } else {PlayScreen.cp1.setEnabled(true); }

        if(PlayScreen.pathosEnabled){

            if(PlayScreen.currScore < PlayScreen.pathos1.getCostOfNext()){
                PlayScreen.p1.setEnabled(false);
            } else { PlayScreen.p1.setEnabled(true); }


            if(PlayScreen.currScore < PlayScreen.pathos2.getCostOfNext()){
                PlayScreen.p2.setEnabled(false);
            } else { PlayScreen.p2.setEnabled(true); }

            if(PlayScreen.currScore < PlayScreen.pathos3.getCostOfNext()){
                PlayScreen.p3.setEnabled(false);
            } else { PlayScreen.p3.setEnabled(true); }

            if(PlayScreen.currScore < PlayScreen.deity.getCostOfNext()){
                PlayScreen.dt.setEnabled(false);
            } else { PlayScreen.dt.setEnabled(true); }



        }
    }

    protected static void pathos(int pathos) {

        if(!PlayScreen.pathosEnabled){
            return;
        }

            if (pathos == 0) {
                PlayScreen.pathos1 = new Buildings("Speakeasy", 1000, 200);
                PlayScreen.pathos2 = new Buildings("SeaOrg", 15000, 2000);
                PlayScreen.pathos3 = new Buildings("Brothel", 100000, 100000);

            } else if (pathos == 1) {
                PlayScreen.pathos1 = new Buildings("Conduction", 1000, 200);
                PlayScreen.pathos2 = new Buildings("Convection", 15000, 2000);
                PlayScreen.pathos3 = new Buildings("Radiation", 100000, 100000);

            }

            PlayScreen.deity = new Buildings("Mormon Temple", 15000000, 100000);


        //Set the buttons to visible
        PlayScreen.p1.setVisibility(View.VISIBLE);
        PlayScreen.p2.setVisibility(View.VISIBLE);
        PlayScreen.p3.setVisibility(View.VISIBLE);
        PlayScreen.dt.setVisibility(View.VISIBLE);
        PlayScreen.cp2.setVisibility(View.VISIBLE);
        PlayScreen.cp3.setVisibility(View.VISIBLE);


        PlayScreen.p1.setEnabled(true);
        PlayScreen.p1.setText(PlayScreen.pathos1.printStats());
        PlayScreen.p2.setEnabled(true);
        PlayScreen.p2.setText(PlayScreen.pathos2.printStats());
        PlayScreen.p3.setEnabled(true);
        PlayScreen.p3.setText(PlayScreen.pathos3.printStats());
        PlayScreen.dt.setEnabled(true);
        PlayScreen.dt.setText(PlayScreen.deity.printStats());
        PlayScreen.cp2.setEnabled(true);
        PlayScreen.cp3.setEnabled(true);




        PlayScreen.pathosEnabled = true;

    }


}
