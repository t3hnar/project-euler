package ua.t3hnar.project.euler
package p038

import RichNumeric._

/**
 * @author Yaroslav Klymko
 */
object Problem38 extends App {
  def isPandigital(x: Long): Boolean = {
    val ds = x.digits
    ds.sorted == (1L to ds.size)
  }

  def largestConcatenatedProduct = (9234L to 9387)
    .reverse.toStream.map(x => x concat x * 2).find(isPandigital).get

  assert(largestConcatenatedProduct == 932718654L)
}