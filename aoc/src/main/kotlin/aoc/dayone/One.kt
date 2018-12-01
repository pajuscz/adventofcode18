package aoc.dayone

import java.io.File

class One
{

    private val results = mutableSetOf<Int>()
    private val inputFile = File(javaClass.getResource("/1/input.txt").file)


    private fun readFileLines(): List<String>
            = inputFile.bufferedReader().readLines()

    fun solve(): String
    {
        var sum = 0

        readFileLines().forEach {
            sum += it.toInt()
        }
        return sum.toString()
    }

    fun solvePartTwo(): String
    {
        var sum = 0
        results.add(sum)

        while(true){
            readFileLines().forEach {
                sum += it.toInt()
                if (results.contains(sum))
                {
                    return sum.toString()
                }
                results.add(sum)
            }
        }

    }


}
