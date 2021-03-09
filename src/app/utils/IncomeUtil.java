package app.utils;

import java.util.Date;

public class IncomeUtil {
    private int id;
    private int incomeMonth;
    private Date incomeDate;
    private int companyId;

    public IncomeUtil() {

    }

    public IncomeUtil(int id, int incomeMonth, Date incomeDate, int companyId) {
        this.id = id;
        this.incomeMonth = incomeMonth;
        this.incomeDate = incomeDate;
        this.companyId = companyId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIncomeMonth() {
        return incomeMonth;
    }

    public void setIncomeMonth(int incomeMonth) {
        this.incomeMonth = incomeMonth;
    }

    public Date getIncomeDate() {
        return incomeDate;
    }

    public void setIncomeDate(Date incomeDate) {
        this.incomeDate = incomeDate;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }
}
