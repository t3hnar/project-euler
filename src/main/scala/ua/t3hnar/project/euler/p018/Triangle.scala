package ua.t3hnar.project.euler
package p018

/**
 * @author Yaroslav Klymko
 */
object Triangle {
  def maximumTotal(matrix: List[List[Int]]): Int = {
    def join(xs: List[Int]): List[Int] = {
      def loop(x: Int, xs: List[Int]): List[Int] = xs match {
        case h :: Nil => List(x max h)
        case h :: t => (x max h) :: loop(h, t)
      }
      xs match {
        case h :: Nil => xs
        case h :: t => loop(h, t)
      }
    }

    def loop(m: List[List[Int]]): List[Int] = m match {
      case h :: Nil => join(h)
      case h :: t => join(h.zip(loop(t)).map {
        case (x, y) => x + y
      })
    }

    loop(matrix).head
  }
}
