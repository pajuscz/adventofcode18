package aoc.days.three


class ClaimRect(val id: String,
           var tlx: Int,
           var tly: Int,
           var width: Int,
           var height: Int) {

    companion object {
        fun parse(input: String): ClaimRect{

            val id = input.substringAfter("#").substringBefore(" @")
            val topLeftX = input.substringAfter("@ ").substringBefore(",").toInt()
            val topLeftY = input.substringAfter(",").substringBefore(":").toInt()
            val w = input.substringAfter(": ").substringBefore("x").toInt()
            val h = input.substringAfter("x").toInt()

            return ClaimRect(id, topLeftX, topLeftY, w, h)
        }
    }

}