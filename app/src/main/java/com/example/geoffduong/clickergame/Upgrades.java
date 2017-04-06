package com.example.geoffduong.clickergame;

/**
 * Created by geoffduong on 3/28/17.
 * Tower - Increases passive click
 * Armory -
 * Blacksmith -
 * Farm - Increase money per recruit click
 * Stable - Increase recruit click speed
 * Barracks - Increase number of recruits to work on Farm
 */

public class Upgrades {

    private long pointsPerUserClick, numberOfRecruits, pointsPerRecruitClick, passiveClick,
                towerUpgradeCost, armoryUpgradeCost, blacksmithUpgradeCost, farmUpgradeCost,
                stableUpgradeCost, barracksUpgradeCost, recruitClickSpeed;

    public Upgrades() {

        // Upgrade values
        pointsPerUserClick = 100;
        numberOfRecruits = 0;
        pointsPerRecruitClick = 0;
        passiveClick = 1;
        recruitClickSpeed = 10;

        // Costs
        towerUpgradeCost = 1000;
        armoryUpgradeCost = 1000;
        blacksmithUpgradeCost = 1000;
        farmUpgradeCost = 1000;
        stableUpgradeCost = 1000;
        barracksUpgradeCost = 1000;
    }

    // Tower upgrade
    public long increasePassiveClick(long money) {
        // Check if user has enough money to upgrade, return cost
        if (money >= towerUpgradeCost) {
            passiveClick += 3;
            return towerUpgradeCost;
        }
        return 0;
    }

    // Barracks upgrade
    public long increaseNumberOfRecruits(long money) {
        // Check if user has enough money to upgrade
        if (money >= barracksUpgradeCost) {
            numberOfRecruits++;
            return barracksUpgradeCost;
        }
        return 0;
    }

    // Farm upgrade
    public long increasePointsPerRecruitClick(long money) {
        // Check if user has enough money to upgrade
        if (money >= farmUpgradeCost) {
            pointsPerRecruitClick += 3;
            return farmUpgradeCost;
        }
        return 0;
    }

    //Stable upgrade
    public long increaseRecruitClickSpeed(long money) {
        if (money >= stableUpgradeCost) {
            recruitClickSpeed -= 5;
            return stableUpgradeCost;
        }
        return 0;
    }

    public void resetUpgrades() {
        // Upgrade values
        pointsPerUserClick = 100;
        numberOfRecruits = 0;
        pointsPerRecruitClick = 0;
        passiveClick = 1;
        recruitClickSpeed = 10;

        // Costs
        towerUpgradeCost = 1000;
        armoryUpgradeCost = 1000;
        blacksmithUpgradeCost = 1000;
        farmUpgradeCost = 1000;
        stableUpgradeCost = 1000;
        barracksUpgradeCost = 1000;
    }

    public long getRecruitClickSpeed() {
        return recruitClickSpeed;
    }

    public long getPointsPerUserClick() {
        return pointsPerUserClick;
    }

    public long getNumberOfRecruits() {
        return numberOfRecruits;
    }

    public long getPointsPerRecruitClick() {
        return pointsPerRecruitClick;
    }

    public long getPassiveClick() {
        return passiveClick;
    }

    public long getTowerUpgradeCost() {
        return towerUpgradeCost;
    }

    public long getArmoryUpgradeCost() {
        return armoryUpgradeCost;
    }

    public long getBlacksmithUpgradeCost() {
        return blacksmithUpgradeCost;
    }

    public long getFarmUpgradeCost() {
        return farmUpgradeCost;
    }

    public long getStableUpgradeCost() {
        return stableUpgradeCost;
    }

    public long getBarracksUpgradeCost() {
        return barracksUpgradeCost;
    }
}
