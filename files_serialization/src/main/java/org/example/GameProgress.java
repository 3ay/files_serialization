package org.example;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class GameProgress implements Serializable {
    private static final long serialVersionUID = 1L;

    private int health;
    private int weapons;
    private int lvl;
    private double distance;

    public GameProgress(int health, int weapons, int lvl, double distance) {
        this.health = health;
        this.weapons = weapons;
        this.lvl = lvl;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "GameProgress{" +
                "health=" + health +
                ", weapons=" + weapons +
                ", lvl=" + lvl +
                ", distance=" + distance +
                '}';
    }

    public void saveGame(String filePath, GameProgress gameProgress) {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(gameProgress);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void zipFiles(String zipPath, List<String> savedGamesList){
        try (FileOutputStream fos = new FileOutputStream(zipPath);
             ZipOutputStream zos = new ZipOutputStream(fos)
        ) {
            for (String savedGameFile : savedGamesList) {
                FileInputStream fis = new FileInputStream(savedGameFile);
                ZipEntry zipEntry = new ZipEntry(savedGameFile.replaceAll(".*/(.+)", "$1"));
                zos.putNextEntry(zipEntry);
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                zos.write(buffer);
                zos.closeEntry();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void deleteFiles (List<String> savedGamesList)
    {
        for (String savedGameFile : savedGamesList) {
            File file = new File(savedGameFile);
            if (!file.delete()) {
                System.out.println("Не удалось удалить файл: " + file.getAbsolutePath());
            }
        }
    }
    public static void openZip(String zipPath, String toDirPath)
    {
        try (ZipInputStream zin = new ZipInputStream(new
                FileInputStream(zipPath))) {
            ZipEntry entry;
            String name;
            while ((entry = zin.getNextEntry()) != null) {
                name = entry.getName();
                FileOutputStream fout = new FileOutputStream(toDirPath + "/" + name);
                for (int c = zin.read(); c != -1; c = zin.read()) {
                    fout.write(c);
                }
                fout.flush();
                zin.closeEntry();
                fout.close();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static GameProgress openProgress(String pathToSavedGameFile)
    {
        GameProgress gameProgress = null;
        try (FileInputStream fis = new FileInputStream(pathToSavedGameFile);
        ObjectInputStream ois = new ObjectInputStream(fis)){
            gameProgress = (GameProgress) ois.readObject();
        }
        catch (Exception exception)
        {
            System.out.println(exception.getMessage());
        }
        return gameProgress;
    }
}
