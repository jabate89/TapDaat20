package com.yourdudeliness.tapdaat20;

/**
 * Created by Awesomeness on 12/10/15.
 */
public class Gems {

    private static int [] gems = new int[3];
    private static boolean FirstCoin = false;

    public static void generateGem(int gem){

        if(!FirstCoin){
            /*
            Make pathos upgrades available
             */
            FirstCoin = true;
        }

        switch(gem){
            case 0:
                gems[gem] += 1;
                PlayScreen.gems[gem].setText(gems[gem] +"");
                break;
            case 1:
                gems[gem] += 1;
                PlayScreen.gems[gem].setText(gems[gem] +"");
                break;
            case 2:
                gems[gem] += 1;
                PlayScreen.gems[gem].setText(gems[gem] +"");
                break;
        }
    }


    protected static void printGems(){

        for(int i = 0; i < 3; i++){
            PlayScreen.gems[i].setText(""+gems[i]);
        }

    }



}
