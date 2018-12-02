package aoc

import java.io.File

abstract class Assignment {

    abstract fun solve()

    protected open lateinit var result: String

    fun result(): String
    {
        return this.result
    }


    protected fun loadInputFile(path: String): File
    {
        return File(javaClass.getResource(path).file)
    }


}