package ua.t3hnar.project.euler.p0005

import org.specs.Specification

/**
 * @author Yaroslav Klymko aka t3hnar
 */
class SmallestNumberDividedBySpec extends Specification {

	"2520 is the smallest number that can be divided by each of the numbers from 1 to 10." in {
		SmallestNumberDividedBy.calculate(1, 10).must_==(2520)
	}

	"232792560 is the smallest number that can be divided by each of the numbers from 1 to 20." in {
		SmallestNumberDividedBy.calculate(1, 20).must_==(232792560)
	}

}