package aoc.dayone

import java.io.File

class One()
{
    fun solve(): String
    {
        val inputFile = File(javaClass.getResource("/1/input.txt").file)
        var sum = 0
        inputFile.forEachLine {
            sum += it.toInt()
        }

        return sum.toString()
    }
}
