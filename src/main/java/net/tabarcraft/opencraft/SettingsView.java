package net.tabarcraft.opencraft;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;

public class SettingsView extends VBox {
    private static final AppStorage storage = new AppStorage(System.getProperty("user.home") + "/.config.properties");

    public SettingsView() {
        this.getStyleClass().add("settings-view");

        CheckBox toggleCoolMode = new CheckBox("Mode Cool (recommandé si vous étudiez de la théorie)");
        toggleCoolMode.setSelected(storage.getBoolean("isCoolMode", true));
        toggleCoolMode.setOnAction(e -> {
            boolean enabled = toggleCoolMode.isSelected();
            storage.setBoolean("isCoolMode", enabled);
            System.out.println("Mode Cool activé : " + enabled);
        });

        this.getChildren().addAll(toggleCoolMode);
    }
}
