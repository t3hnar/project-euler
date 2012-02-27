package ua.t3hnar.project.euler.p0006

import org.specs2.mutable.SpecificationWithJUnit


/**
 * @author Yaroslav Klymko aka t3hnar
 */
class DifferenceOfSumsOfSquaresTest extends SpecificationWithJUnit {

  "Difference between the sum of the squares of the first ten natural numbers and the square of the sum is" should {
    DifferenceOfSumsOfSquares.calculate((1 to 10).toSeq) must_== 2640
  }
}