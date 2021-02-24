package findfrequentphrases;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static findfrequentphrases.FindFrequentPhrases.groupPhrases;
import static findfrequentphrases.FindFrequentPhrases.mappedPhrases;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class FindFrequentPhrasesTest {

    private static final String PHRASE_1 = "No, he had a garden at the hotel.";
    private static final String PHRASE_2 = "She dropped her thick black veil over her face";
    private static final String PHRASE_3 = "That is his main fault, but on the whole way out of gear.";

    @Test
    void shouldReturnMapWithGroupedPhrasesGivenPhrasesListWhenGroupPhrases() {
        List<String> oneLinePhrases = Arrays.asList(PHRASE_1, PHRASE_1, PHRASE_2, PHRASE_3);

        groupPhrases(oneLinePhrases);

        assertNotNull(mappedPhrases, "Should not be null!");
        assertEquals(3, mappedPhrases.size());
        assertEquals(2, mappedPhrases.get(PHRASE_1));
        assertEquals(1, mappedPhrases.get(PHRASE_2));
        assertEquals(1, mappedPhrases.get(PHRASE_3));

    }

}