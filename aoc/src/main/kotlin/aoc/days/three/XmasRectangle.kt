package aoc.days.three

import java.awt.Rectangle

open class XmasRectangle(x: Int, y: Int, width: Int, height: Int, val id: String): Rectangle(x, y, width, height) {
    companion object {
        fun parse(input: String): XmasRectangle{

            val id = input.substringAfter("#").substringBefore(" @")
            val x = input.substringAfter("@ ").substringBefore(",").toInt()
            val y = input.substringAfter(",").substringBefore(":").toInt()
            val w = input.substringAfter(": ").substringBefore("x").toInt()
            val h = input.substringAfter("x").toInt()

            return XmasRectangle(x, y, w, h, id)
        }
    }

    override fun toString(): String {
        return "#${this.id} ${this.x},${this.y}:${this.width}x${this.height}"
    }
}