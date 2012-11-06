package ua.t3hnar.project.euler.p025

/**
 * @author Yaroslav Klymko
 */
object Problem25 extends App {
  val fibonacci: Stream[BigInt] = {
    def loop(x: BigInt, y: BigInt): Stream[BigInt] = x #:: loop(y, x + y)
    loop(1, 1)
  }

  def term(digits: Int): BigInt = {
    val min = BigInt(('1' :: List.fill(digits - 1)('0')).mkString)

    fibonacci.zipWithIndex.collectFirst {
      case (x, i) if x >= min => i + 1
    }.get
  }

  assert(term(3) == 12)
  assert(term(1000) == 4782)
}
