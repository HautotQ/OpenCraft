package net.tabarcraft.opencraft;


import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;

import javax.swing.*;

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
        //File cssFile = new File("out/production/Craftion/assets/style.css"); // fichier à la racine du dossier d'exécution
        scene.getStylesheets().add(OCUtils.class.getResource("/assets/style.css").toExternalForm());
        /*
        if (cssFile.exists()) {
            scene.getStylesheets().add(cssFile.toURI().toString());
            System.out.println("Fichier CSS chargé depuis : " + cssFile.getAbsolutePath());
        } else {
            System.out.println("Fichier CSS introuvable à : " + cssFile.getAbsolutePath());
        }
        */
    }
}
