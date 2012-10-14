package ua.t3hnar.project

/**
 * @author Yaroslav Klymko
 */
package object euler {
  def printlnMillis[T] = printlnDuration[T](System.currentTimeMillis)("") _

  def printlnNanos[T] = printlnDuration[T](System.nanoTime)("") _

  def printlnDuration[T](now: () => Long)(s: String)(f: => T): T = {
    val start = now()
    val result = f
    val end = now()
    println(s + (end - start))
    result
  }
}
