package lk.ijse.ArtWoodLayered.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.ArtWoodLayered.bo.BOFactory;
import lk.ijse.ArtWoodLayered.bo.custom.FinanceBO;
import lk.ijse.ArtWoodLayered.bo.custom.SalaryBO;
import lk.ijse.ArtWoodLayered.dto.SalaryDto;
import lk.ijse.ArtWoodLayered.dto.tm.SalaryTm;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class OwnerFinanceController {
    @FXML
    private TableColumn<?, ?> colAmount;

    @FXML
    private TableColumn<?, ?> colEmpId;

    @FXML
    private TableColumn<?, ?> colSalaryId;

    @FXML
    private Label lblCard;

    @FXML
    private Label lblCash;

    @FXML
    private TableView<SalaryTm> tblFinance;

    @FXML
    private AnchorPane rootNode;

    FinanceBO financeBO = (FinanceBO) BOFactory.getBoFactory().getBoo(BOFactory.BoTypes.FINANCE);
    SalaryBO salaryBO = (SalaryBO) BOFactory.getBoFactory().getBoo(BOFactory.BoTypes.SALARY);


    @FXML
    void salaryOnAction(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/salaryForm.fxml"));

        Scene scene = new Scene(rootNode);
        Stage stage = new Stage();

        stage.setTitle("Salary Form");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public void initialize() throws SQLException {
        setCellValueFactory();
        loadAllUsers();
        loadCash();
        loadCard();
    }

    private void setCellValueFactory() {
        colEmpId.setCellValueFactory(new PropertyValueFactory<>("emp_id"));
        colAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        colSalaryId.setCellValueFactory(new PropertyValueFactory<>("salary_id"));
    }

    private void loadAllUsers() {
        ObservableList<SalaryTm> obList = FXCollections.observableArrayList();

        try {
            List<SalaryDto> dtoList;
            dtoList = salaryBO.getAllSalary();

            for(SalaryDto dto : dtoList) {
                obList.add(new SalaryTm(dto.getSalary_id(), dto.getAmount(), dto.getEmp_id()));
            }

            tblFinance.setItems(obList);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadCash() throws SQLException {
         double amount = financeBO.loadCash("cash");
         lblCash.setText(String.valueOf(amount));

    }

    private void loadCard() throws SQLException {
        double amount = financeBO.loadCard("card");
        lblCard.setText(String.valueOf(amount));

    }

}
