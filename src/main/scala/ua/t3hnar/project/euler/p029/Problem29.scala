package ua.t3hnar.project.euler.p029

/**
 * @author Yaroslav Klymko
 */
object Problem29 extends App {

  def formula(a: Int, b: Int) = BigInt(a) pow b

  def distinctTerms(range: Range) = {
    val abs = for {
      a <- range
      b <- range
    } yield formula(a, b)

    abs.toSet.size
  }

  assert(distinctTerms(2 to 5) == 15)
  assert(distinctTerms(2 to 100) == 9183)
}
