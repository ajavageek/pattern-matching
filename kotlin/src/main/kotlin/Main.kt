package ch.frankel.blog

interface Shape
data class Rectangle(val length: Double, val width: Double) : Shape
data class Circle(val radius: Double) : Shape

fun getPerimeter(s: Shape) = when (s) {
    is Rectangle if s.length == s.width -> {
        println("Square detected")
        4 * s.length
    }

    is Rectangle -> 2 * s.length + 2 * s.width
    is Circle -> 2 * s.radius * Math.PI
    else -> throw IllegalArgumentException("Unknown shape")
}

fun main() {
    println(getPerimeter(Rectangle(2.0, 3.0)));
    println(getPerimeter(Rectangle(3.0, 3.0)));
    println(getPerimeter(Circle(3.0)));
}
