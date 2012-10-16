package ua.t3hnar.project.euler
package p035

import prime.Primes

/**
 * @author Yaroslav Klymko
 */
object Problem35 extends App {

  def countCircularPrimesBelow(n: Long): Long =
    (Primes().takeWhile(_ <= n) filter isCircular).size

  def isCircular(n: Long): Boolean = {
    val cs = n.toString.toList
    if (cs.length > 1 && cs.contains('2')) false
    else if (cs.length > 1 && cs.contains('5')) false
    else rotate(cs).forall(c => Primes.isPrime(c.mkString.toLong))
  }

  def rotate[T](xs: List[T]): List[List[T]] =
    (0 until xs.size).toList.map {
      i =>
        val (s, e) = xs.splitAt(i)
        e ::: s
    }


  def permute[T](xs: List[T]): List[List[T]] = {
    def loop(xs1: List[T], xs2: List[T]): List[List[T]] = xs1 match {
      case Nil => Nil
      case head :: Nil => List(head :: xs2)
      case _ => (0 until xs1.length).toList.flatMap {
        i => loop(xs1.take(i) ::: xs1.drop(i + 1), xs1(i) :: xs2)
      }
    }
    loop(xs, Nil)
  }

  assert(countCircularPrimesBelow(100) == 13)
  assert(countCircularPrimesBelow(1000000) == 55)
}
