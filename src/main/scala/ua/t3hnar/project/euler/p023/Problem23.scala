package ua.t3hnar.project.euler
package p023

import RichNumeric._

/**
 * @author Yaroslav Klymko
 */
object Problem23 extends App {
  Thread.sleep(10000)
  assert(isPerfect(28))

  def isDeficient(n: Long) = n.sumOfDivisors < n
  def isPerfect(n: Long) = n.sumOfDivisors == n
  def isAbundant(n: Long) = n.sumOfDivisors > n

  val limit = 28123
  val naturals = Naturals.stream.take(limit).toList
  val abundant = (naturals filter isAbundant).toList


  lazy val sums = {
    def loop(ns: List[Long], res: List[Long]): List[Long] = ns match {
      case Nil => res
      case x :: xs => loop(xs, ns.map(_ + x).takeWhile(_ <= limit) ::: res)
    }
    loop(abundant, Nil).toSet
  }

  def isSumOfAbundant(n: Long) = sums.contains(n)

  printlnMillis {
    assert(naturals.filterNot(isSumOfAbundant).sum == 4179871)
  }
}
