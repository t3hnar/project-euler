package ua.t3hnar.project.euler

import Naturals.{stream => naturals}
/**
 * @author Yaroslav Klymko
 */
object Triangles {
  val stream: Stream[Long] = {
    def f(n: Long) = n * (n + 1) / 2
    naturals map f
  }

  def isTriangle(n: Long): Boolean = {
    val x = (math.sqrt(8 * n + 1) - 1) / 2
    x == x.toInt
  }
}