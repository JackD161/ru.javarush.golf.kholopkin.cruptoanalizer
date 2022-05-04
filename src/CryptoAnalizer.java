public class CryptoAnalizer {
    public static void main(String[] args) {
        String crypt = ".\\src\\files\\crypt.txt";
        String decoded = ".\\src\\files\\decoded.txt";
        String origin = ".\\src\\files\\in3.txt";
        CryptFile cryptFile = new CryptFile(origin, crypt, 5);
        BruteForce bruteForce = new BruteForce(crypt, decoded);
        System.out.println(bruteForce.start());
    }
}

