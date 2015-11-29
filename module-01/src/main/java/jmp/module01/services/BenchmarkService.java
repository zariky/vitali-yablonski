package jmp.module01.services;

import jmp.module01.beans.GroupEvaluation;

import java.util.List;

/**
 * Interface of service that does benchmark
 */
public interface BenchmarkService {

    /**
     * Evaluates tests
     *
     * @param tests a {@link List} of {@link Class} that contains tests
     * @return a {@link List} of {@link GroupEvaluation} that contains evaluations
     */
    public List<GroupEvaluation> evaluate(List<Class> tests);

}