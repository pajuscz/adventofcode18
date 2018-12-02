package aoc

import aoc.days.TwoSecond

fun main(args: Array<String>)
{
    val assignment = TwoSecond()
    assignment.solve()
    println("Solution: ${assignment.result()}")
}