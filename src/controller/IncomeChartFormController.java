package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class IncomeChartFormController {
    public AnchorPane incomeContext;
    public AreaChart DailyIncomeChart;
    public AreaChart MonthlyIncomeChart;
    public AreaChart AnnuallyIncomeChart;
    public Label lblName;

    public void backOnMouseClicked(MouseEvent mouseEvent) throws IOException {
        setUi("AdminAndUserLoginForm");
    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) incomeContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
        stage.centerOnScreen();
    }
}
