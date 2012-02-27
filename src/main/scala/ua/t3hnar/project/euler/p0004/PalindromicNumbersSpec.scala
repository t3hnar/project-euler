package ua.t3hnar.project.euler.p0004

import org.specs2.mutable.SpecificationWithJUnit

/**
 * @author Yaroslav Klymko aka t3hnar
 */
class PalindromicNumbersSpec extends SpecificationWithJUnit {

	"9009 should be palindromic" in {
		PalindromicNumbers.isPalindromic(9009) must beTrue
	}


	"9001 should not be palindromic" in {
		PalindromicNumbers.isPalindromic(9001) must beTrue
	}

	"1 should not be palindromic" in {
		PalindromicNumbers.isPalindromic(1) must beTrue
	}
}