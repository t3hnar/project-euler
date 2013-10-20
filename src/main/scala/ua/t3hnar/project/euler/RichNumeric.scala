package ua.t3hnar.project.euler

import collection.immutable.NumericRange
import primes.Primes

/**
 * @author Yaroslav Klymko
 */
class RichNumeric[T](n: T)(implicit num: Numeric[T]) {
  def !(implicit integral: Integral[T]): T =
    NumericRange.inclusive(num.one, n, num.one).product

  lazy val sumOfDigits: T = (digits map num.fromInt).sum

  def digits: Seq[Int] = n.toString.map(_.asDigit)

  //  def sumOfDivisors: T =
//  def sumOfDivisors: T = num.minus(sumOfDivisors, n)
//  def divisors: T
//  def properDivisors: T
}


class RichLong(n: Long) extends RichNumeric[Long](n) {
  def primeFactors: List[(Long, Int)] = {
    def inner(n: Long, primes: Stream[Long]): List[(Long, Int)] =
      if (n <= 1) Nil
      else {
        val ps = primes.dropWhile(p => n % p != 0)
        val p = ps.head

        def factor(n: Long): Int = if (n % p == 0) 1 + factor(n / p) else 0

        val f = factor(n)
        (p -> f) :: inner(n / math.pow(p, f).toLong, ps.tail)
      }

    inner(n, Primes.stream)
  }

  override lazy val digits: Seq[Int] = {
    def loop(n: Long, ds: List[Int]): List[Int] =
      if (n == 0) ds
      else loop(n / 10, (n % 10).toInt :: ds)

    loop(n, Nil)
  }

  def concat(other: Long): Long = {
    (this.digits ++ new RichLong(other).digits).mkString.toLong
    //    math.pow(10, new RichLong(other).numberOfDigits).toLong * this.n + other
  }

  def numberOfDigits: Int = {
    def loop(n: Long): Int = {
      val x = n / 10
      if (x == 0) 1 else 1 + loop(x)
    }
    loop(n)
  }

  def sumOfDivisors: Long =
    if (n == 1) 0
    else primeFactors.map {
      case (p, e) if e == 1 => p + e
      case (p, e) => (math.pow(p, e + 1) - 1).toLong / (p - 1)
    }.product - n

  def properDivisors: Seq[Long] = (1L until (n / 2 + 1)).filter(x => n % x == 0)

  def numberOfDivisors: Int = {
    val sqrt = math.sqrt(n)

    def loop(i: Int, nod: Int): Int =
      if (i > sqrt) nod
      else if (n % i == 0) loop(i + 1, nod + 2)
      else loop(i + 1, nod)

    val nod = loop(1, 0)
    if (sqrt * sqrt == n) nod - 1 else nod
  }
}

object RichNumeric {
  implicit def richNumeric[T](n: T)(implicit num: Numeric[T]): RichNumeric[T] = new RichNumeric(n)
  implicit def richLong(n: Long): RichLong = new RichLong(n)
}