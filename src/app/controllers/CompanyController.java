package app.controllers;

import app.database.CompanyDao;
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
import java.util.Objects;

public class CompanyController {
    @FXML
    TextField textFieldEnterCompany;
    @FXML
    Button btnAdd, btnBack;

    CompanyDao companyDao = new CompanyDao();

    public void onAddButtonClick(MouseEvent mouseEvent) {
        String companyName = textFieldEnterCompany.getText();
        if (companyName.equals("")) {
            System.out.println("Please enter company name!");

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

        } else {
            companyDao.addCompany(companyName);
            textFieldEnterCompany.clear();

            Stage popup = new Stage();
            popup.initModality(Modality.APPLICATION_MODAL);
            popup.setTitle("Popup");

            Label label = new Label("Company name was saved!");

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
