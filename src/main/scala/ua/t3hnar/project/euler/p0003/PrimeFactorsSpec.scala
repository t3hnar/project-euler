package ua.t3hnar.project.euler.p0003

import org.specs2.mutable.SpecificationWithJUnit

/**
 * @author Yaroslav Klymko aka t3hnar
 */
class PrimeFactorsSpec extends SpecificationWithJUnit {

	"Max prime factor of 6 should be 3" in {
		PrimeFactors.findMaxPrimeFactor(6) must be_==(3)
	}

	"Max prime factor of 8 should be 2" in {
		PrimeFactors.findMaxPrimeFactor(8) must be_==(2)
	}

	"Max prime factor of 17 should be 17" in {
		PrimeFactors.findMaxPrimeFactor(17) must be_==(17)
	}

	"Max prime factor of 1 should be 1" in {
		PrimeFactors.findMaxPrimeFactor(1) must be_==(1)
	}

	//	"The prime factors of 13195 are 5, 7, 13 and 29" in {
	//		PrimeFactors.findPrimeFactors(13195) must beEqualTo(List(5, 7, 13, 29))
	//	}
}