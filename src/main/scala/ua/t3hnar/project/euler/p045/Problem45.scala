package ua.t3hnar.project.euler
package p045

/**
 * @author Yaroslav Klymko
 */
object Problem45 extends App {
  def triangle(x: Long) = x * (x + 1) / 2

  def pentagonal(x: Long) = x * (3 * x - 1) / 2

  def hexagonal(x: Long) = x * (2 * x - 1)

  val ints = {
    def loop(x: Int): Stream[Long] = x #:: loop(x + 1)
    loop(1)
  }

  val start = 40755
  val triangls = ints.map(triangle).dropWhile(_ <= start)
  val pentagonals = ints.map(pentagonal).dropWhile(_ <= start)
  val hexagonals = ints.map(hexagonal).dropWhile(_ <= start)


  def loop(xs: Stream[Long], ys: Stream[Long], zs: Stream[Long]): Long = {
    if (xs.head == ys.head && xs.head == zs.head) xs.head
    else if (xs.head > ys.head) loop(xs, ys.tail, zs)
    else if (xs.head > zs.head) loop(xs, ys, zs.tail)
    else loop(xs.tail, ys, zs)
  }

  println(loop(triangls, pentagonals, hexagonals))
}
