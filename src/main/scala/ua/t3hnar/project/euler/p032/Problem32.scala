package ua.t3hnar.project.euler
package p032

/**
 * @author Yaroslav Klymko
 */
object Problem32 extends App {

  val naturals = List(1, 2, 3, 4, 5, 6, 7, 8, 9)

  def pandigitalNumbers(base: Int): List[Long] =
    Permute(naturals.take(base)).map(_.mkString.toLong).sorted

  assert(pandigitalNumbers(1) == List(1))
  assert(pandigitalNumbers(2) == List(12, 21))
  assert(pandigitalNumbers(5).sorted.head == 12345)

  val ns = pandigitalNumbers(9)

  def unusualProduct(x: Long): List[Long] = {
    def fun(size: Int, idx: Int) = {
      val s = x.toString
      val (multiplicand, multiplier) = s.take(size).splitAt(idx)
      val product = s.drop(size).toLong
      if (multiplicand.toLong * multiplier.toLong == product) Some(product) else None
    }
    List(fun(4, 2), fun(5, 2), fun(5, 1)).flatten
  }

  assert((pandigitalNumbers(9) flatMap unusualProduct).toSet.sum == 45228L)
}
