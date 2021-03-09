package app.database;

import app.utils.CompanyUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CompanyDao extends MainDao {
    Connection connection;

    public void addCompany(String companyName) {
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO company(company_name) VALUES (?)");
            preparedStatement.setString(1, companyName);
            int row = preparedStatement.executeUpdate();
            if (row == 1) {
                System.out.println("Date inserted successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<CompanyUtil> getAllCompanies() {
        connection = getConnection();
        List<CompanyUtil> companyUtils = new ArrayList<>();

     try {
         PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM company");
         ResultSet resultSet = preparedStatement.executeQuery();

         while(resultSet.next()) {
             CompanyUtil companyUtil = new CompanyUtil();
             companyUtil.setId(resultSet.getInt(1));
             companyUtil.setCompanyName(resultSet.getString(2));

             companyUtils.add(companyUtil);
         }

     } catch (Exception e) {
         e.printStackTrace();
     }

     return companyUtils;
    }
}
