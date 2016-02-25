package jmp.module12;

import jmp.module12.utils.Utils;

/*
Utilities class test coverage:
+ 1. Create class Utils.
+ 2. Write a test for concatenateWords method using AssertEquals.
+ 3. Create test method testComputeFactorial.
        4. Add method testFactorialWithTimeout, that calculates factorial of random number. Add possibility of timeout and interruption of thread if time for method execution will be exceeded
+ 5. Add method testExpectedException for calling computeFactorial with variable "-5". Add corresponding parameter to the annotation @Test for IllegalArgumentException raising when necessary as the result of test execution
+ 6. To disable test add annotation @Ignore under the annotation @Test. Disable test method testNormalizeWord.
+ 7. All the tests should contain necessary annotations (@BeforeClass,@Before,@After,@AfterClass)
*/

/**
 * The main class
 */
public class Main {

    /**
     * The main method
     * @param vmArguments a array of programm arguments
     */
    public static void main(String[] vmArguments) {
        Object[] array1 = {"1", 2, "3"};
        Object[] array2 = {"1", 2, null, true};

        println(Utils.join(null));
        println(Utils.join(array1));
        println(Utils.join(array2));

        println(Utils.factorial(0));
        println(Utils.factorial(1));
        println(Utils.factorial(5));

        println(Utils.normalize(null));
        println(Utils.normalize(""));
        println(Utils.normalize(" "));
        println(Utils.normalize(" t "));
        println(Utils.normalize(" test "));
    }

    private static void println(Object value) {
        System.out.println("|" + value + "|");
    }

}