package ua.t3hnar.project.euler
package p021

/**
 * @author Yaroslav Klymko
 */
object Problem21 extends App {

  def properDivisors(n: Int): Seq[Int] = (1 until n).filter(x => n % x == 0)

  def d(n: Int): Int = properDivisors(n).sum

  assert(properDivisors(220) == Seq(1, 2, 4, 5, 10, 11, 20, 22, 44, 55, 110))
  assert(properDivisors(284) == Seq(1, 2, 4, 71, 142))
  assert(d(220) == 284)


  def isAmicablePair(n1: Int, n2: Int): Boolean =
    n1 != n2 && d(n1) == n2 && d(n2) == n1

  def isAmicable(n: Int): Boolean = {
    val x = d(n)
    n != x && d(x) == n
  }

  assert(isAmicablePair(220, 284) == true)

  assert(((1 until 10000) filter isAmicable).sum == 31626)
}
