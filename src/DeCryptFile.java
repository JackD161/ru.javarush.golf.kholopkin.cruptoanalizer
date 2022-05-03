public class DeCryptFile {
    public DeCryptFile(String inFile, String outFile, int shift)
    {
        new CryptFile(inFile, outFile, -shift);
    }
}
