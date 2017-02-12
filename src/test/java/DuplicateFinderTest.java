import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by prestonbattin on 2/11/17.
 */
public class DuplicateFinderTest {


    DuplicateFinder find;

    @Before
    public void setup() {

        find = new DuplicateFinder();
        find.sameLength("jazz,buzz,fuzzs,f@zzs,fu**s,fizzs,hajj,juju,ju##s,quiz,razz,r@zz,jezz,jexxs,je**s,jeux,j@#k,jinx,jock,j&ck,j0$k,jack,jamb,juku,joky,j0ck,j0k$,jivy,junk,jimp");}
    @Test
    public void duplicatesTest(){


        int expected = 5;
        int actual = find.duplictes;
        Assert.assertEquals("Testing dup finder", expected, actual);

    }
}
