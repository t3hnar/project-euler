package ua.t3hnar.project.euler
package p021

import RichNumeric._
/**
 * @author Yaroslav Klymko
 */
object Problem21 extends App {

  def d(n: Long): Long = n.sumOfDivisors

  assert(220L.properDivisors == Seq(1, 2, 4, 5, 10, 11, 20, 22, 44, 55, 110))
  assert(282L.properDivisors == Seq(1, 2, 4, 71, 142))
  assert(d(220) == 284)


  def isAmicablePair(n1: Long, n2: Long): Boolean =
    n1 != n2 && d(n1) == n2 && d(n2) == n1

  def isAmicable(n: Long): Boolean = {
    val x = d(n)
    n != x && d(x) == n
  }

  assert(isAmicablePair(220, 284) == true)

  assert(((1L until 10000) filter isAmicable).sum == 31626)
}
