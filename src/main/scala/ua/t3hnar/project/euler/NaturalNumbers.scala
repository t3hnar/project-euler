package ua.t3hnar.project.euler

/**
 * @author Yaroslav Klymko
 */
object NaturalNumbers {
  def apply[T](from: T)(implicit num: Numeric[T]): Stream[T] = from #:: apply(num.plus(from, num.one))
  def apply[T]()(implicit num: Numeric[T]): Stream[T] = apply(num.one)
}