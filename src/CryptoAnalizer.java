import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CryptoAnalizer {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String message = reader.readLine();
        System.out.println(Data.toCode(message, 1));
    }
}

