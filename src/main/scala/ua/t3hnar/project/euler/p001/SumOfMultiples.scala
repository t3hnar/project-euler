package ua.t3hnar.project.euler.p001

/**
 * @author Yaroslav Klymko aka t3hnar
 */
object SumOfMultiples extends App {

  assert(calculate(0 until 1000, 3, 5) == 233168L)

  def calculate(ns: Seq[Int], ds: Int*): Long =
    (for (n <- ns; d <- ds if (n % d == 0)) yield n).toSet.sum
}