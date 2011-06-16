package ua.t3hnar.project.euler.p0005

import ua.t3hnar.project.euler.p0003.PrimeFactors

/**
 * @author Yaroslav Klymko aka t3hnar
 */

object SmallestNumberDividedBy extends Application {


	def calculate(min: Int, max: Int) = {
		val time = System.nanoTime
		val arr = min to max
		val primes = for (i <- arr if (PrimeFactors.isPrime(i))) yield i
		var n = 1L
		for (i <- primes) {
			println(n)
			val pow = Math.pow(max, (1d / i.toDouble))
			n = n * Math.pow(i, pow.floor).toLong
		}
		println("time: " + (System.nanoTime - time))
		n
	}
}
