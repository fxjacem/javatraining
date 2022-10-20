package com.example.hellofx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private WebView webView;

    @FXML
    private TextField textField;

    @FXML
    private WebEngine engine;

    private String homePage;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        engine = webView.getEngine();
        homePage = "www.google.com";
        textField.setText(homePage);

        loadPage();
    }

    public void loadPage() {
        engine.load("https://" + textField.getText());

    }

    public void refreshPage() {
        engine.reload();
    }
}
