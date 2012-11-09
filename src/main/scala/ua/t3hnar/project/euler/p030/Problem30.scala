package ua.t3hnar.project.euler
package p030

import math.pow
import RichNumeric._

/**
 * @author Yaroslav Klymko
 */
object Problem30 extends App {
  def ?(power: Int): Long = {
    val max = List.fill(power)('9').mkString.toInt
    def sumOfPoweredDigits(n: Long): Long = n.digits.map(x => pow(x, power).toLong).sum

    (2L to sumOfPoweredDigits(max))
      .filter(x => x == sumOfPoweredDigits(x))
      .sum
  }

  assert(?(4) == 19316)
  assert(?(5) == 443839)
}