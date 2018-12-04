package aoc.days.three

import aoc.Assignment

class Three: Assignment() {

    override fun solve() {
        val inputFile = loadInputFile("/Three/input.txt")

        val rectList = mutableListOf<ClaimRect>()
        inputFile.forEachLine {
            rectList.add(ClaimRect.parse(it))
        }

        val maxX = rectList.map { a -> (a.tlx + a.height) }.max()
        val maxY = rectList.map { a -> (a.tly + a.width) }.max()

        val sheet = FabricSheet(maxX!! + 1, maxY!!+1)

        rectList.forEach {
            sheet.add(it)
        }

        result = sheet.numberOfIntersected().toString()

        rectList.forEach {
            if(sheet.overlaps(it)){
                resultPartTwo = it.id
                return@forEach
            }
        }
    }

    fun getIntersectingRects(rectangelList: List<XmasRectangle>): Set<XmasRectangle>
    {
        val resultingSetOfIds = rectangelList.flatMap {
            a -> rectangelList.map { b -> Pair(a,b) }
        }

        val intersectingRects = mutableSetOf<XmasRectangle>()
        resultingSetOfIds.forEach {
            if(it.first != it.second){
                if(it.first.intersects(it.second)){
                    intersectingRects.add(it.first)
                }
            }

        }

        return intersectingRects
    }
}



