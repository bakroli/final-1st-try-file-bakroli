package com.codecool.goldminer;

public class SurveyReport {
    private int easyGoldCount;
    private int goldCount;

    public SurveyReport(int easyGoldCount, int goldCount) {
        this.easyGoldCount = easyGoldCount;
        this.goldCount = goldCount;
    }

    public int getEasyGoldCount() {
        return easyGoldCount;
    }

    public int getGoldCount() {
        return goldCount;
    }
}
