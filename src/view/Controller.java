package view;

import controller.Statistics;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import model.Customer;


import java.io.IOException;
import java.util.Map;

public class Controller {

    private Map<String, Object> session;

    public Controller(Map<String, Object> session) {
        this.session = session;
    }


    /**
     * This is what happens when the user tries to log in
     * */
    @FXML
    public void logIn() {

        // http://stackoverflow.com/questions/34863425/javafx-scene-builder-how-switch-scene

        FXMLLoader loader = (FXMLLoader) session.get("root_loader"); // get the loader object from the session Map
        BorderPane loginRoot = loader.getRoot(); // get the login Parent
        TextField username = (TextField) loginRoot.lookup("#login_username_field");
        PasswordField password = (PasswordField) loginRoot.lookup("#login_password_field");

        String usernameAsString = username.getText();
        String passwordAsString = password.getText();

         if (usernameAsString.equals("admin") && passwordAsString.equals("root") ||
                 usernameAsString.equals("") && passwordAsString.equals("")) { // todo make a check to see if the user exists in the database and create the user object

            String email = usernameAsString + "@gmail.com";

            Customer customer = new Customer(email, "Amin Jensen", "80818103", passwordAsString);
            session.put("username", usernameAsString);
            session.put("password", passwordAsString);
            session.put("customer_object", customer);

            session.put("root_loader", loader);

            FXMLLoader mainLayoutLoader = new FXMLLoader(getClass().getResource("MainLayout.fxml"));
            mainLayoutLoader.setController(this);


            try {
                BorderPane mainParent = mainLayoutLoader.load();
                Label welcomeName = (Label) mainParent.lookup("#filmoversigt_welcome_name_field");
                welcomeName.setText(customer.getName());
                loginRoot.getScene().setRoot(mainParent);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Label loginErrorLabel = (Label) loginRoot.lookup("#login_warning_label");
            loginErrorLabel.setText("Username or password not recognized.");
        }

    }





    /**
     * when the menu item Movie Oversigt is clicked
     * We load the content from the file and set it as center of our root layout (BorderPane)
     */
    @FXML
    public void selectingFilmOversigt(MouseEvent event) {


        try {
            Button menuButtonClicked = (Button) event.getSource();
            BorderPane mainLayout = (BorderPane) menuButtonClicked.getScene().getRoot();
            session.put("main_layout", mainLayout);

            FXMLLoader filmOversigtLoader = new FXMLLoader(getClass().getResource("FilmOversigt.fxml"));
            FilmOversigtController filmOversigtController = new FilmOversigtController(session);
            filmOversigtLoader.setController(filmOversigtController);
            BorderPane filmOversigtBorderPane = filmOversigtLoader.load();

            mainLayout.setCenter(filmOversigtBorderPane);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    @FXML
    public void selectingAdmin(MouseEvent event) {
        try {

            Button menuButtonClicked = (Button) event.getSource();
            BorderPane mainLayout = (BorderPane) menuButtonClicked.getScene().getRoot();

            FXMLLoader adminLoader = new FXMLLoader(getClass().getResource("Admin.fxml"));
            adminLoader.setController(this);
            FlowPane adminFlowPane = adminLoader.load();

            mainLayout.setCenter(adminFlowPane);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    @FXML
    public void selectingStatistik(MouseEvent event) {
        try {
            Button menuButtonClicked = (Button) event.getSource();
            BorderPane mainLayout = (BorderPane) menuButtonClicked.getScene().getRoot();

            FXMLLoader statistikLoader = new FXMLLoader(getClass().getResource("Statistik.fxml"));
            Controller controller = new Controller(session);  // Controller will act as a placeholder cause it needs to set a controller
            statistikLoader.setController(controller);
            TabPane statistikTabPane = statistikLoader.load();

            mainLayout.setCenter(statistikTabPane);

            PieChart pieChart = (PieChart) mainLayout.lookup("#statistik_piechart");
            Statistics.fillPieChartWithData(pieChart);


            BarChart barChart = (BarChart) mainLayout.lookup("#statistik_barchart");
            Statistics.fillBarChartWithData(barChart);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @FXML
    public void selectingKontakt(MouseEvent event) {
        try {

            Button menuButtonClicked = (Button) event.getSource();
            BorderPane mainLayout = (BorderPane) menuButtonClicked.getScene().getRoot();

            FXMLLoader kontaktLoader = new FXMLLoader(getClass().getResource("Kontakt.fxml"));
            Controller controller = new Controller(session);  // Controller will act as a placeholder cause it needs to set a controller
            kontaktLoader.setController(controller);
            BorderPane kontaktBorderPane = kontaktLoader.load();

            mainLayout.setCenter(kontaktBorderPane);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @FXML
    public void logout(MouseEvent event) {
        try {

            Button menuButtonClicked = (Button) event.getSource();
            BorderPane mainLayout = (BorderPane) menuButtonClicked.getScene().getRoot();

            FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
            loginLoader.setController(this);
            BorderPane loginBorderPane = loginLoader.load();

            session.put("root_loader", loginLoader);

            mainLayout.getScene().setRoot(loginBorderPane);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This is thank you for the purchase massage when the reserver or godkend betaling button has been pressed in the process payment window
     * @param event
     */
    @FXML
    public void seatReserved(MouseEvent event) {
        try {

            Button menuButtonClicked = (Button) event.getSource();
            BorderPane mainLayout = (BorderPane) menuButtonClicked.getScene().getRoot();

            FXMLLoader paymentDoneLoader = new FXMLLoader(getClass().getResource("PaymentProcessed.fxml"));
            Controller controller = new Controller(session);  // Controller will act as a placeholder cause it needs to set a controller
            paymentDoneLoader.setController(controller);
            BorderPane paymentDoneBorderPane = paymentDoneLoader.load();

            mainLayout.setCenter(paymentDoneBorderPane);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }



}