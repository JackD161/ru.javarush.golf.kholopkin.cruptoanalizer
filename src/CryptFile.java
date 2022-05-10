import java.io.*;

/**
 * Класс описываем механизм построчного чтения данных из файла оригинала и построчной записи в файл зашифрованный
 */
public class CryptFile {
    private final String originFile;
    private final String cryptFile;
    private final int shiftCesar;
    private final Algorithm algorithm;

    public CryptFile(String originFile, String cryptFile, int shiftCesar) {
        this.originFile = originFile;
        this.cryptFile = cryptFile;
        this.shiftCesar = shiftCesar;
        algorithm = new Algorithm();
        crypt();
    }

    private void crypt() {
        try (BufferedReader readFile = new BufferedReader(new FileReader(originFile));
        BufferedWriter writeFile = new BufferedWriter(new FileWriter(cryptFile))) {
            String line;
            while ((line = readFile.readLine()) != null) {
                writeFile.write(algorithm.crypt(line, shiftCesar) + "\n");
            }
        }
        catch (IOException e) {
            System.err.print("Ошибка ввода/вывода, возможно файл не найден для обработки");
            e.printStackTrace();
        }
    }
}
