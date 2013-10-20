package ua.t3hnar.project.euler
package p044

/**
 * @author Yaroslav Klymko
 */
object Problem44 extends App {
  def pentagonal(x: Int): Int = x * (3 * x - 1) / 2

  def ints(x: Int): Stream[Int] = x #:: ints(x + 1)

  val pentagonals = ints(1).map(pentagonal).takeWhile(_ < 10000000).toSet

  val pairs = for {
    p1 <- pentagonals
    p2 <- pentagonals
  } yield p1 -> p2


  println(pairs.find {
    case (p1, p2) => pentagonals.contains(p1 + p2) && pentagonals.contains(math.max(p1, p2) - math.min(p1, p2))
  }.map {
    case (p1, p2) => math.max(p1, p2) - math.min(p1, p2)
  })
}
