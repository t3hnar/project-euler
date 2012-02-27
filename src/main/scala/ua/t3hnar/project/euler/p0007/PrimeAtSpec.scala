package ua.t3hnar.project.euler.p0007

import org.specs2.mutable.SpecificationWithJUnit

/**
 * @author Yaroslav Klymko aka t3hnar
 */
class PrimeAtSpec extends SpecificationWithJUnit {

	"6th prime is 13" should {
		PrimeAt.calculate(6) must be_==(13L)
	}

//	"10001th prime is 104743" in {
//		PrimeAt.calculate(10001) must be_==(104743L)
//	}
}