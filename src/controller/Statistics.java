package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.*;

public class Statistics {

    // Nicked from here
    // http://java-buddy.blogspot.dk/2012/05/create-piechart-using-javafx-and-fxml.html
    public static void fillPieChartWithData(PieChart pieChart) {

        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("January", 100),
                new PieChart.Data("February", 200),
                new PieChart.Data("March", 50),
                new PieChart.Data("April", 75),
                new PieChart.Data("May", 110),
                new PieChart.Data("June", 300),
                new PieChart.Data("July", 111),
                new PieChart.Data("August", 30),
                new PieChart.Data("September", 75),
                new PieChart.Data("October", 55),
                new PieChart.Data("November", 99),
                new PieChart.Data("December", 225));

        pieChart.setData(pieChartData);
        pieChart.setTitle("Tickets Sold");
    }

    // Oracle himself taught me this
    // http://docs.oracle.com/javafx/2/charts/bar-chart.htm
    public static void fillBarChartWithData(BarChart barChart) {

        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();

        xAxis.setLabel("Sales Person");
        yAxis.setLabel("Profit made");

        XYChart.Series series = new XYChart.Series();
        series.setName("2016");
        series.getData().add(new XYChart.Data("Samuel", 25601.34));
        series.getData().add(new XYChart.Data("Charles", 20148.82));
        series.getData().add(new XYChart.Data("Lewis", 10000));
        series.getData().add(new XYChart.Data("Arthur", 35407.15));
        series.getData().add(new XYChart.Data("Aleister", 12000));


        barChart.getData().addAll(series);
        barChart.setTitle("Profit");
    }

}
