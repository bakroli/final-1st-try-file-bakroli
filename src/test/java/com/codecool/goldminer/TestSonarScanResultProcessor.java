package com.codecool.goldminer;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestSonarScanResultProcessor {
    public static final String DATA_PATH = "src/main/resources/";
    public static final String TXT = ".txt";
    SonarScanResultProcessor processor = new SonarScanResultProcessor();

    @Test
    @Order(1)
    void testEmptyCaveGround() {
        SurveyReport report = processor.process(getDataFileName("scan0"));
        Assertions.assertEquals(0, report.getEasyGoldCount());
        Assertions.assertEquals(0, report.getGoldCount());
    }

    private String getDataFileName(String fileName) {
        return DATA_PATH + fileName + TXT;
    }


    @Test
    @Order(2)
    void testGroundWithNoGold() {
        String name = getDataFileName("scan1");
        SurveyReport report = processor.process(name);
        Assertions.assertEquals(0, report.getEasyGoldCount());
        Assertions.assertEquals(0, report.getGoldCount());
    }

    @Test
    @Order(3)
    void testGroundWithOneBerriedGold() {
        String name = getDataFileName("scan2");
        SurveyReport report = processor.process(name);
        Assertions.assertEquals(0, report.getEasyGoldCount());
        Assertions.assertEquals(1, report.getGoldCount());
    }

    @Test
    @Order(4)
    void testGroundWithFiveBerriedGold() {
        String name = getDataFileName("scan3");
        SurveyReport report = processor.process(name);
        Assertions.assertEquals(0, report.getEasyGoldCount());
        Assertions.assertEquals(5, report.getGoldCount());
    }

    @Test
    @Order(5)
    void testGroundWithOnlySimpleCaveGold() {
        String name = getDataFileName("scan4");
        SurveyReport report = processor.process(name);
        Assertions.assertEquals(15, report.getEasyGoldCount());
        Assertions.assertEquals(15, report.getGoldCount());
    }

    @Test
    @Order(6)
    void testGroundWithOnlyCaveGold() {
        String name = getDataFileName("scan5");
        SurveyReport report = processor.process(name);
        Assertions.assertEquals(15, report.getEasyGoldCount());
        Assertions.assertEquals(15, report.getGoldCount());
    }

    @Test
    @Order(7)
    void testGroundWithCaveGoldsNextToEachotherAndWithBerriedGold() {
        String name = getDataFileName("scan6");
        SurveyReport report = processor.process(name);
        Assertions.assertEquals(66, report.getGoldCount());
        Assertions.assertEquals(64, report.getEasyGoldCount());
    }

    @Test
    @Order(8)
    void testPureGold() {
        String name = getDataFileName("scan7");
        SurveyReport report = processor.process(name);
        Assertions.assertEquals(0, report.getEasyGoldCount());
        Assertions.assertEquals(16, report.getGoldCount());
    }
}
