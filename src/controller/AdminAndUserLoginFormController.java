package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminAndUserLoginFormController {

    public AnchorPane LogInContext;
    public TextField txtAdminName;
    public PasswordField pwdAdminPassword;
    public TextField txtCashierName;
    public PasswordField pwdUserPassword;
    public Label lblName;
    public Label lblWelcomeBack;
    public Label lblPleaseLogintoview;

    public void logInAdminOnAction(ActionEvent actionEvent) throws IOException {
        setUi("AdminDashboardForm");
    }

    public void logInCashierOnAction(ActionEvent actionEvent) throws IOException {
        setUi("CashierDashboardForm");
    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) LogInContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
        stage.centerOnScreen();
    }


}
