import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by prestonbattin on 2/11/17.
 */
public class DuplicateFinderTest {


    DuplicateFinder find;

    @Before
    public void setup(){

        find = new DuplicateFinder();
        find.sameLength("cookies, c00kIes, cha!r, chair, flair, fla!r, p!pe, pipe, pope, type, typ@@@@@@@@, hook, hawk, h@#k");
    }

    @Test
    public void duplicatesTest(){

        String plit = "cookies, c00kIes, cha!r, chair, flair, fla!r, p!pe, pipe, pope, type, typ@@@@@@@@, hook, hawk, h@#k";

        String[] key =plit.split(",");
        System.out.println(key[0].toString());

        int expected = 6;
        int actual = find.duplictes;
        Assert.assertEquals("Testing dup finder", expected, actual);

    }
}
