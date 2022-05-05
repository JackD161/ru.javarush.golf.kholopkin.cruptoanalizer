import java.io.*;

public class CryptFile {
    private String originFile;
    private String cryptFile;
    private int shiftCesar;

    private Algorithm algorithm;

    public CryptFile(String originFile, String cryptFile, int shiftCesar)
    {
        this.originFile = originFile;
        this.cryptFile = cryptFile;
        this.shiftCesar = shiftCesar;
        algorithm = new Algorithm();
        crypt();
    }

    public String crypt()
    {
        try (BufferedReader readFile = new BufferedReader(new FileReader(originFile));
        BufferedWriter writeFile = new BufferedWriter(new FileWriter(cryptFile));)
        {
            String line;
            while ((line = readFile.readLine()) != null)
            {
                writeFile.write(algorithm.crypt(line, shiftCesar) + "\n");
            }
            return "Файл обработан";
        }
        catch (IOException e)
        {
            System.err.print("Ошибка ввода/вывода, возможно файл не найден для обработки");
            e.printStackTrace();
            return "Ошибка обработки файла";
        }
    }
}
