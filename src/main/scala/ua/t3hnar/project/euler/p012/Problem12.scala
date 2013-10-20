package ua.t3hnar.project.euler
package p012

import RichNumeric._

/**
 * @author Yaroslav Klymko
 */
object Problem12 extends App {

  assert(Triangles.stream(6) == 28)
  assert(Triangles.stream.find(_.numberOfDivisors > 5).get == 28)
  assert(Triangles.stream.find(_.numberOfDivisors >  500).get == 76576500)
}
