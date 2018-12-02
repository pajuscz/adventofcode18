package aoc.days

import aoc.Assignment

class Two: Assignment() {

    override fun solve(){
        val inputFile = loadInputFile("/Two/input.txt")
        val listOfPairOccurances = mutableListOf<Pair<Int?, Int?>>()
        inputFile.forEachLine {
            listOfPairOccurances.add(pairOf23(it))
        }
        result = checkSum(listOfPairOccurances).toString()
    }

    fun pairOf23(input: String): Pair<Int?, Int?> {
        val countMap = countMapOf23(input)
        return twoThreeOccurances(countMap)
    }

    private fun countMapOf23(input: String): Map<Char, Int> {
        return input.groupingBy{it}
                .eachCount()
                .filterValues { it == 2 || it == 3 }
    }

    private fun twoThreeOccurances(countMap: Map<Char, Int>): Pair<Int?, Int?> {
        val counts23pair = countMap.values.groupBy{it}
        return Pair(counts23pair[2]?.size, counts23pair[3]?.size)
    }

    fun checkSum(counts23: List<Pair<Int?,Int?>>): Int{
        val countOf2 = counts23.filter { it.first != null}  .count()
        val countOf3 = counts23.filter { it.second != null }.count()
        return countOf2 * countOf3
    }

}