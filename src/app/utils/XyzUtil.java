package app.utils;

public class XyzUtil {

    private String name;
    private int firstMonth;
    private int secondMonth;
    private int thirdMonth;
    private int fourthMonth;
    private int fifthMonth;
    private int sixthMonth;
    private String variation;
    private char group;

    public XyzUtil() {

    }

    public XyzUtil(String name, int firstMonth, int secondMonth, int thirdMontn, int fourthMonth, int fifthMonth, int sixthMonth) {
        this.name = name;
        this.firstMonth = firstMonth;
        this.secondMonth = secondMonth;
        this.thirdMonth = thirdMontn;
        this.fourthMonth = fourthMonth;
        this.fifthMonth = fifthMonth;
        this.sixthMonth = sixthMonth;
    }

    public XyzUtil(String name, int firstMonth, int secondMonth, int thirdMontn, int fourthMonth, int fifthMonth, int sixthMonth, String variation, char group) {
        this.name = name;
        this.firstMonth = firstMonth;
        this.secondMonth = secondMonth;
        this.thirdMonth = thirdMontn;
        this.fourthMonth = fourthMonth;
        this.fifthMonth = fifthMonth;
        this.sixthMonth = sixthMonth;
        this.variation = variation;
        this.group = group;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public int getFirstMonth() {
        return firstMonth;
    }

    public void setFirstMonth(int firstMonth) {
        this.firstMonth = firstMonth;
    }

    public int getSecondMonth() {
        return secondMonth;
    }

    public void setSecondMonth(int secondMonth) {
        this.secondMonth = secondMonth;
    }

    public int getThirdMonth() {
        return thirdMonth;
    }

    public void setThirdMonth(int thirdMonth) {
        this.thirdMonth = thirdMonth;
    }

    public int getFourthMonth() {
        return fourthMonth;
    }

    public void setFourthMonth(int fourthMonth) {
        this.fourthMonth = fourthMonth;
    }

    public int getFifthMonth() {
        return fifthMonth;
    }

    public void setFifthMonth(int fifthMonth) {
        this.fifthMonth = fifthMonth;
    }

    public int getSixthMonth() {
        return sixthMonth;
    }

    public void setSixthMonth(int sixthMonth) {
        this.sixthMonth = sixthMonth;
    }

    public String getVariation() {
        return variation;
    }

    public void setVariation(String variation) {
        this.variation = variation;
    }

    public char getGroup() {
        return group;
    }

    public void setGroup(char group) {
        this.group = group;
    }
}
