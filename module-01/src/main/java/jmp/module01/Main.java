package jmp.module01;

import jmp.module01.beans.GroupEvaluation;
import jmp.module01.models.BenchmarkModel;
import jmp.module01.models.impl.MicroBenchmarkModel;
import jmp.module01.services.BenchmarkService;
import jmp.module01.services.ClassControlService;
import jmp.module01.services.impl.ClassPathClassControlService;
import jmp.module01.services.impl.MicroBenchmarkService;
import jmp.module01.utils.VmArgumentsUtils;
import jmp.module01.views.BenchmarkView;
import jmp.module01.views.impl.ConsoleBenchmarkView;

import java.util.List;

/**
 * Main class of Micro Benchmark Application
 */
public class Main {

    private static final String BENCHMARK_VM_ARGUMENT = "-b";

    /**
     * Creates benchmark model
     *
     * @return a {@link BenchmarkModel} model
     */
    private static BenchmarkModel createModel() {
        BenchmarkService microBenchmarkService = new MicroBenchmarkService();
        ClassControlService classPathClassControlService = new ClassPathClassControlService();
        return new MicroBenchmarkModel(microBenchmarkService, classPathClassControlService);
    }

    /**
     * Creates benchmark view
     *
     * @return a {@link BenchmarkView} view
     */
    private static BenchmarkView createView() {
        return new ConsoleBenchmarkView();
    }

    /**
     * Main method
     *
     * @param vmArguments a array of programm arguments
     * @return a {@link Void}
     */
    public static void main(String[] vmArguments) {
        List<String> classes = VmArgumentsUtils.findArgumentsByKey(BENCHMARK_VM_ARGUMENT, vmArguments);

        BenchmarkModel benchmarkModel = createModel();
        BenchmarkView benchmarkView = createView();

        List<GroupEvaluation> groupEvaluations = benchmarkModel.evaluate(classes);
        benchmarkView.view(groupEvaluations);
    }

}