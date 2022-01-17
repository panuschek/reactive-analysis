package de.pan.springimperative.benchmark

import org.junit.jupiter.api.Test
import org.openjdk.jmh.results.format.ResultFormatType
import org.openjdk.jmh.runner.Runner
import org.openjdk.jmh.runner.options.OptionsBuilder

abstract class AbstractBenchmark {
    private val MEASUREMENT_ITERATIONS = 3
    private val WARMUP_ITERATIONS = 3

    @Test
    fun executeJmhRunner() {
        val options = OptionsBuilder()
            .include("\\." + javaClass.simpleName + "\\.")
            .warmupIterations(WARMUP_ITERATIONS)
            .measurementIterations(MEASUREMENT_ITERATIONS)
            .forks(0)
            .threads(1)
            .shouldDoGC(true)
            .shouldFailOnError(true)
            .resultFormat(ResultFormatType.JSON)
            .result("result.txt")
            .jvmArgs("-server")
            .build()

        Runner(options).run()
    }
}