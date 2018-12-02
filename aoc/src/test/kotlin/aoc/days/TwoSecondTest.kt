package aoc.days

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.AssertionError
import kotlin.test.assertFailsWith

internal class TwoSecondTest{

    @Test
    fun testDifferences(){
        val asignment = TwoSecond()
        assertFailsWith<AssertionError> {
            asignment.numberOfDifferentCharacters("abc", "aseas")
        }
    }

    @Test
    fun sameStrings_ZeroDifferences(){
        val asignment = TwoSecond()
        val differences = asignment.numberOfDifferentCharacters("abc", "abc")
        Assertions.assertEquals(0 , differences)
    }

    @Test
    fun oneDifference(){
        val asignment = TwoSecond()
        val differences = asignment.numberOfDifferentCharacters("abc", "abd")
        Assertions.assertEquals(1 , differences)
    }

    @Test
    fun twoDifference(){
        val asignment = TwoSecond()
        val differences = asignment.numberOfDifferentCharacters("asdfghjil;", "asdrghjik;")
        Assertions.assertEquals(2 , differences)
    }

    @Test
    fun stringSizeFive_allDifferent(){
        val asignment = TwoSecond()
        val differences = asignment.numberOfDifferentCharacters("abuco", "lopab")
        Assertions.assertEquals(5 , differences)
    }

    @Test
    fun pairWithOneDifference(){
        val list = listOf("abcde",
                "fghij",
                "klmno",
                "pqrst",
                "fguij",
                "axcye",
                "wvxyz")

        val pairsOfList = list.sorted().zipWithNext()
        val asignment = TwoSecond()
        val resultingPair = asignment.getOneStringWithOneDifferenceFrom(pairsOfList)

        Assertions.assertEquals(Pair("fghij", "fguij"), resultingPair)
    }

    @Test
    fun removeDifferences(){
        val asignment = TwoSecond()
        val result = asignment.removeDifferingCharacters("fghij", "fguij")

        Assertions.assertEquals("fgij", result)

    }

}


