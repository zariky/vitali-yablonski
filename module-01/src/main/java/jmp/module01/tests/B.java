package jmp.module01.tests;

import jmp.module01.utils.Benchmark;

/**
 * StringBuffer.append() vs StringBuilder.append()
 */
public class B {

    @Benchmark(testName = "StringBuffer.append()")
    public String test1(Integer repetitions) {
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < repetitions; i++){
            sb.append(i);
        }

        return sb.toString();
    }

    @Benchmark(testName = "StringBuilder.append()")
    public String test2(Integer repetitions) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < repetitions; i++){
            sb.append(i);
        }

        return sb.toString();
    }

}