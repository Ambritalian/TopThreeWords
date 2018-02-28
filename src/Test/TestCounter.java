package Test;

import com.atli.Counter;
import com.atli.Parser;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestCounter {

    Counter counter;
    Counter counter2;

    @Before
    public void setup() {
        counter = new Counter();
        counter2 = new Counter();
        for (int i = 0; i<5; i++) counter.add("and");
        for (int i = 0; i<1; i++) counter.add("of");
        for (int i = 0; i<3; i++) counter.add("there");
        for (int i = 0; i<2; i++) counter.add("was");
        for (int i = 0; i<4; i++) counter.add("some");
        for (int i = 0; i<6; i++) counter.add("how");

        for (int i = 0; i<5; i++) counter2.add("and");
        for (int i = 0; i<1; i++) counter2.add("of");
        for (int i = 0; i<3; i++) counter2.add("there");
        for (int i = 0; i<2; i++) counter2.add("was");
        for (int i = 0; i<4; i++) counter2.add("some");
        for (int i = 0; i<6; i++) counter2.add("how");

    }

    @Test
    public void testTopWords() {
        List<String> words = counter.getTopWords();
        assertEquals(3,words.size());
        assertFalse(words.size() == 0);
        for (String word : words) {
            Pattern p = Pattern.compile("[a-z- 0-9]+");
            Matcher m = p.matcher(word);
            assertTrue(m.matches());
            System.out.println(word);
        }
        assertTrue(words.get(0).equals("how - 6"));
        assertTrue(words.get(1).equals("and - 5"));
        assertTrue(words.get(2).equals("some - 4"));
    }


    @Test
    public void testConsistency() {

        List<String> threeWords = counter.getTopWords();
        List<String> threeWords2 = counter.getTopWords();
        for (int i = 0; i < 3; i++) {
            assertEquals(threeWords.get(i),threeWords2.get(i));
        }
    }

    @Test
    public void testConversion() {
        int sum = 0;
        Map<String, Integer> map = counter.getWordCounts();
        assertTrue(map.size() == 6);
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            sum = sum + (int) pair.getValue();
            it.remove(); // avoids a ConcurrentModificationException
        }
        assertTrue(sum == 21);
    }
}
