package ua.t3hnar.project.euler.p003

/**
 * @author Yaroslav Klymko aka t3hnar
 */
object PrimeFactors extends App {

	def findMaxPrimeFactor(n: Long) = {
		val seq = for (i <- 1L to n if (isPrime(i)); if (n % i == 0)) yield i;
		seq.last
	}

	def isPrime(n: Long) = {
		if (n == 1 || n == 2) true
		else if (n % 2 == 0) false
		else !(3L until (n, 2L)).toArray.exists(x => n % x == 0)
	}
}