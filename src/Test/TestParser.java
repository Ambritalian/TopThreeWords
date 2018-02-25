package Test;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.FileNotFoundException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestParser {

    @Rule  public ExpectedException thrown= ExpectedException.none();
    @Test
    public void testGoodFile() {
        Parser parser = new Parser(FileName);
    }
    @Test
    public void testBadFile() {
        Parser parser = new Parser(FileName);
        thrown.expect(FileNotFoundException.class);
    }
    @Test
    public void testOutput() {
        Parser parser = new Parser(FileName);
        String[] words = parser.getWords();
        assertFalse(words.length == 0);
        for (String word : words) {
            assertFalse(word.equals(""));
            Pattern p = Pattern.compile("[a-z]+");
            Matcher m = p.matcher(word);
            assertTrue(m.matches());
        }
    }
}
