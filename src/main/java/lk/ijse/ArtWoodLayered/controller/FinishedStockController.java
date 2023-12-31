package lk.ijse.ArtWoodLayered.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class FinishedStockController {
    @FXML
    private ComboBox<String> cmbProductId;

    @FXML
    private TableColumn<?, ?> colAction;

    @FXML
    private Label lblId;

    @FXML
    private TableColumn<?, ?> colAmountId;

    @FXML
    private TableColumn<?, ?> colFinishedId;

    @FXML
    private TableColumn<?, ?> colProductId;

    @FXML
    private AnchorPane rootNode;

    @FXML
    private TableView<String> tblFinished;
}
