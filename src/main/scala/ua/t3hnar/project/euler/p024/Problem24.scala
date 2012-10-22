package ua.t3hnar.project.euler
package p024

/**
 * @author Yaroslav Klymko
 */
object Problem24 extends App {
  def permuteAndSort(xs: List[Long]): List[String] = Permute(xs).map(_.mkString).sorted

  assert(permuteAndSort(List(0, 1, 2)) == List("012", "021", "102", "120", "201", "210"))
  assert(permuteAndSort((0L to 9L).toList)(1000000 - 1) == "2783915460")
}
