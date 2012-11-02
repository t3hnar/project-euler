package ua.t3hnar.project.euler
package p050

import primes.Primes
import collection.SortedSet

/**
 * @author Yaroslav Klymko
 */
object Problem50 extends App {

  def longestSumOfConsecutivePrimesBelow(limit: Int) = {
    val primes = SortedSet(Primes.stream.takeWhile(_ < limit): _*)

    val sums = (List(0L) /: primes) {
      case (xs, p) => (xs.head + p) :: xs
    }.reverse.toIndexedSeq

    def outerLoop(i: Int, termsOuter: Int, primeOuter: Long): (Long, Int) = {
      if (sums.size <= i) primeOuter -> termsOuter
      else {
        val sumOuter = sums(i)

        def innerLoop(j: Int, termsInner: Int, primeInner: Long): (Long, Int) = {
          if (j < 0) primeInner -> termsInner
          else {
            val x = sumOuter - sums(j)
            if (x > limit) primeInner -> termsInner
            else {
              val (p, m) =
                if (primes.contains(x) && i - j > termsInner) x -> (i - j)
                else primeInner -> termsInner

              innerLoop(j - 1, m, p)
            }
          }
        }

        val (primeInner, termsInner) = innerLoop(i - termsOuter + 1, termsOuter, primeOuter)

        val (p, m) =
          if (termsInner > termsOuter) primeInner -> termsInner
          else primeOuter -> termsOuter

        outerLoop(i + 1, m, p)
      }
    }

    val (prime, _) = outerLoop(0, 0, 2)
    prime
  }


  assert(longestSumOfConsecutivePrimesBelow(100) == 41)
  assert(longestSumOfConsecutivePrimesBelow(1000) == 953)
  assert(longestSumOfConsecutivePrimesBelow(1000000) == 997651)
}
