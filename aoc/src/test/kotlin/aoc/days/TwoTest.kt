package aoc.days

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class TwoTest{

    @Test
    fun solveTest(){
        val asgn = Two()
        val listPairs = mutableListOf<Pair<Int?, Int?>>()

        listPairs.add(asgn.pairOf23("abcdef"))
        listPairs.add(asgn.pairOf23("bababc"))
        listPairs.add(asgn.pairOf23("abbcde"))
        listPairs.add(asgn.pairOf23("abcccd"))
        listPairs.add(asgn.pairOf23("aabcdd"))
        listPairs.add(asgn.pairOf23("abcdee"))
        listPairs.add(asgn.pairOf23("ababab"))

        val checkSum = asgn.checkSum(listPairs)
        Assertions.assertEquals(12, checkSum)
    }
}