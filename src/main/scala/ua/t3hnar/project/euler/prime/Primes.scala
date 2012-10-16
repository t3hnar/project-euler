package ua.t3hnar.project.euler.prime

import collection.mutable.ListBuffer


/**
 * @author Yaroslav Klymko
 */
object Primes {

  private val cache = ListBuffer[Long](2, 3)

  private def isComposite(primes: Traversable[Long])(n: Long) = {
    val sqrt = math.sqrt(n)
    primes.collectFirst {
      case p if p > sqrt => false
      case p if n % p == 0 => true
    } getOrElse false
  }

  def isPrime(n: Long) = !isComposite(apply())(n)

  def apply(): Stream[Long] = {

    def loop(previous: Long, buffer: List[Long]): Stream[Long] = {
      def nextPrime(x: Long): Long =
        if (isComposite(cache)(x)) nextPrime(x + 1) else x

      buffer match {
        case x :: xs => x #:: loop(x, xs)
        case Nil =>
          val x = nextPrime(previous + 1)
          cache += x
          x #:: loop(x, Nil)
      }
    }

    2 #:: loop(3, cache.toList.tail)
  }
}

object Prime {
  def unapply(n: Long): Option[Long] = if (Primes.isPrime(n)) Some(n) else None
}