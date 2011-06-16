package ua.t3hnar.project.euler.p0001

/**
 * @author Yaroslav Klymko aka t3hnar
 */
object SumOfMultiples extends Application {

	println(calculate(0 until 1000, 3, 5))

	def calculate(seq: Seq[Int], denominators: Int*): Long = {
		var sum: Int = 0

		val set = (for {
			denominator <- denominators
			number <- seq if (number % denominator == 0)
		} yield number).toSet

		val add = (x: Int) => sum = sum + x
		set.foreach(number => add(number))
		sum
	}
}