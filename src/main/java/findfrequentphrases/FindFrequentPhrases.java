package findfrequentphrases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class responsible for grouping and ordering the most frequent phrases in a file.
 *
 * @author Laryssa Yumi - laryyumi@gmail.com
 */
public class FindFrequentPhrases {

    public static Map<String, Integer> mappedPhrases = new HashMap<>();

    /**
     * <p>Method that reads the file line by line.
     * </p>
     *
     * @param filePath absolute file path
     * @since 1.0
     */
    public static void readFile(String filePath) throws IOException {
        long startInSeconds = System.currentTimeMillis();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = "";

            while ((line = br.readLine()) != null) {
                String[] lineSplit = line.split("\\|");
                groupPhrases(Arrays.asList(lineSplit));
            }

            sortFrequentPhrases();

            long endInSeconds = (System.currentTimeMillis() - startInSeconds);

            System.out.println("Tempo de execução: " + endInSeconds / 1000);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * <p>Method that sorts the 50,000 most frequent phrases and prints them.
     * </p>
     *
     * @since 1.0
     */
    public static void sortFrequentPhrases() {
        mappedPhrases.entrySet().stream()
                .sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue()))
                .limit(50000)
                .forEach(s -> System.out.println("Quantidade: " + s.getValue() + "   -   Frase: " + s.getKey())
                );
    }

    /**
     * <p>Method that groups phrases.
     * </p>
     *
     * @since 1.0
     */
    public static void groupPhrases(List<String> oneLinePhrases) {
        for (String phrase : oneLinePhrases) {
            if (mappedPhrases.get(phrase) != null) {
                int quantity = mappedPhrases.get(phrase);
                mappedPhrases.put(phrase, ++quantity);

            } else {
                mappedPhrases.put(phrase, 1);
            }
        }
    }
}
