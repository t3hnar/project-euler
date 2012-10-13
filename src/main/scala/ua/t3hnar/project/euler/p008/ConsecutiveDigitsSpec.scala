package ua.t3hnar.project.euler.p008

import org.specs2.mutable.SpecificationWithJUnit

/**
 * @author Yaroslav Klymko aka t3hnar
 */
class ConsecutiveDigitsSpec extends SpecificationWithJUnit {

	"A ConsecutiveDigits" should {

		"select 1234567, 123, 567 from 1234567123456" in {
			ConsecutiveDigits.calculate("1234567123567") must_== List(1234567, 123, 567)
		}

		"return empty List if no consecutive digits fond" in {
			ConsecutiveDigits.calculate("1357913579") must_== List()
		}
	}
}