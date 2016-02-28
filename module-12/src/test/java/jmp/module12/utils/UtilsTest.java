package jmp.module12.utils;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.util.Random;
import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class UtilsTest {

    @Test
    public void testJoin_nullArrayShouldBeEqualToEmptyString() {
        assertEquals("", Utils.join(null));
    }

    @Test
    public void testJoin_emptyArrayShouldBeEqualToEmptyString() {
        Object[] array = {};
        assertEquals("", Utils.join(array));
    }

    @Test
    public void testJoin_notEmptyArrayShouldBeEqualToStringWithJoinedArrayElements() {
        Object[] array = {1, "2", -3, false};
        assertEquals("1,2,-3,false", Utils.join(array));
    }

    @Test
    public void testJoin_notEmptyArrayWithNullElementsShouldBeEqualToStringWithJoinedArrayElementsWithoutNullArrayElements() {
        Object[] array = {null, "2", null, 3};
        assertEquals(",2,,3", Utils.join(array));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFactorial_throwRuntimeExceptionWhenPassedNegativeNumber() {
        long number = -5;
        Utils.factorial(number);
    }

    @Test
    public void testFactorial_returnNumberOneWhenPassedNumberZero() {
        assertEquals(1, Utils.factorial(0));
    }

    @Test
    public void testFactorial_returnNumberOneWhenPassedNumberOne() {
        assertEquals(1, Utils.factorial(1));
    }

    @Test
    public void testFactorial_returnPositiveNumberWhenPassedPositiveNumber() {
        assertEquals(120, Utils.factorial(5));
    }

    @Test(timeout = 3)
    public void testFactorial_calculateFactorialFromRandomPositiveNumberWithTimeout() {
        Random random = new Random();
        int minNumber = 0;
        int maxNumber = 100;
        int randomNumber = random.nextInt(maxNumber - minNumber + 1) + minNumber;
        assertNotNull(Utils.factorial(randomNumber));
    }

    @Test
    public void testNormalize_nullWordShouldBeEqualToEmptyString() {
        assertEquals("", Utils.normalize(null));
    }

    @Test
    public void testNormalize_emptyWordShouldBeEqualToEmptyString() {
        assertEquals("", Utils.normalize(""));
    }

    @Test
    public void testNormalize_emptyWordWithSpacesShouldBeEqualToEmptyString() {
        assertEquals("", Utils.normalize(" "));
    }

    @Test
    @Ignore
    public void testNormalize_notEmptyWordWithSpacesShouldBeEqualToNormalizeString() {
        assertEquals("Test", Utils.normalize(" test "));
    }

}