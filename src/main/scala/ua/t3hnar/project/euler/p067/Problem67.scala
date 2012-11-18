package ua.t3hnar.project.euler
package p067

import io.Source
import p018.Triangle.maximumTotal

/**
 * @author Yaroslav Klymko
 */
object Problem67 extends App {
  val source = Source.fromInputStream(getClass.getResourceAsStream("triangle.txt"), "UTF-8").getLines()

  val matrix = source.toList
    .map(_.split(' ').toList.filterNot(_.isEmpty).map(_.toInt))
    .filterNot(_.isEmpty)

  assert(maximumTotal(matrix) == 7273)
}
