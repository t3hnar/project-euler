package ua.t3hnar.project.euler.prime

import collection.mutable.ListBuffer


/**
 * @author Yaroslav Klymko
 */
object Primes {

  def apply(): Stream[Long] = {
    val ps = ListBuffer[Long]()

    def loop(previous: Long): Stream[Long] = {
      ps += previous

      def nextPrime(x: Long): Long = {
        val sqrt = math.sqrt(x)
        val isComposite = ps.collectFirst {
          case p if p > sqrt => false
          case p if x % p == 0 => true
        } getOrElse false

        if (isComposite) nextPrime(x + 1) else x
      }

      val prime = nextPrime(previous + 1)
      prime #:: loop(prime)
    }

    2 #:: loop(2)
  }
}
