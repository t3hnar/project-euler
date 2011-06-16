package ua.t3hnar.project.euler.p0006

import org.specs.Specification

/**
 * @author Yaroslav Klymko aka t3hnar
 */
class DifferenceOfSumsOfSquaresTest extends Specification {

	"Difference between the sum of the squares of the first ten natural numbers and the square of the sum is" in {
		DifferenceOfSumsOfSquares.calculate((1 to 10).toSeq) must be_==(2640)
	}
}