package Test;

import com.atli.Parser;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestParser {

    @Rule  public ExpectedException thrown = ExpectedException.none();
    @Test
    public void testGoodFile() {
        Parser parser = new Parser("words.txt");
    }

    @Test
    public void testBadFile() {
        Parser parser = new Parser("oi.txt");
    }

    @Test
    public void testOutput() {
        Parser parser = new Parser("words.txt");
        List<String> words = parser.getWords();
        assertFalse(words.size() == 0);
        for (String word : words) {
            Pattern p = Pattern.compile("[\\w]+");
            Matcher m = p.matcher(word);
            assertTrue(m.matches());
            System.out.println(word);
        }
    }
}
