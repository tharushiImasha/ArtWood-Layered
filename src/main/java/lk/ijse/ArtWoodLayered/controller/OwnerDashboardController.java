package lk.ijse.ArtWoodLayered.controller;


import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.ArtWoodLayered.bo.BOFactory;
import lk.ijse.ArtWoodLayered.bo.custom.*;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OwnerDashboardController {

    public Label lblUser;
    public Label lblJobRole;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblTime;

    @FXML
    private Label lblFinished;

    @FXML
    private Label lblLogs;

    @FXML
    private Label lblPending;

    @FXML
    private Label lblWood;

    @FXML
    private Pane rosewoodEnough;

    @FXML
    private Pane rosewoodLow;

    @FXML
    private Pane teakEnough;

    @FXML
    private Pane teakLow;

    @FXML
    private AnchorPane rootNode;

    WoodPiecesStockBO woodPiecesStockBO = (WoodPiecesStockBO) BOFactory.getBoFactory().getBoo(BOFactory.BoTypes.WOOD_PIECES);
    FinishedStockBO finishedStockBO = (FinishedStockBO) BOFactory.getBoFactory().getBoo(BOFactory.BoTypes.FINISHED_STOCK);
    LogStockBO logStockBO = (LogStockBO) BOFactory.getBoFactory().getBoo(BOFactory.BoTypes.LOGS);
    PendingStockBO pendingStockBO = (PendingStockBO) BOFactory.getBoFactory().getBoo(BOFactory.BoTypes.PENDING_STOCK);
    EmployeeBO employeeBO = (EmployeeBO) BOFactory.getBoFactory().getBoo(BOFactory.BoTypes.EMPLOYEE);

    @FXML
    void btnEditProfileOnAction(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/edit_profile_form.fxml"));

        Scene scene = new Scene(rootNode);

        Stage stage = new Stage();

        stage.setTitle("Edit Profiles");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public void initialize() throws SQLException {
        generateTime();
        getLog();
        getWood();
        getPending();
        getFinished();
        getName();

        rosewoodEnough.setVisible(false);
        rosewoodLow.setVisible(false);
        teakEnough.setVisible(false);
        teakLow.setVisible(false);

        roseWoodStock();
        teakWoodStock();

    }

    public void generateTime(){
        lblDate.setText(LocalDate.now().toString());
        Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");
            lblTime.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void getLog() throws SQLException {
       int amount =  logStockBO.getLogCount();
       lblLogs.setText(String.valueOf(amount));
    }

    private void getWood() throws SQLException {
        int amount =  woodPiecesStockBO.getWoodCount();
        lblWood.setText(String.valueOf(amount));
    }

    private void getPending() throws SQLException {
        int amount =  pendingStockBO.getPendingCount();
        lblPending.setText(String.valueOf(amount));
    }

    private void getFinished() throws SQLException {
        int amount =  finishedStockBO.getFinishedCount();
        lblFinished.setText(String.valueOf(amount));
    }

    private void roseWoodStock() throws SQLException {
        int amount =  woodPiecesStockBO.getWoodCountByType("Rosewood");
        if (amount < 10){
            rosewoodLow.setVisible(true);
            rosewoodEnough.setVisible(false);
        }else {
            rosewoodLow.setVisible(false);
            rosewoodEnough.setVisible(true);
        }
    }

    private void teakWoodStock() throws SQLException {
        int amount =  woodPiecesStockBO.getWoodCountByType("Teak");
        if (amount < 10){
            teakLow.setVisible(true);
            teakEnough.setVisible(false);
        }else {
            teakLow.setVisible(false);
            teakEnough.setVisible(true);
        }
    }

    private void getName() throws SQLException {
        String name = employeeBO.getName("owner");
        lblUser.setText(name);
    }

}
