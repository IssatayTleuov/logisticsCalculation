package app.controllers;

import app.DateConverter;
import app.database.CompanyDao;
import app.database.IncomeDao;
import app.utils.AbcUtil;
import app.utils.CompanyUtil;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class AbcTestController {
    @FXML
    TextField textFieldBeginDate, textFieldEndDate;
    @FXML
    Button btnPopulate, btnShowResult, btnBack, btnDelete;
    @FXML
    ComboBox comboBoxCompany;
    @FXML
    ListView listViewCompany;

    AbcUtil abcUtil = new AbcUtil();
    CompanyDao companyDao = new CompanyDao();
    IncomeDao incomeDao = new IncomeDao();
    DateConverter dateConverter = new DateConverter();
    ObservableList<String> companies = FXCollections.observableArrayList();
    ObservableList<String> inputListView = FXCollections.observableArrayList();

    public void onPopulateButtonClick(MouseEvent mouseEvent) {
        List<CompanyUtil> companyUtils = companyDao.getAllCompanies();

        for (CompanyUtil comp : companyUtils) {
            companies.add(comp.getCompanyName());
        }
        listViewCompany.setItems(inputListView);
        comboBoxCompany.setItems(companies);
        comboBoxCompany.setOnAction(event -> inputListView.add(comboBoxCompany.getValue().toString()));

        MultipleSelectionModel<String> multipleSelectionModel = listViewCompany.getSelectionModel();
        multipleSelectionModel.selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                btnDelete.setOnAction(event -> inputListView.remove(newValue));
            }
        });

    }

    public void onShowButtonClick(MouseEvent mouseEvent) {

        String strBeginDate = textFieldBeginDate.getText();
        String strEndDate = textFieldEndDate.getText();

        if (!strBeginDate.equals("") || !strEndDate.equals("") || inputListView.size() != 0) {

            List<CompanyUtil> companyUtils = companyDao.getAllCompanies();
            List<CompanyUtil> sortedCompanies = new ArrayList<>();

            for (int i = 0; i < inputListView.size(); i++) {
                for (int j = 0; j < companyUtils.size(); j++) {
                    if (inputListView.get(i).equals(companyUtils.get(j).getCompanyName())) {
                        sortedCompanies.add(companyUtils.get(j));
                        break;
                    }
                }
            }

            Date beginDate = dateConverter.convertString(strBeginDate);
            Date endDate = dateConverter.convertString(strEndDate);
            java.sql.Date beginDateSql = dateConverter.convertToDateSql(beginDate);
            java.sql.Date endDateSql = dateConverter.convertToDateSql(endDate);
            ObservableList<AbcUtil> data = FXCollections.observableArrayList(incomeDao.getProfit(beginDateSql, endDateSql, sortedCompanies));

            int sum = abcUtil.getSumOfNumbers(data);
            abcUtil.getShareForTableTest(data, sum);
            abcUtil.getTotalShareForTableTest(data);
            abcUtil.getGroupForTableTest(data);

            Stage tablePopup = new Stage();
            Scene scene = new Scene(new Group());
            TableView<AbcUtil> tableView = new TableView<>();

            tablePopup.initModality(Modality.APPLICATION_MODAL);
            tablePopup.setTitle("ABC analysis result");

            tableView.setEditable(true);

            Button button = new Button("Close");
            button.setOnAction(e -> tablePopup.close());

            TableColumn nameColumn = new TableColumn("Company Name");
            nameColumn.setMinWidth(100);
            nameColumn.setCellValueFactory(new PropertyValueFactory<AbcUtil, String>("name"));

            TableColumn profitColumn = new TableColumn("Profit");
            profitColumn.setMinWidth(200);
            profitColumn.setCellValueFactory(new PropertyValueFactory<AbcUtil, Integer>("profit"));
            profitColumn.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Integer>() {

                @Override
                public String toString(Integer object) {
                    return object != null ? object.toString() : "";
                }

                @Override
                public Integer fromString(String string) {
                    return Integer.valueOf(string);
                }
            }));

            TableColumn shareColumn = new TableColumn("Share");
            shareColumn.setMinWidth(100);
            shareColumn.setCellValueFactory(new PropertyValueFactory<AbcUtil, String>("share"));
            TableColumn totalShareColumn = new TableColumn("Total share");
            totalShareColumn.setMinWidth(100);
            totalShareColumn.setCellValueFactory(new PropertyValueFactory<AbcUtil, String>("totalShare"));

            TableColumn groupColumn = new TableColumn("Group");
            groupColumn.setMinWidth(100);
            groupColumn.setCellValueFactory(new PropertyValueFactory<AbcUtil, String>("group"));

            tableView.setItems(data);
            tableView.getColumns().addAll(nameColumn, profitColumn, shareColumn, totalShareColumn, groupColumn);

            VBox vBox = new VBox(5);
            vBox.setPadding(new Insets(10, 10, 10, 10));
            vBox.getChildren().addAll(tableView, button);

            ((Group) scene.getRoot()).getChildren().addAll(vBox);

            tablePopup.setScene(scene);
            tablePopup.showAndWait();

        } else {
            Stage popup = new Stage();
            popup.initModality(Modality.APPLICATION_MODAL);
            popup.setTitle("Popup");

            Label label = new Label("Please,fill in all the text fields!");

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
}

