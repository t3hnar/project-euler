package ua.t3hnar.project.euler
package p014

/**
 * @author Yaroslav Klymko
 */
object Problem14 extends App {

  def fun(n: Long): Long = if (n % 2 == 0) n / 2 else 3 * n + 1

  def funList(n: Long): List[Long] =
    if (n < 1) Nil
    else if (n == 1) List(1)
    else n :: funList(fun(n))


  val cache = collection.mutable.Map[Long, Long]()

  def funSize(n: Long): Long = cache.get(n) getOrElse {
    val size =
      if (n <= 0) 0
      else if (n == 1) 1
      else 1 + funSize(fun(n))

    cache += (n -> size)
    size
  }

  assert(funList(13) == List(13, 40, 20, 10, 5, 16, 8, 4, 2, 1))
  assert((1 to 1000000).map(n => n -> funSize(n)).maxBy(_._2) ==(837799, 525))
}
