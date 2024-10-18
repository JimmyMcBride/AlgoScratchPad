package sorting

import org.example.sorting.SortingAlgorithm
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class SortingAlgorithmsTest {
    companion object {
        @JvmStatic
        fun algorithms(): List<SortingAlgorithm> = listOf(
            SelectionSort(),
            BubbleSort(),
            InsertionSort(),
        )

        @JvmStatic
        fun testData(): Stream<Arguments> = Stream.of(
            Arguments.of(arrayOf<Int>(), arrayOf<Int>()), // empty array
            Arguments.of(arrayOf(1), arrayOf(1)), // single element array
            Arguments.of(arrayOf(5, 3, 8, 1, 2), arrayOf(1, 2, 3, 5, 8)), // small random array
            Arguments.of(arrayOf(1, 2, 3, 4, 5), arrayOf(1, 2, 3, 4, 5)), // already sorted
            Arguments.of(arrayOf(5, 4, 3, 2, 1), arrayOf(1, 2, 3, 4, 5)), // reverse sorted
            Arguments.of(arrayOf(3, 1, 2, 3, 1), arrayOf(1, 1, 2, 3, 3)), // with duplicates
            Arguments.of(arrayOf(-1, -3, -2, 5, 4), arrayOf(-3, -2, -1, 4, 5)), // with negative numbers
            Arguments.of((1..10000).shuffled().toTypedArray(), (1..10000).toList().toTypedArray()), // large numbers
        ).flatMap { args ->
            algorithms().map { algorithm ->
                Arguments.of(algorithm, args.get()[0], args.get()[1])
            }.stream()
        }
    }

    @ParameterizedTest(name = "{0} sorts correctly")
    @MethodSource("testData")
    fun `sorting algorithms sort correctly`(algorithm: SortingAlgorithm, input: Array<Int>, expected: Array<Int>) {
        val result = algorithm.sort(input.copyOf())
        assertArrayEquals(expected, result)
    }
}