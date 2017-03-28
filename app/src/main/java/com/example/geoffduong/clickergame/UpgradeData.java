package com.example.geoffduong.clickergame;

/**
 * Created by geoffduong on 3/27/17.
 */

public class UpgradeData {
    private int upgradeImage, upgradeLevel;
    private String upgradeName, upgradeDescription;
    private boolean active;

    public UpgradeData(int upgradeImage, String upgradeName, boolean active) {
        this.upgradeImage = upgradeImage;
        this.upgradeName = upgradeName;
        this.active = active;
        upgradeLevel = 0;
    }

    public int getUpgradeLevel() {
        return upgradeLevel;
    }

    public void increaseUpgradeLevel() {
        this.upgradeLevel++;
    }

    public String getUpgradeName() {
        return upgradeName;
    }

    public void setUpgradeName(String upgradeName) {
        this.upgradeName = upgradeName;
    }

    public String getUpgradeDescription() {
        return upgradeDescription;
    }

    public void setUpgradeDescription(String upgradeDescription) {
        this.upgradeDescription = upgradeDescription;
    }

    public int getUpgradeImage() {
        return upgradeImage;
    }

    public void setUpgradeImage(int upgradeImage) {
        this.upgradeImage = upgradeImage;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
