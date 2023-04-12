package org.example;

import java.io.File;
import java.util.Objects;

public class TestUnpackageAndDeserialization {
    public static void main(String[] args) {
        String zipPath = "src/main/resources/Games/savegames/zipSaveGames.zip";
        String dirPath = "src/main/resources/Games/savegames";
        GameProgress.openZip(zipPath, dirPath);
        File directory = new File(dirPath);
        for (File file : Objects.requireNonNull(directory.listFiles()))
        {
            if (file.getName().contains(".dat"))
                System.out.println(GameProgress.openProgress(file.getPath()));
        }

    }
}
