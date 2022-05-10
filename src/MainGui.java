import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGui {
    private final JFrame window;
    private final JTextArea result;
    private final JTextField patchToOriginFile;
    private final JTextField patchToCryptedFile;
    private final JTextArea textToCrypt;
    private final JTextField cryptKey;
    private String originFile;
    private String outFile;
    private String key;
    private boolean originFileNotEmpty;
    private boolean outFileNotEmpty;
    private boolean keyNotEmpty;
    private boolean textToCryptNotEmpty;

    public MainGui() {
        window = new JFrame("Криптоанализатор");
        window.setBounds(200, 300, 900, 600);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());
        result = new JTextArea(30, 45);
        patchToOriginFile = new JTextField(30);
        patchToCryptedFile = new JTextField(30);
        cryptKey = new JTextField(30);
        JLabel stringToCrypt = new JLabel("Строка для шифрования");
        textToCrypt = new JTextArea(12, 30);
        JScrollPane scrollTextCrypt = new JScrollPane(textToCrypt);
        JButton cryptText = new JButton("Зашифровать текст");
        JButton deCryptText = new JButton("Расшифровать текст");
        cryptText.setBackground(Color.ORANGE);
        deCryptText.setBackground(Color.GRAY);
        JLabel shiftCesare = new JLabel("Ключ Цезаря");
        JLabel patchToCryptFile = new JLabel("Путь для сохнарения конечного файла");
        JLabel patchToOriginalFile = new JLabel("Путь до исходного файла");
        JButton crypt = new JButton("Зашифровать");
        JButton deCrypt = new JButton("Расшифровать");
        JButton bruteForce = new JButton("Взломать код");
        JButton reset = new JButton("Очистить");
        JMenuBar bar = new JMenuBar();
        JMenu file = new JMenu("Файл");
        JMenu help = new JMenu("Помощь");
        JMenuItem saveAs = new JMenuItem("Сохранить результат как...");
        JMenuItem exit = new JMenuItem("Выход");
        JMenuItem aboutIt = new JMenuItem("О программе");
        file.add(saveAs);
        file.add(exit);
        help.add(aboutIt);
        bar.add(file);
        bar.add(help);
        crypt.setBackground(Color.GREEN);
        deCrypt.setBackground(Color.MAGENTA);
        bruteForce.setBackground(Color.cyan);
        reset.setBackground(Color.RED);
        JPanel footer = new JPanel();
        JPanel right = new JPanel();
        JPanel center = new JPanel();
        center.add(patchToOriginalFile);
        center.add(patchToOriginFile);
        center.add(patchToCryptFile);
        center.add(patchToCryptedFile);
        center.add(shiftCesare);
        center.add(cryptKey);
        center.add(stringToCrypt);
        center.add(scrollTextCrypt);
        center.add(cryptText);
        center.add(deCryptText);
        footer.setLayout(new FlowLayout());
        right.setLayout(new FlowLayout());
        footer.add(crypt);
        footer.add(deCrypt);
        footer.add(bruteForce);
        footer.add(reset);
        JScrollPane scroll = new JScrollPane(result);
        right.add(scroll);
        window.getContentPane().add(BorderLayout.NORTH, bar);
        window.getContentPane().add(BorderLayout.SOUTH, footer);
        window.getContentPane().add(BorderLayout.CENTER, center);
        window.getContentPane().add(BorderLayout.EAST, right);
        window.setVisible(true);

        crypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                originFile = patchToOriginFile.getText();
                outFile = patchToCryptedFile.getText();
                key = cryptKey.getText();
                if (originFile.isEmpty()) {
                    patchToOriginFile.setBackground(Color.PINK);
                }
                else {
                    originFileNotEmpty = true;
                }
                if (outFile.isEmpty()) {
                    patchToCryptedFile.setBackground(Color.PINK);
                }
                else {
                    outFileNotEmpty = true;
                }
                if (key.isEmpty()) {
                    cryptKey.setBackground(Color.PINK);
                }
                else {
                    keyNotEmpty = true;
                }
                if (originFileNotEmpty && outFileNotEmpty && keyNotEmpty) {
                    try {
                        CryptFile cryptFile = new CryptFile(originFile, outFile, Integer.parseInt(key));
                        result.append("Файл зашифрован\n");
                    }
                    catch (NumberFormatException exception) {
                        System.out.println("Ошибка распознания ключа шифрования");
                        exception.printStackTrace();
                    }
                }
            }
        });
        cryptText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                key = cryptKey.getText();
                String cryptString = textToCrypt.getText();
                if (cryptString.isEmpty()) {
                    textToCrypt.setBackground(Color.PINK);
                }
                else {
                    textToCryptNotEmpty = true;
                }
                if (key.isEmpty()) {
                    cryptKey.setBackground(Color.PINK);
                }
                else {
                    keyNotEmpty = true;
                }
                if (textToCryptNotEmpty && keyNotEmpty) {
                    try {
                        Algorithm algorithm = new Algorithm();
                        result.append(algorithm.crypt(cryptString, Integer.parseInt(key)) + "\n");
                    }
                    catch (NumberFormatException exception) {
                        System.out.println("Ошибка распознания ключа шифрования");
                        exception.printStackTrace();
                    }
                }
            }
        });
        deCryptText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                key = cryptKey.getText();
                String cryptString = textToCrypt.getText();
                if (cryptString.isEmpty()) {
                    textToCrypt.setBackground(Color.PINK);
                }
                else {
                    textToCryptNotEmpty = true;
                }
                if (key.isEmpty()) {
                    cryptKey.setBackground(Color.PINK);
                }
                else {
                    keyNotEmpty = true;
                }
                if (textToCryptNotEmpty && keyNotEmpty) {
                    try {
                        Algorithm algorithm = new Algorithm();
                        result.append(algorithm.crypt(cryptString, -Integer.parseInt(key)) + "\n");
                    }
                    catch (NumberFormatException exception) {
                        System.out.println("Ошибка распознания ключа шифрования");
                        exception.printStackTrace();
                    }
                }
            }
        });
        bruteForce.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                originFile = patchToOriginFile.getText();
                outFile = patchToCryptedFile.getText();
                key = cryptKey.getText();
                if (originFile.isEmpty()) {
                    patchToOriginFile.setBackground(Color.PINK);
                }
                else {
                    originFileNotEmpty = true;
                }
                if (outFile.isEmpty()) {
                    patchToCryptedFile.setBackground(Color.PINK);
                }
                else {
                    outFileNotEmpty = true;
                }
                if (outFileNotEmpty && originFileNotEmpty) {
                    BruteForce bruteForceObject = new BruteForce(originFile, outFile);
                    result.append("Ключ цезаря: " + bruteForceObject.start() + "\n");
                }
            }
        });
        deCrypt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                originFile = patchToOriginFile.getText();
                outFile = patchToCryptedFile.getText();
                key = cryptKey.getText();
                if (originFile.isEmpty()) {
                    patchToOriginFile.setBackground(Color.PINK);
                }
                else {
                    originFileNotEmpty = true;
                }
                if (outFile.isEmpty()) {
                    patchToCryptedFile.setBackground(Color.PINK);
                }
                else {
                    outFileNotEmpty = true;
                }
                if (key.isEmpty()) {
                    cryptKey.setBackground(Color.PINK);
                }
                else {
                    keyNotEmpty = true;
                }
                if (originFileNotEmpty && outFileNotEmpty && keyNotEmpty) {
                    try {
                        DeCryptFile deCryptFile = new DeCryptFile(originFile, outFile, Integer.parseInt(key));
                        result.append("Файл расшифрован\n");
                    }
                    catch (NumberFormatException exception) {
                        System.out.println("Ошибка распознания ключа шифрования");
                        exception.printStackTrace();
                    }
                }
            }
        });
        aboutIt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(window, "Версия криптографа 1.0 alpha");
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        saveAs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(window,"Ну допустим сохранили какой-то файл, реализую функционал потом");
            }
        });
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                patchToCryptedFile.setText("");
                patchToOriginFile.setText("");
                cryptKey.setText("");
                result.setText("");
                patchToCryptedFile.setBackground(Color.WHITE);
                patchToOriginFile.setBackground(Color.WHITE);
                cryptKey.setBackground(Color.WHITE);
                textToCrypt.setBackground(Color.WHITE);
                textToCrypt.setText("");
            }
        });
    }
}
