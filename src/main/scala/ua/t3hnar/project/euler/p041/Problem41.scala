package ua.t3hnar.project.euler
package p041

import RichNumeric._
import primes.Primes

/**
 * @author Yaroslav Klymko
 */
object Problem41 extends App {
  val ps = Primes.stream.takeWhile(_ < 7654321).toList

  def isPandigital(x: Long): Boolean = {
    val ds = x.digits
    ds.sorted == (1L to ds.size)
  }

  println(ps.reverse.find(isPandigital))
}