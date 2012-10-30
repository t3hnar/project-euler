package ua.t3hnar.project.euler

import collection.immutable.NumericRange

/**
 * @author Yaroslav Klymko
 */
class RichNumeric[T](n: T)(implicit num: Numeric[T]) {
  def !(implicit integral: Integral[T]): T =
    NumericRange.inclusive(num.one, n, num.one).product

  def sumOfDigits: T = num.fromInt(n.toString.map(_.asDigit).sum)
}

object RichNumeric {
  implicit def richNumeric[T](n: T)(implicit num: Numeric[T]): RichNumeric[T] = new RichNumeric(n)
}