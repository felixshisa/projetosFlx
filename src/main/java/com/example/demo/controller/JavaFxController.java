package com.example.demo.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class JavaFxController {

    @FXML
    private Label label;

    @FXML
    private Button button;

    public void onButtonClick() {
        this.label.setText("Hello from JavaFX!");
    }
}
