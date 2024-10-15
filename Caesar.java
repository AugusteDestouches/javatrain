import java.util.Scanner;

public class Caesar {
    private static final int eSize = 26;
    private static final int rSize = 32;
    
    private static final char eA = 'a';
    private static final char rA = 'а';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
             System.out.println("введите 'e' для шифрования, 'd' для расшифровки: ");
            String mode = scanner.nextLine().toLowerCase();

            if (!mode.equals("e") && !mode.equals("d")) {
                System.out.println("неверный ввод.");
                continue;
            }

            System.out.println("введите текст: ");
            String text = scanner.nextLine().toLowerCase();

            System.out.println("сдвиг: ");
            int shift = scanner.nextInt();
            scanner.nextLine();
            if (mode.equals("d")) shift = -shift;

            String resultText = caesar(text, shift);
            System.out.println("результат: " + resultText.toLowerCase());
        }
    }

    public static String caesar(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char curr = text.charAt(i);

            if (curr >= 'a' && curr <= 'z') {
                result.append((char) ((curr - eA + shift + eSize) % eSize + eA));
            } else if (curr >= 'а' && curr <= 'я') {
                result.append((char) ((curr - rA + shift + rSize) % rSize + rA));
            } else {
                result.append(curr);
            }
        }

        return result.toString();
    }
}
