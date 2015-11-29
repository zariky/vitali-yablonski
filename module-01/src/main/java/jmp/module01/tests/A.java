package jmp.module01.tests;

import jmp.module01.utils.Benchmark;

import java.util.Random;

/**
 * Math.random() vs Random.nextDouble()
 */
public class A {

    @Benchmark(testName = "Math.random()")
    public double test1(Integer repetitions) {
        double result = 0;

        for(int i = 0; i < repetitions; i++){
            result += Math.random();
        }

        return result;
    }

    @Benchmark(testName = "Random.nextDouble()")
    public double test2(Integer repetitions) {
        Random random = new Random();
        double result = 0;

        for(int i = 0; i < repetitions; i++){
            result += random.nextDouble();
        }

        return result;
    }

}