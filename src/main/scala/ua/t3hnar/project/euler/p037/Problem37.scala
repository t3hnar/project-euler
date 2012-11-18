package ua.t3hnar.project.euler
package p037

import primes.Primes._
import RichNumeric._

/**
 * @author Yaroslav Klymko
 */
object Problem37 extends App {

  def removeLeft(n: Long)(f: Long => Boolean): Boolean = {
    def loop(x: Int): Boolean =
      if (x > n) true else f(n % x) && loop(x * 10)
    loop(10)
  }

  def removeRight(n: Long)(f: Long => Boolean): Boolean = {
    def loop(n: Long): Boolean =
      if (n == 0) true else f(n) && loop(n / 10)
    loop(n / 10)
  }


  def isTruncatable(n: Long): Boolean = {
    removeLeft(n)(isPrime) && removeRight(n)(isPrime)
  }

  assert(isTruncatable(3797))


  def foldPrimes(f: (Long, Long) => Long, ns: Seq[Int]): Stream[Long] = {
    def loop(ps: List[Long]): Stream[Long] =
      if (ps.isEmpty) Stream()
      else {
        val primes = (for (p <- ps; n <- ns) yield f(p, n)) filter isPrime
        ps.filterNot(x => x / 10 == 0).toStream #::: loop(primes.sorted)
      }

    loop(List(2L, 3, 5, 7))
  }

  val truncatableRightToLeft = foldPrimes((x, y) => x concatenate y, (0 to 9))
  val truncatableLeftToRight = foldPrimes((x, y) => y concatenate x, (1 to 9))

  val truncatable = for {
    x <- truncatableRightToLeft
    y <- truncatableLeftToRight.collectFirst {
      case `x` => Some(x)
      case y if y > x => None
    }.get
  } yield y

  assert(truncatable.sum == 748317)
}
