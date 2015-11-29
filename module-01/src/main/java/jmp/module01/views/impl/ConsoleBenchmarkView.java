package jmp.module01.views.impl;

import jmp.module01.beans.Evaluation;
import jmp.module01.beans.GroupEvaluation;
import jmp.module01.views.BenchmarkView;

import java.util.List;

/**
 * View that will be represented to user on console
 */
public class ConsoleBenchmarkView implements BenchmarkView {

    private static final String SEPARATOR_TEST_TEMPLATE = "----------------------------------------------------";
    private static final String TITLE_TEST_TEMPLATE = "Name    %-35s \n";
    private static final String TYPE_TEST_TEMPLATE = "Test    %-35s %-5d ns \n";

    /**
     * Prints a information of benchmark to console
     *
     * @param groupEvaluations a {@link List} of evaluations that will be represented
     * @return a {@link Void}
     * @throws {@link NullPointerException} if the groupEvaluations is {@code null}
     */
    @Override
    public void view(List<GroupEvaluation> groupEvaluations) {
        for(GroupEvaluation groupEvaluation : groupEvaluations) {
            System.out.println(SEPARATOR_TEST_TEMPLATE);
            System.out.printf(TITLE_TEST_TEMPLATE, groupEvaluation.getTest().getName());
            for (Evaluation evaluation : groupEvaluation.getEvaluations()) {
                System.out.printf(TYPE_TEST_TEMPLATE, evaluation.getName(), evaluation.getTime());
            }
        }

        if (! groupEvaluations.isEmpty()) {
            System.out.println(SEPARATOR_TEST_TEMPLATE);
        }
    }

}