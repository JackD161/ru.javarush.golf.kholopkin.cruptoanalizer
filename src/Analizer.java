import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Analizer {
    private String inputFile;
    private String dictionary = "russian.txt";

    private int words;

    public Analizer (String inputFile, int words)
    {
        this.inputFile = inputFile;
        this.words = words;
    }

    {
        try (
                BufferedReader reader = new BufferedReader(new FileReader(dictionary));
                BufferedReader readFile = new BufferedReader(new FileReader(inputFile));
        ) {

        }
        catch (FileNotFoundException e) {
            System.err.print("Указанный файл не найден");
            }
        catch (IOException e) {
            System.err.print("Что то пошло не так с вводом/выводом");
        }
    }

}
