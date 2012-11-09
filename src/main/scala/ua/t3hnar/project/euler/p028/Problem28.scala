package ua.t3hnar.project.euler.p028

/**
 * @author Yaroslav Klymko
 */
object Problem28 extends App {

  def formula(n: Int): Long =
    if (n == 0) 1
    else 4 * math.pow((2 * n + 1), 2).toLong - 12 * n


  def sumOfDiagonals(n: Int): Long = ((0 to n / 2) map formula).sum

  assert(sumOfDiagonals(5) == 101)
  assert(sumOfDiagonals(1001) == 669171001L)
}
