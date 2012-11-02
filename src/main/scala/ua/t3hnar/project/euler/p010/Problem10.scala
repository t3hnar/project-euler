package ua.t3hnar.project.euler
package p010

import primes.Primes

object Problem10 extends App {

  def sumOfPrimesBelow(n: Long) = Primes.stream.takeWhile(_ <= n).sum

  assert(sumOfPrimesBelow(10) == 17)
  assert(sumOfPrimesBelow(2000000) == 142913828922L)
}
