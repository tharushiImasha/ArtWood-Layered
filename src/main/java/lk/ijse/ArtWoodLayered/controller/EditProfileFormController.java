package lk.ijse.ArtWoodLayered.controller;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.ArtWoodLayered.dto.EmployeeDto;
import lk.ijse.ArtWoodLayered.dto.LoginDto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;

public class EditProfileFormController {
    public TableColumn colEmpId;
    public TableColumn colUserName;
    public TableColumn colPw;

    @FXML
    private TableView<String> tblUsers;

    @FXML
    private Label lblJob;

    @FXML
    private ComboBox<String> cmbId;

    @FXML
    private AnchorPane rootNode;

    @FXML
    private TextField txtEmpId;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUserName;

    public void initialize() {
        setCellValueFactory();
        loadAllUsers();
        setListener();
        loadEmpId();
    }

    private void loadEmpId() {

    }

    private void setCellValueFactory() {
        colEmpId.setCellValueFactory(new PropertyValueFactory<>("emp_id"));
        colUserName.setCellValueFactory(new PropertyValueFactory<>("user_name"));
        colPw.setCellValueFactory(new PropertyValueFactory<>("pw"));
    }

    private void loadAllUsers() {

    }

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) this.rootNode.getScene().getWindow();

        stage.close();
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {


    }

    private boolean validateUser() {

        return false;
    }

    private void flashBorder(TextField textField) {
        textField.setStyle("-fx-border-color: #000000;-fx-background-color: rgba(255,0,0,0.13)");
        setBorderResetAnimation(textField);
    }

    private void setBorderResetAnimation(TextField textField) {

        Timeline timeline1 = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(textField.styleProperty(), "-fx-background-color:rgba(255,0,0,0.13);-fx-border-color: rgba(128,128,128,0.38);-fx-background-radius:10;-fx-border-radius:10")),
                new KeyFrame(Duration.seconds(0.1), new KeyValue(textField.styleProperty(), "-fx-background-color: white;-fx-border-color: rgba(128,128,128,0.38);-fx-background-radius:10;-fx-border-radius:10")),
                new KeyFrame(Duration.seconds(0.2), new KeyValue(textField.styleProperty(), "-fx-background-color:rgba(255,0,0,0.13);-fx-border-color: rgba(128,128,128,0.38);-fx-background-radius:10;-fx-border-radius:10")),
                new KeyFrame(Duration.seconds(0.3), new KeyValue(textField.styleProperty(), "-fx-background-color: white;-fx-border-color: rgba(128,128,128,0.38);-fx-background-radius:10;-fx-border-radius:10")),
                new KeyFrame(Duration.seconds(0.4), new KeyValue(textField.styleProperty(), "-fx-background-color:rgba(255,0,0,0.13);-fx-border-color: rgba(128,128,128,0.38);-fx-background-radius:10;-fx-border-radius:10")),
                new KeyFrame(Duration.seconds(0.5), new KeyValue(textField.styleProperty(), "-fx-background-color: white;-fx-border-color: rgba(128,128,128,0.38);-fx-background-radius:10;-fx-border-radius:10"))
        );
        timeline1.play();
    }

    private void clearFields() {
        cmbId.setValue("");
        txtPassword.setText("");
        txtUserName.setText("");
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {


    }

    private void setListener() {

    }

    private void setFields(LoginDto dto) {
        cmbId.setValue(dto.getEmp_id());
        txtUserName.setText(dto.getUserName());
        txtPassword.setText(dto.getPw());
    }

    @FXML
    void cmbIdOnAction(ActionEvent event) throws SQLException {

    }
}
