package ua.t3hnar.project.euler
package p013

import io.Source

/**
 * @author Yaroslav Klymko
 */
object Problem13 extends App {
  val lines = Source.fromInputStream(getClass.getResourceAsStream("numbers.txt")).getLines()
  assert(lines.map(_.take(11).toLong).sum.toString.take(10) == "5537376230")
}