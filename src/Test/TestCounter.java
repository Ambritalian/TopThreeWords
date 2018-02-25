package Test;

import com.atli.Counter;
import com.atli.Parser;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestCounter {

    List<String> words;
    Map<String, Integer> map;

    @Before
    public void setup() {
        Parser p = new Parser("LargeFile");
        words = p.getWords();
    }

    @Test
    public void testGoodInput() {
        assertTrue(words.size() != 0);
    }

    @Test
    public void testConversion() {
        int sum = 0;
        Counter c = new Counter(words);
        map = c.getWordCounts();
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            sum = sum + (int) pair.getValue();
            it.remove(); // avoids a ConcurrentModificationException
        }
        assertTrue(words.size() == sum);
    }

    @Test
    public void testTopWordsEmpty() {
        Parser p = new Parser("empty");
        words = p.getWords();
        Counter c = new Counter(words);
        List<String> threeWords = c.getTopWords();
        assertEquals(3,threeWords.size());
        for (String thing: threeWords) {
            System.out.println(thing);
        }
    }

    @Test
    public void testTopWordsSmall() {
        Parser p = new Parser("threeWordsTest");
        words = p.getWords();
        Counter c = new Counter(words);
        List<String> threeWords = c.getTopWords();
        assertEquals(3,threeWords.size());
        for (String thing: threeWords) {
            System.out.println(thing);
        }
    }

    @Test
    public void testTopWordsLarge() {
        Counter c = new Counter(words);
        List<String> threeWords = c.getTopWords();
        assertEquals(3,threeWords.size());
        for (String thing: threeWords) {
            System.out.println(thing);
        }
    }

    @Test
    public void testConsistency() {
        Counter c = new Counter(words);
        Counter c1 = new Counter(words);
        List<String> threeWords = c.getTopWords();
        List<String> threeWords2 = c.getTopWords();
        for (int i = 0; i < 3; i++) {
            assertEquals(threeWords.get(i),threeWords2.get(i));
        }
    }
}
