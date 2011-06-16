package ua.t3hnar.project.euler.p0007

import ua.t3hnar.project.euler.p0003.PrimeFactors

/**
 * @author Yaroslav Klymko aka t3hnar
 */
object PrimeAt extends Application {


	def calculate(index: Int) = {
				next(3, 2, index)
//		primes(index * 15)(index-1)
	}


	def primes(size: Int) = {
		val sqrt = Math.sqrt(size)

		val primes = if (size > 100)
			new Array[Int](size / 2)
		else
			new Array[Int](size)

		primes(0) = 2
		primes(1) = 3


		var i = 2;
		for (j <- 5 until (size, 2) if (j % 3 != 0)) {
			primes(i) = j
			i += 1
		}

		def test(divisor: Int, index: Int, offset: Int, arr: Array[Int]): Array[Int] = {
			if (divisor < sqrt) {
				var j = index * index
				val tmp = arr.take(offset)
				var o = j
				while (j < tmp.length) {
					var k = arr(j)
					j += 1
					if (k != 0 && k % divisor != 0) {
						tmp(o) = k
						o += 1
					}
				}
				test(tmp(index), index + 1, o + 1, tmp)
			} else
				arr
		}


		test(5, 2, primes.length, primes)
	}


	def next(prev: Long, curIndex: Int, targetIndex: Int): Long = {
		if (PrimeFactors.isPrime(prev)) {
			if (curIndex == targetIndex)
				prev
			else
				next(prev + 2, curIndex + 1, targetIndex)
		} else
			next(prev + 2, curIndex, targetIndex)
	}
}