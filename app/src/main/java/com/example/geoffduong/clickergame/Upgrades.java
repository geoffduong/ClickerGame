package com.example.geoffduong.clickergame;

/**
 * Created by geoffduong on 3/28/17.
 */

public class Upgrades {
    private int pointsPerUserClick, numberOfRecruits, pointsPerRecruitClick, passiveClick;

    public Upgrades() {
        pointsPerUserClick = 3;
        numberOfRecruits = 0;
        pointsPerRecruitClick = 0;
        passiveClick = 1;
    }

    public void increasePassiveClick(int money) {
        // Check if user has enough money to upgrade
        // Code here

        passiveClick += 1000;
    }

    public void increaseNumberOfRecruits(int money) {
        // Check if user has enough money to upgrade
        // Code here

        numberOfRecruits++;
    }

    public void increasePointsPerRecruitClick(int money) {
        // Check if user has enough money to upgrade
        // Code here

        pointsPerRecruitClick += 3;
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
