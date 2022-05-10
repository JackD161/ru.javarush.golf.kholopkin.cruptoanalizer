/**
 * Класс перебора пароля работает следующим образом:
 * 1. В цикле увеличиваем шаг сдвига алфавита
 * 2. На каждой итерации цикла запускаем расшифроввывание файла и записываем результат во временный файл
 * 3. Анализирует временный файл, если анализ заканчивается успешно - запускаем расшифровывание файла с полученныч шагом смещения
 * 4. Записываем результат в выходной файл
 * 5. По итогу возвращаем ключ шифрования или возвращаем сообщение о неудачной разшифровке
 */
public class BruteForce {
    public static int codeCesar;
    private final String fileCoded;
    private final String fileDeCoded;
    private final String temp;

    public BruteForce(String fileCoded, String fileDeCoded) {
        this.fileCoded = fileCoded;
        this.fileDeCoded = fileDeCoded;
        temp = ".\\src\\files\\temp.txt";
    }

    public int start() {
        for (int shift = 1; shift < Algorithm.getAlphabetSize(); shift++) {
            new DeCryptFile(fileCoded, temp, shift);
            Analizer analizer = new Analizer(temp);
            if (analizer.analize()) {
                codeCesar = shift;
                new DeCryptFile(fileCoded, fileDeCoded, shift);
                break;
            }
        }
        return getCodeCesar();
    }

    public int getCodeCesar() {
        if (codeCesar == 0) {
            System.out.println("Код не подобран");
            return 0;
        }
        else {
            return codeCesar;
        }
    }
}
