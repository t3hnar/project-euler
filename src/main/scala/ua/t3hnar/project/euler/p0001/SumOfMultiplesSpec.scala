package ua.t3hnar.project.euler.p0001

import org.specs2.mutable.SpecificationWithJUnit

/**
 * @author Yaroslav Klymko aka t3hnar
 */
class SumOfMultiplesSpec extends SpecificationWithJUnit {

	"Sum of denominators of 3 or 5 below 10 should be 23" in {
		SumOfMultiples.calculate(0 until 10, 3, 5) must be_==(23)
	}

	"Sum of denominators of 3 or 5 of 15 should be 15" in {
		SumOfMultiples.calculate(Array(15), 3, 5) must be_==(15)
	}
}