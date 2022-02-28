package com.codecool.goldminer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SonarScanResultProcessor {

    public SurveyReport process(String fileName) {
        List<String> rows = new ArrayList<>();

        try {
            rows = Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        int goldCount = sumGold(rows);
        int easyGoldCount = sumEasyGold(rows);

        return new SurveyReport(easyGoldCount, goldCount);
    }



    private int sumGold(List<String> rows) {
        int sum = 0;
        for (String row : rows) {
            for (char c : row.toCharArray()) {
                if (c == 'g') {
                    sum += 1;
                }
            }
        }
        return sum;
    }

    private int sumEasyGold(List<String> rows) {
        int sum = 0;
        for (String row : rows) {
            for (int i = 1; i < row.length() -1; i++) {
                char c = row.charAt(i);
                if (c == 'g') {
                    char cUp = row.charAt(i+1);
                    char cDown = row.charAt(i-1);
                    if (cUp == ' ' || cDown == ' ') {
                        sum += 1;
                    }
                }
            }
        }
        return sum;
    }
}
