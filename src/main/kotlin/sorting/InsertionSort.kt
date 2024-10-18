package sorting

import org.example.sorting.SortingAlgorithm

class InsertionSort : SortingAlgorithm {
    override fun sort(array: Array<Int>): Array<Int> {
        for (i in array.indices) {
            val right = array[i]
            var leftIndex = i - 1
            while (leftIndex >= 0 && array[leftIndex] > right) {
                array[leftIndex + 1] = array[leftIndex]
                leftIndex--
            }
            array[leftIndex + 1] = right
        }
        return array
    }
}