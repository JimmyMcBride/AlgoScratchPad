package sorting

import org.example.sorting.SortingAlgorithm

class SelectionSort : SortingAlgorithm {
    override fun sort(array: Array<Int>): Array<Int> {
        for (i in array.indices) {
            var minValue = array[i]
            var minIndex = i
            for (j in i + 1..<array.size) {
                if (array[j] < minValue) {
                    minValue = array[j]
                    minIndex = j
                }
            }
            val big = array[i]
            val little = array[minIndex]
            array[i] = little
            array[minIndex] = big
        }
        return array
    }
}