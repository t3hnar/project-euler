package ua.t3hnar.project.euler.p0004

/**
 * @author Yaroslav Klymko aka t3hnar
 */
object PalindromicNumbers extends App {

	def calculate() {
		val max: Int = 999
		val min: Int = 100
		var palindromic = 0
		for (i <- min to max; j <- min to max) {
			val n: Int = i * j
			if (isPalindromic(n) && n > palindromic)
				palindromic = n
		}
		println(palindromic)
	}


	def isPalindromic(n: Int) = {
		val s = n.toString
		val length: Int = s.length
		if (length % 2 != 0)
			false
		else {
			val half: Int = length / 2
			val s1 = s.substring(0, half)
			val s2 = s.substring(half)
			s1.reverse == s2
		}
	}
}