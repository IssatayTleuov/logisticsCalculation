package app.controllers;

import app.utils.AbcUtil;
import app.utils.XyzUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.util.StringConverter;

import java.util.List;


public class AbcController {
    @FXML
    TableView abcTable;
    @FXML
    TableColumn colName, colProfit, colShare, colTotalShare, colGroup;
    @FXML
    Button btnDoCalAbc, btnPopulateTableAbc;

    ObservableList<AbcUtil> data = FXCollections.observableArrayList(
            new AbcUtil("Samsung", 400),
            new AbcUtil("Lenovo", 320),
            new AbcUtil("Apple", 234),
            new AbcUtil("HP", 154),
            new AbcUtil("HyperPC", 120),
            new AbcUtil("IGM", 90),
            new AbcUtil("Miniso", 78),
            new AbcUtil("Google", 76),
            new AbcUtil("Yandex", 60),
            new AbcUtil("Microsoft", 43),
            new AbcUtil("Git", 32),
            new AbcUtil("Oracle", 25),
            new AbcUtil("FBI", 20),
            new AbcUtil("Marvel", 16),
            new AbcUtil("DC", 10)
    );

    AbcUtil abcUtil = new AbcUtil();

    public void onMouseClickShowTable(MouseEvent mouseEvent) {
        Label label = new Label("ABC analyze calculation");
        label.setFont(new Font("Arial", 20));

        abcTable.setEditable(true);
        btnDoCalAbc.setVisible(true);

        colName.setCellValueFactory(new PropertyValueFactory<AbcUtil, String>("name"));
        colName.setCellFactory(TextFieldTableCell.forTableColumn());
        colName.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<AbcUtil, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent event) {
                        ((AbcUtil) event.getTableView().getItems().get(
                                event.getTablePosition().getRow()
                        )).setName((String) event.getNewValue());
                    }
                }
        );

        colProfit.setCellValueFactory(new PropertyValueFactory<AbcUtil, Integer>("profit"));
        colProfit.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Integer>() {
            @Override
            public String toString(Integer object) {
                return object != null ? object.toString() : "";
            }

            @Override
            public Integer fromString(String string) {
                return Integer.valueOf(string);
            }
        }));
        colProfit.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<AbcUtil, Integer>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent event) {
                        ((AbcUtil) event.getTableView().getItems().get(
                                event.getTablePosition().getRow()
                        )).setProfit((Integer) event.getNewValue());
                    }
                }
        );

        colShare.setVisible(false);
        colTotalShare.setVisible(false);
        colGroup.setVisible(false);

        abcTable.setItems(data);
    }

    public void onMouseClickShowResult(MouseEvent mouseEvent) {
        colShare.setVisible(true);
        colTotalShare.setVisible(true);
        colGroup.setVisible(true);

        int sum = abcUtil.getSumOfNumbers(data);
        List<Integer> shares = abcUtil.getShareForTable(data, sum);
        List<Integer> totalShares = abcUtil.getTotalShareForTable(shares);
        List<Character> groups = abcUtil.getGroupForTable(totalShares);

        for (int i = 0; i < data.size(); i++) {
            data.get(i).setShare(shares.get(i).toString() + "%");
            data.get(i).setTotalShare(totalShares.get(i).toString() + "%");
            data.get(i).setGroup(groups.get(i));
        }

        colShare.setCellValueFactory(new PropertyValueFactory<XyzUtil, String>("share"));
        colTotalShare.setCellValueFactory(new PropertyValueFactory<XyzUtil, String>("totalShare"));
        colGroup.setCellValueFactory(new PropertyValueFactory<XyzUtil, Character>("group"));

        abcTable.setItems(data);

    }
}
