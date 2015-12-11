package com.yourdudeliness.tapdaat20;

/**
 * Created by Awesomeness on 12/10/15.
 */
public class Buildings {


    private String buildingType;
    private int totalBuildings;
    private double costOfNext;
    private double BasePassive;
    private int passiveMultiplier;
    private double cumulativePassive;


    public Buildings(String name, int startCost, int passive){

        buildingType = name;//name is building type, defined on object creation
        costOfNext = startCost;//start cost is cost of the first building, increments with each purchase
        BasePassive = passive;//the passive income produced by the first building
        totalBuildings = 0;//the object is instantiated with 0 building
        cumulativePassive = 0; // the Passive of all buildings of same type
    }


    public void build() {

        if (costOfNext <= PlayScreen.currScore) {
            PlayScreen.currScore -= costOfNext;//subtracts the cost of the building
            PlayScreen.printScore();
            PlayScreen.checkFunds();

            totalBuildings += 1;//increments number of buildings
            cumulativePassive = BasePassive * totalBuildings;
            //PlayScreen.updatePassive();
            //MainActivity.currPassive += BasePassive * passiveMultiplier;//increments passive score in main

            costOfNext *= 1.15; //increments the cost of the next building by 7%
            //checkUpgrades();
            //updateCumulativePassive();
        }






    }

    public double getCostOfNext(){
        return costOfNext;
    }

    public double getBuildingTotal(){
        return totalBuildings;
    }

    public String getName(){
        return buildingType;
    }

    public void setBasePassive(double multiplier){
        BasePassive *= multiplier;
        updateCumulativePassive();
    }

    public void updateCumulativePassive(){
        cumulativePassive = BasePassive * totalBuildings;
    }

    public double getCumulativePassive() { return cumulativePassive; }


    public String printStats(){
        return   ( buildingType + "  "
                + totalBuildings
                + "\nCost " + Digits.format(costOfNext)
                + "  Sec " + Digits.format(cumulativePassive));
    }


}
