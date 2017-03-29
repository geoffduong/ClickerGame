package com.example.geoffduong.clickergame;

/**
 * Created by geoffduong on 3/28/17.
 */

public class Upgrades {

    private int pointsPerUserClick, numberOfRecruits, pointsPerRecruitClick, passiveClick,
                towerUpgradeCost, armoryUpgradeCost, blacksmithUpgradeCost, farmUpgradeCost,
                stableUpgradeCost, barracksUpgradeCost;

    public Upgrades() {

        // Upgrade values
        pointsPerUserClick = 100;
        numberOfRecruits = 0;
        pointsPerRecruitClick = 0;
        passiveClick = 1;

        // Costs
        towerUpgradeCost = 1000;
        armoryUpgradeCost = 1;
        blacksmithUpgradeCost = 1;
        farmUpgradeCost = 1000;
        stableUpgradeCost = 1;
        barracksUpgradeCost = 1000;
    }

    // Tower upgrade
    public int increasePassiveClick(int money) {
        // Check if user has enough money to upgrade, return cost
        if (money >= towerUpgradeCost) {
            passiveClick += 3;
            return towerUpgradeCost;
        }
        return 0;
    }

    // Barracks upgrade
    public int increaseNumberOfRecruits(int money) {
        // Check if user has enough money to upgrade
        if (money >= barracksUpgradeCost) {
            numberOfRecruits++;
            return barracksUpgradeCost;
        }
        return 0;
    }

    // Farm upgrade
    public int increasePointsPerRecruitClick(int money) {
        // Check if user has enough money to upgrade
        if (money >= farmUpgradeCost) {
            pointsPerRecruitClick += 3;
            return farmUpgradeCost;
        }
        return 0;
    }

    public int getPointsPerUserClick() {
        return pointsPerUserClick;
    }

    public int getNumberOfRecruits() {
        return numberOfRecruits;
    }

    public int getPointsPerRecruitClick() {
        return pointsPerRecruitClick;
    }

    public int getPassiveClick() {
        return passiveClick;
    }
}
