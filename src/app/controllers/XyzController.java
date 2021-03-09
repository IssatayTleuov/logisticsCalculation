package app.controllers;

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

public class XyzController {
    @FXML
    TableView xyzTable;
    @FXML
    TableColumn colName, colFirstMonth, colSecondMonth, colThirdMonth;
    @FXML
    TableColumn colFourthMonth, colFifthMonth, colSixthMonth, colVariation, colGroup;
    @FXML
    Button btnDoCalXyz, btnPopulateTableXyz;

    ObservableList<XyzUtil> data = FXCollections.observableArrayList(
            new XyzUtil("Kingston", 115, 88, 108, 97, 117, 79),
            new XyzUtil("IBM", 100, 140, 12, 66, 99, 20),
            new XyzUtil("MSI", 20, 53, 75, 84, 63, 55),
            new XyzUtil("Samsung", 76, 56, 60, 350, 200, 76),
            new XyzUtil("Oppo", 150, 50, 60, 47, 20, 10),
            new XyzUtil("Oracle", 150, 50, 60, 47, 20, 10)
    );

    XyzUtil xyzUtil = new XyzUtil();

    public void onMouseClickShowTable(MouseEvent mouseEvent) {
        Label label = new Label("XYZ analyze calculation");
        label.setFont(new Font("Arial", 20));

        xyzTable.setEditable(true);
        btnDoCalXyz.setVisible(true);

        colName.setCellValueFactory(new PropertyValueFactory<XyzUtil, String>("name"));
        colName.setCellFactory(TextFieldTableCell.forTableColumn());
        colName.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<XyzUtil, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent event) {
                        ((XyzUtil) event.getTableView().getItems().get(
                                event.getTablePosition().getRow()
                        )).setName((String) event.getNewValue());
                    }
                }
        );

        colFirstMonth.setCellValueFactory(new PropertyValueFactory<XyzUtil, Integer>("firstMonth"));
        colFirstMonth.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Integer>() {
            @Override
            public String toString(Integer object) {
                return object != null ? object.toString() : "";
            }

            @Override
            public Integer fromString(String string) {
                return Integer.valueOf(string);
            }
        }));
        colFirstMonth.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<XyzUtil, Integer>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent event) {
                        ((XyzUtil) event.getTableView().getItems().get(
                                event.getTablePosition().getRow()
                        )).setFirstMonth((Integer) event.getNewValue());
                    }
                }
        );

        colSecondMonth.setCellValueFactory(new PropertyValueFactory<XyzUtil, Integer>("secondMonth"));
        colSecondMonth.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Integer>() {
            @Override
            public String toString(Integer object) {
                return object != null ? object.toString() : "";
            }

            @Override
            public Integer fromString(String string) {
                return Integer.valueOf(string);
            }
        }));
        colSecondMonth.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<XyzUtil, Integer>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent event) {
                        ((XyzUtil) event.getTableView().getItems().get(
                                event.getTablePosition().getRow()
                        )).setSecondMonth((Integer) event.getNewValue());
                    }
                }
        );

        colThirdMonth.setCellValueFactory(new PropertyValueFactory<XyzUtil, Integer>("thirdMonth"));
        colThirdMonth.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Integer>() {
            @Override
            public String toString(Integer object) {
                return object != null ? object.toString() : "";
            }

            @Override
            public Integer fromString(String string) {
                return Integer.valueOf(string);
            }
        }));
        colThirdMonth.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<XyzUtil, Integer>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent event) {
                        ((XyzUtil) event.getTableView().getItems().get(
                                event.getTablePosition().getRow()
                        )).setThirdMonth((Integer) event.getNewValue());
                    }
                }
        );

        colFourthMonth.setCellValueFactory(new PropertyValueFactory<XyzUtil, Integer>("fourthMonth"));
        colFourthMonth.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Integer>() {
            @Override
            public String toString(Integer object) {
                return object != null ? object.toString() : "";
            }

            @Override
            public Integer fromString(String string) {
                return Integer.valueOf(string);
            }
        }));
        colFourthMonth.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<XyzUtil, Integer>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent event) {
                        ((XyzUtil) event.getTableView().getItems().get(
                                event.getTablePosition().getRow()
                        )).setFourthMonth((Integer) event.getNewValue());
                    }
                }
        );

        colFifthMonth.setCellValueFactory(new PropertyValueFactory<XyzUtil, Integer>("fifthMonth"));
        colFifthMonth.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Integer>() {
            @Override
            public String toString(Integer object) {
                return object != null ? object.toString() : "";
            }

            @Override
            public Integer fromString(String string) {
                return Integer.valueOf(string);
            }
        }));
        colFifthMonth.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<XyzUtil, Integer>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent event) {
                        ((XyzUtil) event.getTableView().getItems().get(
                                event.getTablePosition().getRow()
                        )).setFifthMonth((Integer) event.getNewValue());
                    }
                }
        );

        colSixthMonth.setCellValueFactory(new PropertyValueFactory<XyzUtil, Integer>("sixthMonth"));
        colSixthMonth.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Integer>() {
            @Override
            public String toString(Integer object) {
                return object != null ? object.toString() : "";
            }

            @Override
            public Integer fromString(String string) {
                return Integer.valueOf(string);
            }
        }));
        colSixthMonth.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<XyzUtil, Integer>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent event) {
                        ((XyzUtil) event.getTableView().getItems().get(
                                event.getTablePosition().getRow()
                        )).setFourthMonth((Integer) event.getNewValue());
                    }
                }
        );

        colVariation.setVisible(false);
        colGroup.setVisible(false);

        xyzTable.setItems(data);
    }

    public void onMouseClickShowResult(MouseEvent mouseEvent) {
        colVariation.setVisible(true);
        colGroup.setVisible(true);

        List<Double> variations = xyzUtil.getVariationToTable(data);
        List<Character> groups = xyzUtil.sortByGroups(variations);

        for (int i = 0; i < data.size(); i++) {
            data.get(i).setVariation(variations.get(i).toString());
            data.get(i).setGroup(groups.get(i));
        }

        colVariation.setCellValueFactory(new PropertyValueFactory<XyzUtil, String>("variation"));
        colGroup.setCellValueFactory(new PropertyValueFactory<XyzUtil, Character>("group"));

        xyzTable.setItems(data);
    }
}
