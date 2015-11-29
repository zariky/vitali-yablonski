package jmp.module01.models.impl;

import jmp.module01.beans.GroupEvaluation;
import jmp.module01.models.BenchmarkModel;
import jmp.module01.services.BenchmarkService;
import jmp.module01.services.ClassControlService;

import java.util.List;

/**
 * Model that performs benchmark
 */
public class MicroBenchmarkModel implements BenchmarkModel {

    private BenchmarkService benchmarkService;
    private ClassControlService classControlService;

    /**
     * Constructor of {@link MicroBenchmarkModel}
     *
     * @param benchmarkService a {@link BenchmarkService} that does benchmark
     * @param classControlService a {@link ClassControlService} that searches classes for benchmark
     */
    public MicroBenchmarkModel(BenchmarkService benchmarkService, ClassControlService classControlService) {
        this.benchmarkService = benchmarkService;
        this.classControlService = classControlService;
    }

    /**
     * Evaluates some tests that was marked annotation {@link jmp.module01.utils.Benchmark}
     *
     * @param classes a {@link List} of classes
     * @return a {@link List} of {@link GroupEvaluation} that contains evaluations
     */
    public List<GroupEvaluation> evaluate(List<String> classes) {
        List<Class> validClasses = classControlService.findByClassNames(classes);
        List<GroupEvaluation> groupEvaluations = benchmarkService.evaluate(validClasses);
        return groupEvaluations;
    }

}