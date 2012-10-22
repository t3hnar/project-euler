package ua.t3hnar.project.euler

/**
 * @author Yaroslav Klymko
 */
object Permute {
  def apply[T](xs: List[T]): List[List[T]] = {
    def loop(xs1: List[T], xs2: List[T]): List[List[T]] = xs1 match {
      case Nil => Nil
      case head :: Nil => List(head :: xs2)
      case _ => (0 until xs1.length).toList.flatMap {
        i => loop(xs1.take(i) ::: xs1.drop(i + 1), xs1(i) :: xs2)
      }
    }
    loop(xs, Nil)
  }
}