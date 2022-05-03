import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CryptoAnalizer {
    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//       String input = reader.readLine();
//        String message2 = reader.readLine();
        String message = ".\\src\\test\\input.txt";
        String message2 = ".\\src\\test\\outputCrypt.txt";
        String message3 = ".\\src\\test\\outputDeCrypt.txt";
        CryptFile cryptFile = new CryptFile(message, message2, 2);
        DeCryptFile deCryptFile = new DeCryptFile(message2, message3, 2);
        String input = "Почему так больно? Сделай же контрольный.\n" +
                "Стану птицей вольной. Перестань, довольно.\n" +
                "Душа - не ломайся. Ум - не загружайся.\n" +
                "Потерял всё и вся. Мой родник любви иссяк.";
//        String input = "0 1 2 3 4 5 6 7 8 9";
        Algorithm algorithm = new Algorithm();
        String crypt = algorithm.crypt(input, 1);
        String deCrypt = algorithm.deCrypt(crypt, 1);
        System.out.println(input);
        System.out.println("--------------------");
        System.out.println(crypt);
        System.out.println("--------------------");
        System.out.println(deCrypt);


    }
}

