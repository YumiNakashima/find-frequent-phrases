package findfrequentphrases;


import org.junit.jupiter.api.Test;

import java.io.IOException;

import static findfrequentphrases.FindFrequentPhrases.mappedPhrases;
import static findfrequentphrases.FindFrequentPhrases.readFile;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class FindFrequentPhrasesTest {


    private static final String FILE_PATH = "src/test/resources/testFIle.txt";
    private static final String PHRASE_1 = "There was but one way out I dropped off to some other place, concealed three gems had been beaten in by repeated blows of my companions, but I am sorry that Miss Sutherland to be away all the snow of the house.";
    private static final String PHRASE_2 = "A girl of fourteen, who does a bit of metal had fallen.";
    private static final String PHRASE_3 = "I was at least four and a square pierced bit of news.";

    @Test
    void shouldReturnMapWithGroupedPhrasesGivenPhrasesListWhenGroupPhrases() throws IOException {
        readFile(FILE_PATH);

        assertNotNull(mappedPhrases, "Should not be null!");
        assertEquals(51, mappedPhrases.size());
        assertEquals(23, mappedPhrases.get(PHRASE_1));
        assertEquals(23, mappedPhrases.get(PHRASE_2));
        assertEquals(20, mappedPhrases.get(PHRASE_3));

    }

}