package aoc.days.three

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class XmasRectangleTest {

    @Test
    fun parse() {

        val input = "#123 @ 12,21: 2x8"
        val rect = XmasRectangle.parse(input)

        Assertions.assertEquals("123", rect.id)
        Assertions.assertEquals(12, rect.x)
        Assertions.assertEquals(21, rect.y)
        Assertions.assertEquals(2, rect.width)
        Assertions.assertEquals(8, rect.height)
    }

    @Test
    fun intersects() {
        val rectA = XmasRectangle.parse("#1 @ 1,3: 4x4")
        val rectB = XmasRectangle.parse("#2 @ 3,1: 4x4")
        val rectC = XmasRectangle.parse("#3 @ 5,5: 2x2")

        Assertions.assertEquals(true, rectA.intersects(rectB))
        Assertions.assertEquals(true, rectB.intersects(rectA))
        Assertions.assertEquals(false, rectA.intersects(rectC))
        Assertions.assertEquals(false, rectC.intersects(rectB))
    }

    @Test
    fun intersectsMap() {

        val rectA = XmasRectangle.parse("#1 @ 1,3: 4x4")
        val rectB = XmasRectangle.parse("#2 @ 3,1: 4x4")
        val rectC = XmasRectangle.parse("#3 @ 5,5: 2x2")

        val listRect = listOf<XmasRectangle>(rectA, rectB, rectC)

        val asignment = Three()
        val intersectingRects = asignment.getIntersectingRects(listRect)

        Assertions.assertEquals(2, intersectingRects.size)
        Assertions.assertEquals(true, intersectingRects.contains(XmasRectangle(1,3,4,4,"1")))
        Assertions.assertEquals(true, intersectingRects.contains(XmasRectangle(3,1,4,4,"2")))
        Assertions.assertEquals(false, intersectingRects.contains(XmasRectangle(5,5,2,2,"3")))
    }

    @Test
    fun howManyIntersections() {


        val rectList = listOf<ClaimRect>(
                ClaimRect.parse("#1 @ 1,3: 4x4"),
                ClaimRect.parse("#2 @ 3,1: 4x4"),
                ClaimRect.parse("#3 @ 5,5: 2x2")

        )

        val maxX = rectList.map { a -> (a.tlx + a.height) }.max()
        val maxY = rectList.map { a -> (a.tly + a.width) }.max()
        val sheet = FabricSheet(maxX!! + 1, maxY!! + 1)

        println(sheet)
        rectList.forEach {
            sheet.add(it)
        }
        sheet.print()

        Assertions.assertEquals(4, sheet.numberOfIntersected())
    }

    @Test
    fun overlaps(){
        val rectList = listOf(
                ClaimRect.parse("#1 @ 1,3: 4x4"),
                ClaimRect.parse("#2 @ 3,1: 4x4"),
                ClaimRect.parse("#3 @ 5,5: 2x2")
        )

        val maxX = rectList.map { a -> (a.tlx + a.height) }.max()
        val maxY = rectList.map { a -> (a.tly + a.width) }.max()
        val sheet = FabricSheet(maxX!! + 1, maxY!! + 1)

        println(sheet)
        rectList.forEach {
            sheet.add(it)
        }
        sheet.print()
        val overlaps = sheet.overlaps(ClaimRect.parse("#3 @ 5,5: 2x2"))

        Assertions.assertEquals(true, overlaps)
    }





}



