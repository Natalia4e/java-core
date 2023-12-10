import java.io.File;
import java.util.Arrays;

/**
 * TODO: Доработать метод print, необходимо распечатывать директории и файлы
 */
public class Tree {

    public static void main(String[] args) {
        // Вызываем метод print для текущей директории
        print(new File("."), "", true);
    }

    static void print(File file, String indent, boolean isLast) {
        System.out.print(indent);
        if (isLast) {
            System.out.print("└─");
            indent += "  ";
        } else {
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(file.getName());

        File[] files = file.listFiles();
        if (files == null)
            return;

        // Сортируем файлы: сначала директории, затем файлы
        Arrays.sort(files, (f1, f2) -> {
            if (f1.isDirectory() && !f2.isDirectory()) {
                return -1;
            } else if (!f1.isDirectory() && f2.isDirectory()) {
                return 1;
            } else {
                return f1.compareTo(f2);
            }
        });

        for (int i = 0; i < files.length; i++) {
            File currentFile = files[i];
            boolean lastItem = (i == files.length - 1);

            if (currentFile.isDirectory()) {
                // Рекурсивно вызываем print для директорий
                print(currentFile, indent, lastItem);
            } else {
                // Обрабатываем файлы
                System.out.print(indent);
                if (lastItem) {
                    System.out.print("└─");
                } else {
                    System.out.print("├─");
                }
                System.out.println(currentFile.getName());
            }
        }
    }
}
