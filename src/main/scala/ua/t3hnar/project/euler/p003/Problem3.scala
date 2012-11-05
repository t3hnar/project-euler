package ua.t3hnar.project.euler
package p003

import RichNumeric._

/**
 * @author Yaroslav Klymko
 */
object Problem3 extends App {

  def largestPrimeFactor(n: Long): Long = n.primeFactors.map(_._1).max

  assert(largestPrimeFactor(13195) == 29)
  assert(largestPrimeFactor(600851475143L) == 6857)
}