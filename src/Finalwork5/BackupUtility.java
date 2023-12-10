package Finalwork5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

//1. Написать функцию, создающую резервную копию всех файлов в директории
// во вновь созданную папку ./backup
public class BackupUtility {

    public static void createBackup(String sourceDirectoryPath) throws IOException {
        File sourceDir = new File(sourceDirectoryPath);
        File backupDir = new File(sourceDir, "backup");

        // Создаем директорию для резервной копии, если она не существует
        if (!backupDir.exists()) {
            backupDir.mkdir();
        }

        File[] files = sourceDir.listFiles();
        if (files == null) return;

        for (File file : files) {
            // Копируем только файлы, игнорируем директории
            if (file.isFile()) {
                Files.copy(file.toPath(), Paths.get(backupDir.getPath(), file.getName()), StandardCopyOption.REPLACE_EXISTING);
            }
        }

        System.out.println("Backup created in " + backupDir.getPath());
    }

    public static void main(String[] args) {
        try {
            createBackup("."); // указываем текущую директорию как исходную
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
