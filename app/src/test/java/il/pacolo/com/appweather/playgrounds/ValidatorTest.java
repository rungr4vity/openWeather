package il.pacolo.com.appweather.playgrounds;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ValidatorTest {


    Validator SUT;


    @Before
    public void setup() {
        SUT = new  Validator();
    }


    @Test
    public void test1() {
        boolean result = SUT.isPositive(-1);
        Assert.assertTrue(result);
    }
}