package ua.t3hnar.project.euler
package p016

import RichNumeric._

/**
 * @author Yaroslav Klymko
 */
object Problem16 extends App {
  def sumOfDigits(x: Int, y: Int) = (BigInt(x) pow y).sumOfDigits

  assert(sumOfDigits(2, 15) == 26)
  assert(sumOfDigits(2, 1000) == 1366)
}