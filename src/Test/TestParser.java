package Test;

import com.atli.Counter;
import com.atli.Parser;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestParser {

    Parser parser;
    Counter counter;
    Map<String, Integer> map;

    @Before
    public void before() {
        counter = new Counter();
        parser = new Parser("lyrics", counter);
    }

    @Rule  public ExpectedException thrown = ExpectedException.none();
    @Test
    public void testGoodFile() {
        Parser parser = new Parser("lyrics", counter);
    }

    @Test
    public void testBadFile() {
        parser = new Parser("oi.txt", counter);
    }

    @Test
    public void testOutput() {
        List<String> words = counter.getTopWords();
        assertFalse(words.size() == 0);
        for (String word : words) {
            Pattern p = Pattern.compile("[a-z- 0-9]+");
            Matcher m = p.matcher(word);
            assertTrue(m.matches());
        }
        assertTrue(words.get(0).equals("the - 10"));
        assertTrue(words.get(1).equals("if - 8"));
        assertTrue(words.get(2).equals("i - 7"));
    }

    @Test
    public void testConversion() {
        int sum = 0;
        Map<String, Integer> map = counter.getWordCounts();
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            sum = sum + (int) pair.getValue();
            //System.out.println(pair.getKey() + " " + pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }
        assertTrue(sum == 172);
    }
}
