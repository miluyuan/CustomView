package com.example.customview.demo.bagua

/**
 * @author wzw
 * @date 2019/6/19 14:55
 */
class Point {
    var x: Float = 0.toFloat()
    var y: Float = 0.toFloat()

    constructor() {}

    constructor(x: Int, y: Int) {
        this.x = x.toFloat()
        this.y = y.toFloat()
    }

    constructor(src: Point) {
        this.x = src.x
        this.y = src.y
    }

    /**
     * Set the point's x and y coordinates
     */
    operator fun set(x: Float, y: Float) {
        this.x = x
        this.y = y
    }

 /**
     * Set the point's x and y coordinates
     */
    fun set(src: Point) {
        this.x = src.x
        this.y = src.y
    }

    /**
     * Negate the point's coordinates
     */
    fun negate() {
        x = -x
        y = -y
    }

    /**
     * Offset the point's coordinates by dx, dy
     */
    fun offset(dx: Float, dy: Float) {
        x += dx
        y += dy
    }

    /**
     * Returns true if the point's coordinates equal (x,y)
     */
    fun equals(x: Float, y: Float): Boolean {
        return this.x == x && this.y == y
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val point = o as android.graphics.Point?

        if (x != point!!.x.toFloat()) return false
        return if (y != point.y.toFloat()) false else true

    }

    override fun hashCode(): Int {
        var result = x
        result = 31 * result + y
        return result.toInt()
    }

    override fun toString(): String {
        return "Point($x, $y)"
    }
}
