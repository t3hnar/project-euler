package ua.t3hnar.project.euler.p024

/**
 * @author Yaroslav Klymko
 */
object Problem24 extends App {
  def permute[T](xs: List[T]): List[List[T]] = {
    def loop(xs1: List[T], xs2: List[T]): List[List[T]] = xs1 match {
      case Nil => Nil
      case head :: Nil => List(head :: xs2)
      case _ => (0 until xs1.length).toList.flatMap {
        i => loop(xs1.take(i) ::: xs1.drop(i + 1), xs1(i) :: xs2)
      }
    }
    loop(xs, Nil)
  }

  def permuteAndSort(xs: List[Long]): List[String] = permute(xs).map(_.mkString).sorted

  assert(permuteAndSort(List(0, 1, 2)) == List("012", "021", "102", "120", "201", "210"))
  assert(permuteAndSort((0L to 9L).toList)(1000000 - 1) == "2783915460")
}
