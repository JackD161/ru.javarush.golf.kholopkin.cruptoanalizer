public class DeCryptFile extends CryptFile{
    public DeCryptFile(String inFile, String outFile, int shift)
    {
        super(inFile, outFile, -shift);
    }
}
