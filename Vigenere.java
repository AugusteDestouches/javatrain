import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Vigenere {
    public boolean isEng(char character) {
        return (character >= 'A' && character <= 'Z') || (character >= 'a' && character <= 'z');
    }

    public String encrypt(String plaintext, String key) {
        StringBuilder eText = new StringBuilder();
        key = key.toUpperCase();
        int kLgth = key.length();
        int kIndx = 0;

        for (int i = 0; i < plaintext.length(); i++) {
            char currentChar = plaintext.charAt(i);
            if (isEng(currentChar)) {
                int kCharAlph =  key.charAt(kIndx % kLgth) - 'A';
                eText.append((char) ((currentChar - 'A' + kCharAlph) % 26 + 'A'));
                kIndx++;
            } else {
                eText.append(currentChar);
            }
        }
        return eText.toString();
    }

    public String decrypt(String plaintext, String key) {
        StringBuilder dText = new StringBuilder();
        key = key.toUpperCase();
        int kLgth = key.length();
        int kIndx = 0;

        for (int i = 0; i < plaintext.length(); i++) {
            char currentChar = plaintext.charAt(i);
            if (isEng(currentChar)) {

                int kCharAlph = key.charAt(kIndx % kLgth) - 'A';
                dText.append((char) ((currentChar - 'A' - kCharAlph+26) % 26 + 'A'));
                kIndx++;
            } else {
                dText.append(currentChar);
            }
        }
        return dText.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vigenere cipher = new Vigenere();
        for (; ;) {
            System.out.print("введите текст для шифрования или дешифрования: ");
            String plaintext = scanner.nextLine().toUpperCase();

            System.out.print("введите ключ: ");
            String key = scanner.nextLine().toUpperCase();
            System.out.println("выберите режим работы (0 - шифрование; 1 - дешифрование): ");
            String mode = scanner.nextLine();
            switch (mode) {
                case "0":
                    String encrypted = cipher.encrypt(plaintext, key);
                    System.out.println("зашифрованный текст: " + encrypted);
                    System.out.println(mode);
                    break;
                // Шифрование текста
                case "1":
                    String decrypted = cipher.decrypt(plaintext, key);
                    System.out.println("расшифрованный текст: " + decrypted);
                    break;
                default:
                    break;
            }

        }
    }
}