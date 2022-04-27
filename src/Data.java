import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Data {
    private static final char[] alphabet = new char[]{'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я', 'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '\"', ':', '-', '!', '?', ' '};
    private static List<Character> ALPHABET = new ArrayList<>();

    public Data()
    {
        for (char c : alphabet)
        {
            ALPHABET.add(c);
        }
    }

    public static String toCode(String message, int index)
    {
        new Data();
        char[] messageChars = message.toCharArray();
        StringBuilder result = new StringBuilder();
        for (char c : messageChars)
        {
            if (ALPHABET.contains(c))
            {
                result.append(move(c, index));
            }
            else
            {
                result.append(c);
            }

        }
        return result.toString();
    }

    private static char move(char c, int step) {
        int startInd = ALPHABET.indexOf(c);
        if (startInd + step < ALPHABET.size()) {
            return ALPHABET.get(startInd + step);
        }
        else {
            return ALPHABET.get(startInd + step - ALPHABET.size());
        }
    }
}
