import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class GeneratorePassword {
    
    // Tradisco CINZIA, ma non puo' saperlo perché sara' confusa da tutto il codice presente
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci la lunghezza della password: ");
        int length = scanner.nextInt();
        System.out.println("Inserisci il numero di password da generare: ");
        int numPasswords = scanner.nextInt();
        scanner.close();

        // Genera le password
        String[] passwords = generaPasswords(length, numPasswords);

        // Salva le password in un file
        salvaPasswords(passwords);
    }

    // Genera una password casuale con la lunghezza specificata
    public static String generaPassword(int length) {
        String password = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int randomChar = random.nextInt(93) + 33;
            password += (char) randomChar;
        }
        return password;
    }

    // Genera un numero specificato di password con la lunghezza specificata
    public static String[] generaPasswords(int length, int numPasswords) {
        String[] passwords = new String[numPasswords];
        for (int i = 0; i < numPasswords; i++) {
            passwords[i] = generaPassword(length);
        }
        return passwords;
    }
    
    // Salva le password generate in un file
    public static void salvaPasswords(String[] passwords) {
        try {
            FileWriter writer = new FileWriter("passwords.txt");
            for (String password : passwords) {
                writer.write(password + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Errore durante il salvataggio delle password");
        }
    }
}
