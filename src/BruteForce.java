import java.io.BufferedReader;

public class BruteForce {
    public static int codeCesar;
    private String fileCoded;
    private String fileDeCoded;
    private String temp;
    private Analizer analizer;

    public BruteForce(String fileCoded, String fileDeCoded)
    {
        this.fileCoded = fileCoded;
        this.fileDeCoded = fileDeCoded;
        temp = ".\\src\\files\\temp.txt";
    }

    public int start()
    {
        for (int shift = 1; shift < Algorithm.getAlphabetSize(); shift++)
        {
            new DeCryptFile(fileCoded, temp, shift);
            analizer = new Analizer(temp);
            if (analizer.analize())
            {
                codeCesar = shift;
                new DeCryptFile(fileCoded, fileDeCoded, shift);
                break;
            }
        }
        return getCodeCesar();
    }

    public int getCodeCesar()
    {
        if (codeCesar == 0)
        {
            System.out.println("Код не подобран");
            return 0;
        }
        else
        {
            return codeCesar;
        }
    }
}
