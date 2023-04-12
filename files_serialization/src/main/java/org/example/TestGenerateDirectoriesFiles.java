package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TestGenerateDirectoriesFiles {
    public static void main(String[] args) {
        StringBuilder log = new StringBuilder();

        File srcDir = new File("src//main//resources//Games//src");
        if (srcDir.mkdir()) {
            log.append("Каталог 'src' создан" + "\n");
        }

        File resDir = new File("src//main//resources//Games//res");
        if (resDir.mkdir()) {
            log.append("Каталог 'res' создан" + "\n");
        }

        File savegamesDir = new File("src//main//resources//Games//savegames");
        if (savegamesDir.mkdir()) {
            log.append("Каталог 'savegames' создан" + "\n");
        }

        File tempDir = new File("src//main//resources//Games//temp");
        if (tempDir.mkdir()) {
            log.append("Каталог 'temp' создан" + "\n");
        }
        File mainDir = new File("src//main//resources//Games//src//main");
        if (mainDir.mkdir()) {
            log.append("Каталог 'main' создан" + "\n");
        }
        File testDir = new File("src//main//resources//Games//src//test");
        if (testDir.mkdir()) {
            log.append("Каталог 'test' создан" + "\n");
        }
        File mainFile = new File("src//main//resources//Games//src//main//Main.java");
        try {
            if (mainFile.createNewFile()) {
                log.append("Файл 'Main.java' был создан" + "\n");
            }
        } catch (IOException e) {
            log.append("Ошибка: файл 'Main.java' не был создан" + "\n");
        }
        File utilsFile = new File("src//main//resources//Games//src//main//Utils.java");
        try {
            if (utilsFile.createNewFile()) {
                log.append("Файл 'Utils.java' был создан"+ "\n");
            }
        } catch (IOException e) {
            log.append("Ошибка: файл 'Utils.java' не был создан"+ "\n");
        }
        File drawablesDir = new File("src//main//resources//Games//res//drawables");
        if (drawablesDir.mkdir()) {
            log.append("Каталог 'drawables' создан" + "\n");
        }
        File vectorsDir = new File("src//main//resources//Games//res//vectors");
        if (vectorsDir.mkdir()) {
            log.append("Каталог 'vectors' создан" + "\n");
        }
        File iconsDir = new File("src//main//resources//Games//res//icons");
        if (iconsDir.mkdir()) {
            log.append("Каталог 'icons' создан" + "\n");
        }
        try (FileWriter writeLog = new FileWriter("src//main//resources//Games//temp//temp.txt", false)) {
            writeLog.write(log.toString());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}