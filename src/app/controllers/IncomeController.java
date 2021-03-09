package app.controllers;

import app.DateConverter;
import app.database.CompanyDao;
import app.database.IncomeDao;
import app.utils.CompanyUtil;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class IncomeController {
    @FXML
    TextField textFieldEnterCompany, textFieldEnterIncome, textFieldEnterDate;
    @FXML
    Button btnAdd, btnBack;

    DateConverter dateConverter = new DateConverter();
    CompanyDao companyDao = new CompanyDao();
    IncomeDao incomeDao = new IncomeDao();

    public void onAddButtonClick(MouseEvent mouseEvent) {
        String strCompany = textFieldEnterCompany.getText();
        String strIncome = (textFieldEnterIncome.getText());
        String strDate = textFieldEnterDate.getText();

        if (strCompany.equals("") || strIncome.equals("") || strDate.equals("")) {
            textFieldEnterCompany.clear();
            textFieldEnterIncome.clear();
            textFieldEnterDate.clear();

            getErrorPopup();

        } else {

            int income = Integer.parseInt(strIncome);
            Date date = dateConverter.convertString(strDate);
            java.sql.Date dateSql = dateConverter.convertToDateSql(date);
            int companyId = 0;
            List<CompanyUtil> companyUtils = companyDao.getAllCompanies();
            for (CompanyUtil comp : companyUtils) {
                if (comp.getCompanyName().equals(strCompany)) {
                    companyId = comp.getId();
                }
            }

            boolean isAdded = incomeDao.addIncome(income, dateSql, companyId);

            if (isAdded) {
                getPopup();
            } else {
                getErrorPopup();
            }

            textFieldEnterCompany.clear();
            textFieldEnterIncome.clear();
            textFieldEnterDate.clear();

        }
    }

    public void onBackButtonClick(MouseEvent mouseEvent) {
        try {
            Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("app/fxml/main_menu.fxml")));
            Scene scene = new Scene(root);
            stage.setTitle("Main menu");
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getPopup() {
        Stage popup = new Stage();
        popup.initModality(Modality.APPLICATION_MODAL);
        popup.setTitle("Popup");

        Label label = new Label("Company income was saved!");

        Button button = new Button("Close");
        button.setOnAction(e -> popup.close());

        VBox vBox = new VBox(10);

        vBox.getChildren().addAll(label, button);
        vBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vBox, 300, 250);

        popup.setScene(scene);
        popup.showAndWait();
    }

    public static void getErrorPopup() {
        Stage popup = new Stage();
        popup.initModality(Modality.APPLICATION_MODAL);
        popup.setTitle("Popup");

        Label label = new Label("Please enter company name!");

        Button button = new Button("Close");
        button.setOnAction(e -> popup.close());

        VBox vBox = new VBox(10);

        vBox.getChildren().addAll(label, button);
        vBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vBox, 300, 250);

        popup.setScene(scene);
        popup.showAndWait();
    }

}
