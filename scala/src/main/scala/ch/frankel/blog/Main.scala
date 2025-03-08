package ch.frankel.blog

trait Shape
case class Rectangle(length: Double, width: Double) extends Shape
case class Circle(radius: Double) extends Shape

def getPerimeter(s: Shape) = {
  s match {
    case Rectangle(length, width) if length == width =>
      println("Square detected")
      4 * length
    case Rectangle(length, width) => 2 * length + 2 * width
    case Circle(radius) => 2 * radius * Math.PI
    case _ => throw new IllegalArgumentException("Unrecognized shape")
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    println(getPerimeter(Rectangle(3, 2)))
    println(getPerimeter(Rectangle(2, 2)))
    println(getPerimeter(Circle(3)))
  }
}
