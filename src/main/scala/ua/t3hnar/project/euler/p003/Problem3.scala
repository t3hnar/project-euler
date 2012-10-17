package ua.t3hnar.project.euler
package p003

import prime.Primes

/**
 * @author Yaroslav Klymko
 */
object Problem3 extends App {

  def largestPrimeFactorOf_Simple(n: Long): Long = {
    val max = math.sqrt(n)
    Primes().takeWhile(_ <= max).reverse.collectFirst {
      case p if n % p == 0 => p
    } getOrElse n
  }

  def largestPrimeFactorOf_Fast(n: Long): Long = {
    def loop(divider: Long, n: Long, fact: Long): Long = {
      if (divider * divider >= n) math.max(n, fact)
      else if (n % divider == 0) loop(divider, n / divider, divider)
      else loop(divider + 1, n, fact)
    }
    loop(2, n, 0)
  }

  assert(largestPrimeFactorOf_Simple(13195) == 29)
  assert(largestPrimeFactorOf_Simple(600851475143L) == 6857)

  assert(largestPrimeFactorOf_Fast(13195) == 29)
  assert(largestPrimeFactorOf_Fast(600851475143L) == 6857)
}