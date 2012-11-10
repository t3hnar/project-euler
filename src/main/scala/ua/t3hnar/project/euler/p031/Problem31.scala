package ua.t3hnar.project.euler
package p031

import collection.SortedSet

/**
 * @author Yaroslav Klymko
 */
object Problem31 extends App {

  def ?(amount: Int, coins: List[Int]): Int = coins match {
    case Nil => 0
    case x :: xs =>
      if (x > amount) 0
      else if (amount == x) 1
      else ?(amount - x, coins) + ?(amount, xs)
  }

  assert(?(5, List(1, 2, 5)) == 4)
  assert(?(200, List(1, 2, 5, 10, 20, 50, 100, 200)) == 73682)
}
