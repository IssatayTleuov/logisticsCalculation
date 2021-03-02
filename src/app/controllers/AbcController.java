package app.controllers;

import app.utils.AbcUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class AbcController {
    @FXML
    private TableView<AbcUtil> abcTable;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colProfit;

    @FXML
    private TableColumn<?, ?> colShare;

    @FXML
    private TableColumn<?, ?> colTotalShare;

    @FXML
    private TableColumn<?, ?> colGroup;

    @FXML
    private Button btnShowAbc;

}
