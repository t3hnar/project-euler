package ua.t3hnar.project.euler
package p020

import RichNumeric._

/**
 * @author Yaroslav Klymko
 */
object Problem20 extends App {
  assert(10L.! == 3628800L)
  assert(10L.!.sumOfDigits == 27)
  assert(BigInt(100).!.sumOfDigits == 648)
}
