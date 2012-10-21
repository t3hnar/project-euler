package ua.t3hnar.project.euler.p015

/**
 * @author Yaroslav Klymko
 */
object Problem15 extends App {
  def routes_Iterate(size: Int): Long = {
    def loop(x: Int, y: Int): Long = {
      (x, y) match {
        case (`size`, `size`) => 1
        case (`size`, _) => loop(x, y + 1)
        case (_, `size`) => loop(x + 1, y)
        case _ => loop(x + 1, y) + loop(x, y + 1)
      }
    }
    loop(0, 0)
  }


  def routes_Combinatorics(size: Long): Long = (1L /: (0L until size)) {
    case (p, i) => p * (2L * size - i) / (i + 1L)
  }

  assert(routes_Iterate(2) == 6)
  assert(routes_Combinatorics(2) == 6)
  assert(routes_Combinatorics(20) == 137846528820L)
}
