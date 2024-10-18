package sorting

import org.example.sorting.SortingAlgorithm

class BubbleSort : SortingAlgorithm {
    override fun sort(array: Array<Int>): Array<Int> {
        for (i in array.indices) {
            for (j in array.size - 1 downTo i + 1) {
                if (array[j - 1] > array[j]) {
                    val temp = array[j - 1]
                    array[j - 1] = array[j]
                    array[j] = temp
                }
            }
        }
        return array
    }
}