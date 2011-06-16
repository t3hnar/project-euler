package ua.t3hnar.project.euler.p0004

import org.specs.Specification

/**
 * @author Yaroslav Klymko aka t3hnar
 */
class PalindromicNumbersSpec extends Specification {

	"9009 should be palindromic" in {
		PalindromicNumbers.isPalindromic(9009).mustBe(true)
	}


	"9001 should not be palindromic" in {
		PalindromicNumbers.isPalindromic(9001).mustBe(false)
	}

	"1 should not be palindromic" in {
		PalindromicNumbers.isPalindromic(1).mustBe(false)
	}
}