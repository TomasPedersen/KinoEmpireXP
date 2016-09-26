package model;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.util.Map;

public interface Session {

    Map<String, Object> session = null;

    FXMLLoader root_loader = null;

    Customer customer_object = null;

    String username = null;

    String password = null;

    BorderPane main_layout = null;

}
