package ua.t3hnar.project.euler.p0002

import collection.mutable.ListBuffer

/**
 * @author Yaroslav Klymko aka t3hnar
 */
object FibonacciEvenValuedTermsSum extends App {


	val max = 4000000;
	val below = (x: Int, max: Int) => x < max;
	val evenValuated = (x: Int) => x % 2 == 0
	val next = (v1: Int, v2: Int) => v1 + v2

	println(calculate(evenValuated(_), below(_, max)))

	def calculate(isValid: Int => Boolean, inRange: Int => Boolean): Int = {
		val buffer = new ListBuffer

		def sumOf(v1: Int, v2: Int): Int = {
			if (inRange(v2)) {
				val v3 = next(v1, v2)
				val sum = sumOf(v2, v3)
				if (isValid(v2))
					v2 + sum
				else
					sum
			} else {
				0
			}
		}
		sumOf(1, 1)
	}
}