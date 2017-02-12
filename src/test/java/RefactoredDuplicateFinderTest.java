import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by prestonbattin on 2/12/17.
 */
public class RefactoredDuplicateFinderTest {

    RefactoredDuplicateFinder refactoredDuplicateFinder;
    String[] test;

    @Before
    public void setup(){

        refactoredDuplicateFinder = new RefactoredDuplicateFinder();
        test = refactoredDuplicateFinder.splitTextToArray("Yolo, Hello, Yes");
    }

    @Test
    public void splitTextToArray(){


        String expected = "[Hello, Yes, Yolo]";
        String actual = Arrays.toString(test);
        Assert.assertEquals("Testing method splits and sorts input", expected, actual);
    }

    @Test
    public void ifStringLengthIsSameTest(){


        test = new String[] {"Test", "Tate"};
        refactoredDuplicateFinder.ifStringsLengthIsSame(test);
        int expected = 3;
        int actual = refactoredDuplicateFinder.getStringPatternCountOne();
        Assert.assertEquals("Testing method that counts differences in string", expected, actual);
    }

    @Test
    public void compareSecondCharTest(){

        test = new String[]{"Apple" , "App"};
        refactoredDuplicateFinder.compareSecondChar(test);
        int expected = 1;
        int actual = refactoredDuplicateFinder.getCharCount();
        Assert.assertEquals("Testing method that raises char count by one if second" +
                "char matches", expected, actual);
    }

    @Test
    public void compareLastCharTest(){

        test = new String[]{"Test", "Test"};
        refactoredDuplicateFinder.compareLastChar(test);
        int expected = 1;
        int actual = refactoredDuplicateFinder.getCharCount();
        Assert.assertEquals("Testing method that raises char count by one if last" +
                "chars are the same", expected, actual);
    }

    @Test
    public void compareSecondToLastCharTest(){

        test = new String[]{"Tape", "Test"};
        refactoredDuplicateFinder.compareSecondToLastChar(test);
        int expected = 0;
        int actual = refactoredDuplicateFinder.getCharCount();
        Assert.assertEquals("Testing method that raises char count by one if second to last" +
                "chars are the same", expected, actual);
    }

    @Test
    public void lengthsEvenAndLessThanSixCharTest(){

        test = new String[]{"Test", "Test"};
        refactoredDuplicateFinder.compareSecondChar(test);
        refactoredDuplicateFinder.compareLastChar(test);
        refactoredDuplicateFinder.lengthsEvenAndLessThanSixChar();
        int expected = 1;
        int actual = refactoredDuplicateFinder.getDuplicates();
        Assert.assertEquals("Testing method that raises duplicate count by one if criteria" +
                "are meet", expected, actual);
    }

    @Test
    public void lengthsEvenAndMoreThanSixCharTest(){

        test = new String[]{"Testing", "T!st1n@"};
        refactoredDuplicateFinder.compareSecondChar(test);
        refactoredDuplicateFinder.compareLastChar(test);
        refactoredDuplicateFinder.compareSecondToLastChar(test);
        refactoredDuplicateFinder.lengthsEvenAndMoreThanSixChar();
        int expected = 1;
        int actual = refactoredDuplicateFinder.getDuplicates();
        Assert.assertEquals("Testing method that raises duplicate count by one if criteria" +
                "are meet", expected, actual);

    }

    @Test
    public void ifStringLengthsAreDifferentTest(){

        test = new String[]{"Test", "Testing"};
        refactoredDuplicateFinder.ifStringLengthsAreDifferent(test);
        int expected = 6;
        int actual = refactoredDuplicateFinder.getStringPatternCountTwo();
        Assert.assertEquals("Testing method that raises count by one for different string lengths" +
                "if criteria is meet", expected, actual);
    }

    @Test
    public void lengthNotEvenAndLessThanSixCharTest(){

        test = new String[]{"Test", "Testin"};
        refactoredDuplicateFinder.ifStringLengthsAreDifferent(test);
        refactoredDuplicateFinder.compareSecondChar(test);
        refactoredDuplicateFinder.compareSecondToLastChar(test);
        refactoredDuplicateFinder.compareLastChar(test);
        refactoredDuplicateFinder.lengthNotEvenAndLessThanSixChar();

        int expected = 0;
        int actual = refactoredDuplicateFinder.getDuplicates();
        Assert.assertEquals("Testing method that raises  duplicates by one for different string lengths" +
                "if criteria is meet", expected, actual);
    }

    @Test
    public void lengthNotEvenAndMoreThanSixCharTest(){

        test = new String[]{"Testtttt","Test"};
        refactoredDuplicateFinder.ifStringLengthsAreDifferent(test);
        refactoredDuplicateFinder.compareSecondChar(test);
        refactoredDuplicateFinder.compareSecondToLastChar(test);
        refactoredDuplicateFinder.compareLastChar(test);
        refactoredDuplicateFinder.lengthNotEvenAndMoreThanSixChar();
        int expected = 1;
        int actual = refactoredDuplicateFinder.getDuplicates();
        Assert.assertEquals("Testing method that raises  duplicate count by one for different string lengths" +
                "if criteria is meet", expected, actual);
    }

}
