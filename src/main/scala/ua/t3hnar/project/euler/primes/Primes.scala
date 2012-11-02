package ua.t3hnar.project.euler
package primes


/**
 * @author Yaroslav Klymko
 */
object Primes {
  val stream: Stream[Long] = {
    def loop(naturals: Stream[Long]): Stream[Long] =
      naturals.head #:: loop(naturals.tail.dropWhile(!isPrime(_)))
    loop(Naturals.stream.tail)
  }

  def isPrime(n: Long) = {
    val sqrt = math.sqrt(n)
    stream.collectFirst {
      case p if p > sqrt => true
      case p if n % p == 0 => false
    }.get
  }
}

object Prime {
  def unapply(n: Long): Option[Long] = if (Primes.isPrime(n)) Some(n) else None
}