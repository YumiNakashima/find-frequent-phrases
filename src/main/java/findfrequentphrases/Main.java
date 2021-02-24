package findfrequentphrases;

import java.io.IOException;
import java.util.Scanner;

import static findfrequentphrases.FindFrequentPhrases.readFile;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira o caminho do arquivo: ");
        String inputWord = scanner.nextLine();
        readFile(inputWord);

    }
}
