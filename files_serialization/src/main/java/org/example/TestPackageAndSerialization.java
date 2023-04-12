package org.example;

import java.util.Arrays;
import java.util.List;

public class TestPackageAndSerialization {
    public static void main(String[] args) {
        List<String> savedGamesList = Arrays.asList(
                "src//main//resources//Games//savegames//save1.dat",
                "src//main//resources//Games//savegames//save2.dat",
                "src//main//resources//Games//savegames//save3.dat"
        );
        GameProgress human = new GameProgress(100, 2, 12, 5);
        human.saveGame(savedGamesList.get(0), human);
        GameProgress elf = new GameProgress(150, 2, 16, 15);
        elf.saveGame(savedGamesList.get(1), elf);
        GameProgress dwarf = new GameProgress(90, 1, 10, 3);
        dwarf.saveGame(savedGamesList.get(2), dwarf);
        GameProgress.zipFiles("src//main//resources//Games//savegames//zipSaveGames.zip", savedGamesList);
    }
}
