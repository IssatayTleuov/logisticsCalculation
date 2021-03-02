package app.utils;

public class AbcUtil {

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
