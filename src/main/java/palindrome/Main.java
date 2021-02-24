package palindrome;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static Map<String, Integer> phrases = new HashMap<>();

    public static void readAllLinesWithStream() throws IOException {
        long inicio = System.currentTimeMillis();
        try (BufferedReader br = new BufferedReader(new FileReader("/home/laryssa_yumi/Downloads/teste3.txt"))) {
            String line = "";

            while ((line = br.readLine()) != null) {
                String[] lineSplit = line.split("\\|");
                validLines(Arrays.asList(lineSplit));

            }

            phrases.entrySet().stream()
                    .sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue()))
                    .forEach(s -> System.out.println("Quantidade: " +s.getValue() + "   -   Frase: " + s.getKey()));

            long seconds = (System.currentTimeMillis() - inicio);

            System.out.println("Segundos: " + seconds/1000);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void validLines(List<String> phs) {
        for (String line : phs) {
            if (phrases.get(line) != null) {
                int quantity = phrases.get(line);
                phrases.put(line, ++quantity);

            } else {
                phrases.put(line, 1);
            }
        }

    }

    public static void main(String[] args) throws IOException {

        readAllLinesWithStream();

    }
}
