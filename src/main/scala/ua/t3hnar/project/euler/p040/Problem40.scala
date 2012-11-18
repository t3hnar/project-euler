package ua.t3hnar.project.euler.p040

import ua.t3hnar.project.euler.Naturals

/**
 * @author Yaroslav Klymko
 */
object Problem40 extends App {

  def expression = {
    val ns = Naturals.stream.take(1000000).mkString
    def d(n: Int) = ns.charAt(n - 1).toString.toLong
    d(1) * d(10) * d(100) * d(1000) * d(10000) * d(100000) * d(1000000)
  }

  assert(expression == 210)
}
