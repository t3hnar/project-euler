package ua.t3hnar.project.euler
package p048

/**
 * @author Yaroslav Klymko
 */
object Problem48 extends App {
  def sum(n: Int): BigInt = Naturals[Int]()
    .take(n)
    .map(x => BigInt(x).pow(x))
    .sum

  assert(sum(10) == 10405071317L)
  assert(sum(1000).toString().takeRight(10).toLong == 9110846700L)
}
