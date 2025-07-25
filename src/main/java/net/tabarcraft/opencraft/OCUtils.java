package net.tabarcraft.opencraft;


import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import javax.swing.*;
import java.io.File;
import java.io.InputStream;
import java.net.URL;

public class OCUtils {
    public static void showAlert(Alert.AlertType type, String title, String headerText, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(message);

        DialogPane dialogPane = alert.getDialogPane();

        // ⚠️ Met à jour le chemin absolu vers ton fichier craftion.css
        applyCSS(dialogPane.getScene());

        alert.showAndWait();
    }
    // CraftionUtils.java
    public static boolean showAlertBool(Alert.AlertType type, String title, String headerText, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(message);

        // Boutons personnalisés
        ButtonType yes = new ButtonType("Oui");
        ButtonType no = new ButtonType("Annuler", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(yes, no);

        DialogPane dialogPane = alert.getDialogPane();

        // ⚠️ Met à jour le chemin absolu vers ton fichier craftion.css
        applyCSS(dialogPane.getScene());

        alert.showAndWait();

        return alert.getResult() == yes;
    }

    public static void applyCSS(Scene scene) {
        URL cssURL = OCUtils.class.getResource("/style.css");
        System.out.println("CSS URL: " + cssURL);
        scene.getStylesheets().add(cssURL.toExternalForm());
    }
    public static void getFont() {
        InputStream fontStream = OCUtils.class.getResourceAsStream("/fonts/JetBrainsMono-Bold.ttf");

        if (fontStream == null) {
            System.err.println("❌ Fichier de police introuvable !");
            return;
        }

        Font font = Font.loadFont(fontStream, 12);
        if (font == null) {
            System.err.println("❌ Police non chargée !");
        } else {
            System.out.println("✅ Police chargée : " + font.getName());
        }
    }

}
