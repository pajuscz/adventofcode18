package aoc.days

import aoc.Assignment
import java.io.File

class TwoSecond: Assignment() {

    override fun solve(){
        val inputFile = loadInputFile("/Two/input.txt")
        val listOfLines = readFileAsLinesUsingUseLines(inputFile)

        val sortedListOfLines = listOfLines.sorted()
        val zippedSortedList = sortedListOfLines.zipWithNext()

        val resultingPair = getOneStringWithOneDifferenceFrom(zippedSortedList)

        result = removeDifferingCharacters(resultingPair.first, resultingPair.second)
    }

    private fun readFileAsLinesUsingUseLines(file: File): List<String>
            = file.useLines { it.toList() }

    fun numberOfDifferentCharacters(first: String, second: String): Int{
        assert(first.length == second.length)
        var differences = 0
        for(i in 0..first.length-1){
            if(first[i] != second[i]){
                differences++
            }
        }
        return differences
    }

    fun getOneStringWithOneDifferenceFrom(sortedZipList: List<Pair<String, String>>): Pair<String, String>{
        sortedZipList.forEach {
            val difference = numberOfDifferentCharacters(it.first, it.second)
            if(difference == 1){
                return it
            }
        }
        return Pair("","")
    }

    fun removeDifferingCharacters(first: String, second: String): String{
        assert(first.length == second.length)
        var resultingString = ""
        for(i in 0..first.length-1){
            if(first[i] == second[i]){
                resultingString += first[i]
            }
        }
        return resultingString
    }


}