package jmp.module01.beans;

import java.util.List;

/**
 * Bean that contains group of {@link Evaluation} that locates in one {@link Class}
 */
public class GroupEvaluation {

    /**
     * The {@link Class} that contains tests
     */
    private Class test;

    /**
     * The {@link List} of {@link Evaluation}
     */
    private List<Evaluation> evaluations;

    public GroupEvaluation() {
    }

    public GroupEvaluation(Class test, List<Evaluation> evaluations) {
        this.test = test;
        this.evaluations = evaluations;
    }

    public Class getTest() {
        return test;
    }

    public void setTest(Class test) {
        this.test = test;
    }

    public List<Evaluation> getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(List<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }

}