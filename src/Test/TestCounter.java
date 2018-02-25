package Test;

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
        Parser p = new Parser("words.txt");
        words = p.getWords();
    }

    @Test
    public void testGoodInput() {
        assertTrue(words.size() > 0);
    }

    @Test
    public void testConversion() {
        int sum = 0;
        Counter c = new Counter(words);
        map = c.getMap();
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            sum = sum + (int) pair.getValue();
            it.remove(); // avoids a ConcurrentModificationException
        }
        assertTrue(words.size() == sum);
    }

    @Test
    public void testTopWords() {
        Counter c = new Counter(words);
        Map<String, Integer> threeWords = c.getTopWords();
        assertEquals(3,threeWords.size());
    }
}
