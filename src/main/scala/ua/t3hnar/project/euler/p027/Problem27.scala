package ua.t3hnar.project.euler
package p027

import math.{pow, abs}
import primes.Primes

/**
 * @author Yaroslav Klymko
 */
object Problem27 extends App {
  val naturals = Naturals(0)

  def quadraticFormula(n: Int): Long = pow(n, 2).toLong + n + 41

  assert(quadraticFormula(41) % 41 == 0)
  assert(quadraticFormula(40) % 41 == 0)

  def formula(a: Int, b: Int, n: Int): Long = pow(n, 2).toLong + a * n + b

  val range = (-999 to 999)

  val ab = for {
    a <- range
    b <- range
  } yield a -> b

  val max = ab.par.map {
    case (a, b) =>
      val size = naturals.takeWhile {
        n => Primes.isPrime(abs(formula(a, b, n)))
      }.size
      a * b -> size
  }.maxBy(_._2)._1

  assert(max == -59231)
}
