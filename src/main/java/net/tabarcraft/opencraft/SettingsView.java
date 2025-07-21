package net.tabarcraft.opencraft;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;

public class SettingsView extends VBox {
    static AppStorage storage = new AppStorage("config.properties");

    public static boolean isCoolMode = storage.getBoolean("isCoolMode", true);
    public static boolean isSoundOn = storage.getBoolean("isSoundOn", true);

    public SettingsView() {
        this.getStyleClass().add("settings-view");
        CheckBox toggleSound = new CheckBox("Son");
        toggleSound.setSelected(isSoundOn);
        toggleSound.setOnAction(e -> {
            boolean enabled = toggleSound.isSelected();
            isSoundOn = enabled;
            set("isSoundOn", enabled);
            System.out.println("Son activé : " + enabled);
        });

        CheckBox toggleCoolMode = new CheckBox("Mode Cool(recommandé si vous étudiez de la théorie)");
        toggleCoolMode.setSelected(isCoolMode);
        toggleCoolMode.setOnAction(e -> {
            boolean enabled = toggleCoolMode.isSelected();
            isCoolMode = enabled;
            set("isCoolMode", enabled);
            System.out.println("Mode Cool activé: " + enabled);
        });

        this.getChildren().addAll(
                toggleSound,
                new Separator(),
                toggleCoolMode
        );
    }

    public static void set(String key, boolean value) {
        storage.setBoolean(key, value);
    }
}
