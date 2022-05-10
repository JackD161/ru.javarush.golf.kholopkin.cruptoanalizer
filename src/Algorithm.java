import java.util.ArrayList;
import java.util.List;

/**
 * Класс описывает все символы алфавита шафрования, а также метод метод смещения текстовой строки посимвольно на заданный шаг
 */
public class Algorithm {
    private static final char[] alphabet = new char[]{'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О',
            'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я', 'а', 'б', 'в', 'г', 'д',
            'е', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ',
            'ы', 'ь', 'э', 'ю', 'я', '.', ',', '\"', ':', '-', '!', '?', ' '};
    private final List<Character> ALPHABET = new ArrayList<>();

    public Algorithm() {
        for (char c : alphabet) {
            ALPHABET.add(c);
        }
    }

    public static int getAlphabetSize() {
        return alphabet.length;
    }
    public String crypt(String message, int index) {
        char[] messageChars = message.toCharArray();
        StringBuilder result = new StringBuilder();
        for (char c : messageChars) {
            if (ALPHABET.contains(c)) {
                result.append(move(c, index));
            }
            else {
                result.append(c);
            }

        }
        return result.toString();
    }

    private char move(char c, int step) {
        int startInd = ALPHABET.indexOf(c);
        int index = startInd + step;
        if (index < ALPHABET.size() && index >= 0) {
            return ALPHABET.get(index);
        }
        else if (index >= ALPHABET.size()) {
            while(index >= ALPHABET.size()) {
                index -= ALPHABET.size();
            }
            return ALPHABET.get(index);
        }
        else {
            while(index < 0) {
                index += ALPHABET.size();
            }
            return ALPHABET.get(index);
        }
    }
}
