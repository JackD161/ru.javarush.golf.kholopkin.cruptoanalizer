/**
 * Класс наследуется от класса шифрования файла и меняет направление смещения сомволов на противоположный в родительском конструкторе
 */
public class DeCryptFile extends CryptFile {
    public DeCryptFile(String inFile, String outFile, int shift) {
        super(inFile, outFile, -shift);
    }
}
