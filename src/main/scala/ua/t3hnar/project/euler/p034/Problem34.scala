package ua.t3hnar.project.euler
package p034

import RichNumeric._

/**
 * @author Yaroslav Klymko
 */
object Problem34 extends App {
  val max = (7 * 9L.!)
  val x = (3L to max).filter {
    x => x == x.digits.map(_.!).sum
  }.sum

  assert(x == 40730)
}
