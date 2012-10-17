package ua.t3hnar.project

/**
 * @author Yaroslav Klymko
 */
package object euler {
  def countDuration[T](now: () => Long)(f: () => T): (T, Long) = {
    val start = now()
    val x = f()
    val end = now()
    x -> (end - start)
  }

  def countMillis[T] = countDuration[T](System.currentTimeMillis) _
  def countNanos[T] = countDuration[T](System.nanoTime) _

  def printlnDuration[T](s: String)(now: () => Long)(f: () => T): T = {
    val (x, duration) = countDuration(now)(f)
    println(s.format(duration))
    x
  }

  def printlnMillis[T] = printlnDuration[T]("%s ms")(System.currentTimeMillis) _
  def printlnNanos[T] = printlnDuration[T]("%s ns")(System.nanoTime) _
}