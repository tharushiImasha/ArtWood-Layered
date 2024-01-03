package lk.ijse.ArtWoodLayered.controller;

import com.jfoenix.controls.JFXCheckBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.ArtWoodLayered.bo.BOFactory;
import lk.ijse.ArtWoodLayered.bo.custom.EditProfileBO;

import java.sql.SQLException;

public class ResetPwController {
    @FXML
    private AnchorPane rootNode;

    @FXML
    private JFXCheckBox chkNew;

    @FXML
    private JFXCheckBox chkVer;

    @FXML
    private PasswordField passNewPw;

    @FXML
    private PasswordField passVerPw;

    @FXML
    private TextField txtNewPw;

    @FXML
    private TextField txtVerifyPw;

    EditProfileBO editProfileBO = (EditProfileBO) BOFactory.getBoFactory().getBoo(BOFactory.BoTypes.EDIT_PROFILE);

    public void initialize() {
        txtNewPw.setVisible(false);
        txtVerifyPw.setVisible(false);
    }

    @FXML
    void btnResetOnAction(ActionEvent event) throws SQLException {

        if (passNewPw.getText().equals(passVerPw.getText())){

            String pw = passVerPw.getText();

            boolean isUpdated = editProfileBO.updatePw(pw, "admin");

             if(isUpdated){
                 new Alert(Alert.AlertType.INFORMATION, "Password Reset Successful").show();
                 Stage stage = (Stage) this.rootNode.getScene().getWindow();

                 stage.close();

             }
        } else {
            new Alert(Alert.AlertType.INFORMATION, "Password Reset not Successfully").show();
        }
    }

    String password = "";

    @FXML
    void chkShowNew(ActionEvent event) {
        if (chkNew.isSelected()){
            password = passNewPw.getText();
            txtNewPw.setText(password);

            passNewPw.setVisible(false);
            txtNewPw.setVisible(true);
        } else {
            password = txtNewPw.getText();
            passNewPw.setText(password);

            txtNewPw.setVisible(false);
            passNewPw.setVisible(true);
        }
    }

    @FXML
    void chkShowVer(ActionEvent event) {
        if (chkVer.isSelected()){
            password = passVerPw.getText();
            txtVerifyPw.setText(password);

            passVerPw.setVisible(false);
            txtVerifyPw.setVisible(true);
        } else {
            password = txtVerifyPw.getText();
            passVerPw.setText(password);

            txtVerifyPw.setVisible(false);
            passVerPw.setVisible(true);
        }
    }

}
