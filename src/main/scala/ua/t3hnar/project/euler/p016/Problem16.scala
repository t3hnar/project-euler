package ua.t3hnar.project.euler.p016

/**
 * @author Yaroslav Klymko
 */
object Problem16 extends App {

  def sum(x: Int, y: Int): Long =
    BigInt(x).pow(y).toString().map(_.asDigit).sum

  assert(sum(2, 15) == 26)
  assert(sum(2, 1000) == 1366)
}
