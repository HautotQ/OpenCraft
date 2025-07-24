package net.tabarcraft.opencraft;

public class Settings {
    private static final AppStorage storage = new AppStorage(System.getProperty("user.home") + "/.opencraft.properties");

    public static boolean isCoolMode() {
        return storage.getBoolean("isCoolMode", true);
    }

    public static boolean isSoundOn() {
        return storage.getBoolean("isSoundOn", true);
    }

    public static void setCoolMode(boolean value) {
        storage.setBoolean("isCoolMode", value);
    }

    public static void setSoundOn(boolean value) {
        storage.setBoolean("isSoundOn", value);
    }
}

