package com.heshanthenura.jfxresponsive;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private BorderPane root;

    @FXML
    private HBox desktopMenu;

    @FXML
    private Button menuBtn;

    @FXML
    private HBox topNav;

    @FXML
    private VBox leftNav;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        leftNav.setMinWidth(0);
        leftNav.setMaxWidth(0);
        leftNav.setVisible(false);

        mediaQuery();

        menuBtn.setOnMouseClicked(e -> {
            double newWidth = leftNav.getWidth() == 0 ? 300 : 0;
            leftNav.setMinWidth(newWidth);
            leftNav.setMaxWidth(newWidth);
            leftNav.setVisible(newWidth != 0);
        });
    }

    public void mediaQuery() {
        root.widthProperty().addListener(((observable, oldValue, newValue) -> {
            System.out.println(newValue);
            if (newValue.intValue() < 786) {
                if (topNav.getChildren().contains(desktopMenu)) {
                    topNav.getChildren().remove(desktopMenu);
                }
                if (!topNav.getChildren().contains(menuBtn)) {
                    topNav.getChildren().add(menuBtn);
                }
            } else {
                if (!topNav.getChildren().contains(desktopMenu)) {
                    topNav.getChildren().add(desktopMenu);
                }
                if (topNav.getChildren().contains(menuBtn)) {
                    topNav.getChildren().remove(menuBtn);
                }
                leftNav.setVisible(false);
            }
        }));
    }
}
