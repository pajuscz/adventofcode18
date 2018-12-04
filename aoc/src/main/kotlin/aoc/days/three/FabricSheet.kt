package aoc.days.three

import java.io.File

class FabricSheet(private val x: Int, private val y: Int) {

    private var sheet = arrayOf<Array<String>>()

    init {
        for (i in 0 until y) {
            var array = arrayOf<String>()
            for (j in 0 until x) {
                array += "."
            }
            sheet += array
        }
    }

    fun add(rect: ClaimRect)
    {
        for(y in rect.tly until (rect.tly + rect.height)){
            for(x in rect.tlx until (rect.tlx + rect.width)){
                if(sheet[y][x] == "."){
                    sheet[y][x] = rect.id
                }
                else{
                    sheet[y][x] = "X"
                }

            }
        }
    }

    fun overlaps(rect: ClaimRect): Boolean
    {
        for(y in rect.tly until (rect.tly + rect.height)){
            for(x in rect.tlx until (rect.tlx + rect.width)){
                if(sheet[y][x] != rect.id){
                   return false
                }
            }
        }
        return true
    }

    fun print()
    {
        for(y in 0 until this.y) {
            for (x in 0 until this.x) {
                val suffixLen = 5 - sheet[y][x].length
                print("${sheet[y][x]}" + " ".repeat(suffixLen))
            }
            println()
        }
    }

    fun numberOfIntersected(): Int {
        var count = 0
        for (y in 0 until this.y) {
            for (x in 0 until this.x) {
                if (sheet[y][x] == "X") count++

            }
        }
        return count
    }

    override fun toString(): String {
        return "Sheet: $x x $y"
    }

}