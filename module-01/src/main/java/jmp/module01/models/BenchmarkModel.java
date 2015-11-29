package jmp.module01.models;

import jmp.module01.beans.GroupEvaluation;

import java.util.List;

/**
 * Interface of model that performs benchmark
 */
public interface BenchmarkModel {

    /**
     * Evaluates tests
     *
     * @param tests a {@link List} of tests
     * @return a {@link List} of evaluations
     */
    public List<GroupEvaluation> evaluate(List<String> tests);

}