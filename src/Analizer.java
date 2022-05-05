import java.io.*;
import java.util.*;

/**
 * Класс выполняет анализ зашифрованного файла по логике:
 * 1. Читаем файл построчно
 * 2. Пытаемся разделить строку на слова по знакам пробела (слова в тексте обычно разделяет пробел),
 * анализируется не более 100 первых разобрынных слов
 * 3. Сравниваем слова со словарем, в словаре 5000 строк с наиболее распростаненными русскими словами
 * 4. Если удалось насчитать 5 совпадений разобрынных строк со словарем - поднимаем флаг, синнализирующий об успешно анализе
 */
public class Analizer {
    private String inputFile;
    // Список из 5000 наиболее частых слов. 5000 наиболее частотных лемм покрывают 82.0604% текста.
    private String dictionary = ".\\src\\files\\lemm5000.txt";
    private int wordsCountAnaliz = 5;
    private final int countReadWords = 100;
    private boolean flag = false;
    private Set<String> dictionarySet = new HashSet<>();

    private int wordsALL;
    // конструктор на случай если мы хотим проверить файл на определенное количество совпадений слов со словарем
    public Analizer (String inputFile, int wordsCountAnaliz)
    {
        this.inputFile = inputFile;
        this.wordsCountAnaliz = wordsCountAnaliz;
        this.wordsALL = 0;
        fillDictionary();
    }
    // конструктор на случай если мы хотим проверить файл на количество по умолчанию (5) совпадений со словарем
    public Analizer (String inputFile)
    {
        this.inputFile = inputFile;
        this.wordsALL = 0;
        fillDictionary();
    }
    // конструктор на случай использования метода проверки по словарю отдельных строк не из файла
    public Analizer()
    {
        fillDictionary();
    }
    public boolean analize()
    {
        try (BufferedReader readFile = new BufferedReader(new FileReader(inputFile));)
        {
            int cntWrds = 0;
            String line;
            String[] words;
            while ((line = readFile.readLine()) != null)
            {
                words = line.split(" ");
                wordsALL += words.length;
                for (String word : words)
                {
                    if (checkWord(word))
                        cntWrds++;
                }
                if (cntWrds == wordsCountAnaliz)
                {
                    flag = true;
                    break;
                }
                if (wordsALL == countReadWords)
                    break;
            }
        }
        catch (IOException e)
        {
            System.err.print("Ошибка ввода/вывода, возможно файл не найден для анализа");
        }
        return flag;
    }

    private void fillDictionary()
    {
        try (BufferedReader readFile = new BufferedReader(new FileReader(dictionary));)
        {
            String words;
            while ((words = readFile.readLine()) != null) {
                dictionarySet.add(words);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public boolean checkWord(String word)
    {
        return dictionarySet.contains(word);
    }

    public boolean getFlag()
    {
        return flag;
    }
}
