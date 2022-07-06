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

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

public class AdminDashboardFormController implements Initializable {
    public AnchorPane mainContext;
    public AnchorPane adminContext;
    public Label lblName;
    public Label lblDate;
    public Label lblTime;


    public void initialize() throws IOException {
        mainContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/IncomeChartForm.fxml"));
        mainContext.getChildren().add(parent);
        //loadDateAndTime();

    }

    public void btnIncomeOnAction(ActionEvent actionEvent) throws IOException {
        mainContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/IncomeChartForm.fxml"));
        mainContext.getChildren().add(parent);
    }


    public void btnMostMovableItemOnAction(ActionEvent actionEvent) throws IOException {
        mainContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/MostMovableItemForm.fxml"));
        mainContext.getChildren().add(parent);
    }

    public void btnLeastMovableItemOnAction(ActionEvent actionEvent) throws IOException {
        mainContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/LeastMovableItemForm.fxml"));
        mainContext.getChildren().add(parent);
    }

    public void btnManageItemsOnAction(ActionEvent actionEvent) throws IOException {
        mainContext.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../view/ManageItemForm.fxml"));
        mainContext.getChildren().add(parent);
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
        Stage stag=(Stage) adminContext.getScene().getWindow();
        stag.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/AdminAndUserLoginForm.fxml"))));
        stag.centerOnScreen();

        }
    }


