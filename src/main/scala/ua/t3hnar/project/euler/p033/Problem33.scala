package ua.t3hnar.project.euler
package p033

import RichNumeric._

/**
 * @author Yaroslav Klymko
 */
object Problem33 extends App {

  def isCurious(r: Rational): Boolean = {
    import r._
    (nominator.digits.last == denominator.digits.head &&
      Rational(nominator.digits.head, denominator.digits.last).simple == r.simple)
  }

  assert(isCurious(Rational(49, 98)))

  val curious = (for {
    n <- 1 to 99
    d <- 1 to 99 if d > n
  } yield Rational(n, d)) filter isCurious

  println(curious.reduceRight(_ * _).simple.denominator)
}

case class Rational(nominator: Int, denominator: Int) {
  private lazy val g = gcd(nominator, denominator)
  private lazy val n = nominator / g
  private lazy val d = denominator / g

  def simple: Rational = Rational(n, d)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  def *(other: Rational): Rational =
    Rational(this.nominator * other.nominator, this.denominator * other.denominator)

  override def toString = n + "/" + d
}
