package app.database;

import app.utils.AbcUtil;
import app.utils.CompanyUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class IncomeDao extends MainDao {
    Connection connection;

    public boolean addIncome(int incomeMonth, Date incomeDate, int companyId) {
        connection = getConnection();
        boolean isAdded = false;
        try {
            PreparedStatement preparedStatement= connection.prepareStatement("INSERT INTO income (income_month, income_date, company_id) VALUES (?, ?, ?)");
            preparedStatement.setInt(1, incomeMonth);
            preparedStatement.setDate(2, incomeDate);
            preparedStatement.setInt(3, companyId);
            int row = preparedStatement.executeUpdate();
            if (row == 1) {
                System.out.println("Income was successfully inserted!");
                isAdded = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAdded;
    }

    public ObservableList<AbcUtil> getProfit(Date beginDate, Date endDate, List<CompanyUtil> companyIds) {
        connection = getConnection();
        ObservableList<AbcUtil> result = FXCollections.observableArrayList();

        try {
            for (int i = 0; i < companyIds.size(); i++) {
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT SUM(income_month) FROM income WHERE income_date BETWEEN ? AND ? GROUP BY company_id = ?");
                preparedStatement.setDate(1, beginDate);
                preparedStatement.setDate(2, endDate);
                preparedStatement.setInt(3, companyIds.get(i).getId());

                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    AbcUtil abcUtil = new AbcUtil();
                    abcUtil.setProfit(resultSet.getInt(1));
                    abcUtil.setName(companyIds.get(i).getCompanyName());

                    result.add(abcUtil);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

