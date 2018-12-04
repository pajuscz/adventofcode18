package aoc

import aoc.days.three.Three

fun main(args: Array<String>)
{
    val assignment = Three()
    assignment.solve()
    println("Solution: ${assignment.result()}, ${assignment.resultPartTwo()}")
}