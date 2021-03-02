package app.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class XyzController {
    @FXML
    private TableView<?> xyzTable;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colFirstMonth;

    @FXML
    private TableColumn<?, ?> colSecondMonth;

    @FXML
    private TableColumn<?, ?> colThirdMonth;

    @FXML
    private TableColumn<?, ?> colFiourthMonth;

    @FXML
    private TableColumn<?, ?> colFifthMonth;

    @FXML
    private TableColumn<?, ?> colSixthMonth;

    @FXML
    private TableColumn<?, ?> colVariation;

    @FXML
    private TableColumn<?, ?> colGroup;

    @FXML
    private Button btnShowXyz;

    public XyzController() {

    }
}
