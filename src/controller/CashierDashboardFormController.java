package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.security.auth.login.LoginContext;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

public class CashierDashboardFormController implements Initializable {
    public AnchorPane cashierContext;
    public AnchorPane mainCashierContext;
    public Label lblTime;
    public Label lblDate;
    public Label lblName;


    public void initialize() throws IOException {
        mainCashierContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/ManageCustomerForm.fxml"));
        mainCashierContext.getChildren().add(parent);
        //loadDateAndTime();

    }


    public void btnPlaceOrderOnAction(ActionEvent actionEvent) throws IOException {
        mainCashierContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/PlaceOrderForm.fxml"));
        mainCashierContext.getChildren().add(parent);
    }

    public void btnManageCustomerOnAction(ActionEvent actionEvent) throws IOException {
        mainCashierContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/ManageCustomerForm.fxml"));
        mainCashierContext.getChildren().add(parent);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        RunningTime();
        lblDate.setText(setDate());
    }


    private void RunningTime() {
        final Thread thread = new Thread(() -> {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("h:mm:ss aa ");
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                final String times = simpleDateFormat.format(new Date());
                Platform.runLater(() -> {
                    lblTime.setText(times);
                });
            }
        });
        thread.start();

    }

    private String setDate() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyy");
        String stDate = formatter.format(date);
        return stDate;
    }

    public void btnLogOutOnAction(ActionEvent actionEvent) throws IOException {
        Stage stag=(Stage) cashierContext.getScene().getWindow();
        stag.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/AdminAndUserLoginForm.fxml"))));
        stag.centerOnScreen();
    }

}

