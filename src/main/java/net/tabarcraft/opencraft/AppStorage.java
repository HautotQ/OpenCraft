package net.tabarcraft.opencraft;

import java.io.*;
import java.util.Properties;

public class AppStorage {
    private final Properties props = new Properties();
    private final File file;

    public AppStorage(String filename) {
        this.file = new File(filename);
        try {
            if (file.exists()) {
                try (FileReader reader = new FileReader(file)) {
                    props.load(reader);
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur au chargement de " + filename + " : " + e.getMessage());
        }
    }

    public void set(String key, String value) {
        props.setProperty(key, value);
        save();
    }

    public String get(String key, String defaultValue) {
        return props.getProperty(key, defaultValue);
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        return Boolean.parseBoolean(get(key, String.valueOf(defaultValue)));
    }

    public void setBoolean(String key, boolean value) {
        set(key, String.valueOf(value));
    }

    public void save() {
        try (FileOutputStream fos = new FileOutputStream(file)) {
            props.store(fos, "AppStorage Preferences");
            fos.getFD().sync();  // synchronise physiquement les données sur le disque
        } catch (IOException e) {
            System.err.println("Erreur lors de l'enregistrement de " + file.getName() + " : " + e.getMessage());
        }
    }
}
