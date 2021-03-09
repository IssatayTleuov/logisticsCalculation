package app.utils;

import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class AbcUtil {

    private int id;
    private String name;
    private int profit;
    private String share;
    private String totalShare;
    private char group;

    public AbcUtil() {

    }

    public AbcUtil (String name, int profit) {
        this.name = name;
        this.profit = profit;
    }

    public AbcUtil(String name, int profit, String share, String totalShare, char group) {
        this.name = name;
        this.profit = profit;
        this.share = share;
        this.totalShare = totalShare;
        this.group = group;
    }

    public AbcUtil (int id, String name, int profit) {
        this.id = id;
        this.name = name;
        this.profit = profit;
    }

    public AbcUtil(int id, String name, int profit, String share, String totalShare, char group) {
        this.id = id;
        this.name = name;
        this.profit = profit;
        this.share = share;
        this.totalShare = totalShare;
        this.group = group;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSumOfNumbers(ObservableList<AbcUtil> array) {
        int sum = 0;

        for (AbcUtil n : array) {
            sum = sum + n.getProfit();
        }

        return sum;
    }

    public List<Integer> getShareForTable(ObservableList<AbcUtil> array, int sum) {
        List<Integer> result = new ArrayList<>();

        for (AbcUtil number : array) {
            int share = (number.getProfit() * 100) /sum;
            result.add(share);
        }

        return result;
    }

    public List<Integer> getTotalShareForTable(List<Integer> share) {
        List<Integer> result = new ArrayList<>();
        int current = 0;

        for (int i = 0; i < share.size(); i++) {
            int totalShare = current + share.get(i);
            result.add(totalShare);
            current = totalShare;
        }

        return result;
    }


    public List<Character> getGroupForTable(List<Integer> array) {
        List<Character> result = new ArrayList<>();

        for (Integer totalShare : array) {
            if (totalShare <= 80) {
                result.add('A');
            } else if (totalShare <= 95) {
                result.add('B');
            } else {
                result.add('C');
            }
        }

        return result;
    }

//  methods to work with database
    public void getShareForTableTest(ObservableList<AbcUtil> array, int sum) {
        for (AbcUtil n : array) {
            int share = ((n.getProfit() * 100)) / sum;
            String strShare = String.valueOf(share);
            n.setShare(strShare);
        }
    }

    public void getTotalShareForTableTest(ObservableList<AbcUtil> array) {
        int current = 0;

        for (int i = 0; i < array.size(); i++) {
            int totalShare = current + Integer.parseInt(array.get(i).getShare());
            String strTotal = String.valueOf(totalShare);
            array.get(i).setTotalShare(strTotal);
            current = totalShare;
        }
    }

    public void getGroupForTableTest(ObservableList<AbcUtil> array) {

        for (AbcUtil n : array) {
            int totalShare = Integer.parseInt(n.getTotalShare());
            if (totalShare <= 80) {
                n.setGroup('A');
            } else if (totalShare <= 95) {
                n.setGroup('B');
            } else {
                n.setGroup('C');
            }
        }

    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public String getShare() {
        return share;
    }

    public void setShare(String share) {
        this.share = share;
    }

    public String getTotalShare() {
        return totalShare;
    }

    public void setTotalShare(String totalShare) {
        this.totalShare = totalShare;
    }

    public char getGroup() {
        return group;
    }

    public void setGroup(char group) {
        this.group = group;
    }
}
