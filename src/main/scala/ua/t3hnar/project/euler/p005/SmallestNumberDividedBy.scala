package ua.t3hnar.project.euler
package p005

import primes.Primes

/**
 * @author Yaroslav Klymko
 */

object SmallestNumberDividedBy extends App {


  def calculate(min: Int, max: Int) = {
    val arr = min to max
    val primes = for (i <- arr if (Primes.isPrime(i))) yield i
    var n = 1L
    for (i <- primes) {
      val pow = math.pow(max, (1d / i.toDouble))
      n = n * math.pow(i, pow.floor).toLong
    }
    n
  }
}
