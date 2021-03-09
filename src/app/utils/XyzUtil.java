package app.utils;

import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

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

    public List<Double>  getVariationToTable(ObservableList<XyzUtil> xyzUtils) {
        List<Double> result = new ArrayList<>();

        for (XyzUtil x : xyzUtils ) {
            double arithmetic = (double) (x.getFirstMonth() + x.getSecondMonth()
                    + x.getThirdMonth() + x.getFourthMonth() + x.getFifthMonth() + x.getSixthMonth()) / 6;
            double preSigma =    (Math.pow((x.getFirstMonth() - arithmetic), 2) + Math.pow((x.getSecondMonth() - arithmetic), 2) + Math.pow((x.getThirdMonth() - arithmetic), 2) +
                    Math.pow((x.getFourthMonth() - arithmetic), 2) + Math.pow((x.getFifthMonth() - arithmetic), 2) + Math.pow((x.getSixthMonth() - arithmetic), 2)) / 6;
            double sigma = Math.sqrt(preSigma);
            double variation = sigma / arithmetic;
            result.add(variation);
        }
        return result;
    }

    public List<Character> sortByGroups(List<Double> variations) {
        List<Character> result = new ArrayList<>();

        for (Double  number : variations) {
            if (number >= 0 && number <= 0.1) {
                result.add('X');
            } else if (number >= 0.1 && number <= 0.25) {
                result.add('Y');
            } else if (number >= 0.25 && number <= 1) {
                result.add('Z');
            }
        }

        return result;
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
