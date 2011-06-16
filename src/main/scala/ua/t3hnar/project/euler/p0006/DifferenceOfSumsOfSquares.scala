package ua.t3hnar.project.euler.p0006

/**
 * @author Yaroslav Klymko aka t3hnar
 */
object DifferenceOfSumsOfSquares extends Application {

	println(calculate((1 to 100).toSeq))

	def calculate(seq: Seq[Int]) = {
		squareOfSum(seq) - sumOfSquares(seq)
	}

	def sumOfSquares(seq: Seq[Int]) = {
		var sum = 0;
		seq.foreach(x => sum += x * x)
		sum
	}

	def squareOfSum(seq: Seq[Int]) = {
		var sum = 0;
		seq.foreach(x => sum += x)
		sum * sum
	}
}