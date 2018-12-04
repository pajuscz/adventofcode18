package aoc

import java.io.File

abstract class Assignment {

    abstract fun solve()

    protected open lateinit var result: String
    protected open lateinit var resultPartTwo: String

    fun result(): String
    {
        return this.result
    }

    fun resultPartTwo(): String
    {
        return this.resultPartTwo
    }


    protected fun loadInputFile(path: String): File
    {
        return File(javaClass.getResource(path).file)
    }


}