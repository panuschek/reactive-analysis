package de.pan.springimperative

import de.pan.springimperative.api.entity.VehicleConfiguration
import de.pan.springimperative.repository.VehicleConfigurationRepository
import org.junit.jupiter.api.Test
import org.openjdk.jmh.annotations.*
import org.openjdk.jmh.results.format.ResultFormatType
import org.openjdk.jmh.runner.Runner
import org.openjdk.jmh.runner.options.OptionsBuilder
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.concurrent.TimeUnit

@SpringBootTest
@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
class RepositoryTest {
    private val log = LoggerFactory.getLogger(javaClass)
    private lateinit var repository: VehicleConfigurationRepository

    @Autowired
    fun setVehicleConfigurationRepository(repository: VehicleConfigurationRepository) {
        this.repository = repository
    }

    @Test
    fun test() {
        log.warn("TEST()")
    }

    @Test
    fun executeJmhRunner() {
        val options = OptionsBuilder()
            .include("\\." + javaClass.simpleName + "\\.")
            .warmupIterations(3)
            .measurementIterations(3)
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

    @Benchmark
    fun setup() {
        repository.save(VehicleConfiguration(
            createdAt = 123456L,
            model = "Car",
            countryIds = arrayOf(1, 2, 3, 4),
            engineTypes = arrayOf("a", "b"),
            markets = arrayOf("a", "b"),
            structureVersion = "1.17"
        ))
    }
}