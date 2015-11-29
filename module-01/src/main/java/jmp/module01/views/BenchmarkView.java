package jmp.module01.views;

import jmp.module01.beans.GroupEvaluation;

import java.util.List;

/**
 * Interface of view that represents view of benchmark to user
 */
public interface BenchmarkView {

    /**
     * Outputs a information of benchmark
     *
     * @param evaluations a {@link List} of evaluations that will be represented
     * @return a {@link Void}
     */
    public void view(List<GroupEvaluation> evaluations);

}