package ua.t3hnar.project.euler
package p005

import primes.Primes.isPrime

/**
 * @author Yaroslav Klymko
 */

object SmallestNumberDividedBy extends App {

  def calculate(min: Long, max: Long) = {
    val primes = (min to max) filter isPrime
    (1L /: primes) {
      case (n, p) =>
        val pow = math.pow(max, (1d / p))
        n * math.pow(p, pow.floor).toLong
    }
  }
}
