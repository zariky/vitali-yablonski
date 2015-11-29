package jmp.module01.services.impl;

import jmp.module01.beans.Evaluation;
import jmp.module01.beans.GroupEvaluation;
import jmp.module01.services.BenchmarkService;
import jmp.module01.utils.Benchmark;
import jmp.module01.utils.ClassUtils;
import jmp.module01.utils.MethodUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Service that does micro benchmark
 */
public class MicroBenchmarkService implements BenchmarkService {

    /**
     * The count of repetitions
     */
    private static final Integer REPETITIONS = 1000000;

    /**
     * Evaluates some group of tests that was marked annotation {@link Benchmark}
     *
     * @param tests a {@link List} of {@link Class} that contains tests
     * @return a {@link List} of {@link GroupEvaluation} that contains evaluations
     * @throws {@link NullPointerException} if the tests is {@code null}
     */
    @Override
    public List<GroupEvaluation> evaluate(List<Class> tests) {
        List<GroupEvaluation> evaluations = new ArrayList<GroupEvaluation>();

        for(Class test : tests) {
            GroupEvaluation groupEvaluation = evaluateGroupTest(test);
            if (groupEvaluation != null) {
                evaluations.add(groupEvaluation);
            }
        }

        return evaluations;
    }

    /**
     * Evaluates some tests that was located in {@link Class} and marked annotation {@link Benchmark}
     *
     * @param groupTest a {Class} that contains tests
     * @return a {@link GroupEvaluation} that contains evaluation of groupTest
     * @throws {@link NullPointerException} if the groupTest is {@code null}
     */
    private GroupEvaluation evaluateGroupTest(Class<?> groupTest) {
        GroupEvaluation groupEvaluation = null;
        List<Evaluation> evaluations = new ArrayList<Evaluation>();
        List<Method> tests = MethodUtils.getMethodsWithAnnotation(groupTest, Benchmark.class);

        if( ! tests.isEmpty()) {
            for (Method test : tests) {
                Evaluation evaluation = evaluateTest(groupTest, test);
                if(evaluation != null){
                    evaluations.add(evaluation);
                }
            }
        }

        if ( ! evaluations.isEmpty()){
            groupEvaluation = new GroupEvaluation(groupTest, evaluations);
        }

        return groupEvaluation;
    }

    /**
     * Evaluates test
     *
     * @param groupTest a {@link Class} that contains a tests
     * @param test a {@link Method} that contains a test
     * @return a {@link Evaluation} that stores all information of benchmark
     * @throws {@link NullPointerException} if the groupTest or test are {@code null}
     */
    private Evaluation evaluateTest(Class<?> groupTest, Method test) {
        Evaluation evaluation = null;
        Object instanceGroupTest = ClassUtils.createInstance(groupTest);

        if (instanceGroupTest != null) {
            long start = System.nanoTime();
            Object result = MethodUtils.executeMethod(instanceGroupTest, test, new Object[]{REPETITIONS});
            long end = System.nanoTime();

            if (result != null) {
                String testName = test.getAnnotation(Benchmark.class).testName();
                evaluation = new Evaluation(testName, (end - start) / REPETITIONS, test);
            }
        }

        return evaluation;
    }

}