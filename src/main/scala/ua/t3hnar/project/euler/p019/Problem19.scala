package ua.t3hnar.project.euler.p019

import com.thenewmotion.time.Imports._

/**
 * @author Yaroslav Klymko
 */
object Problem19 extends App {

  def sundays(from: DateTime, to: DateTime): Int = {
    def loop(from: DateTime, count: Int): Int =
      if (from > to) count
      else {
        val next = from plusMonths 1
        loop(next, if (next.dayOfWeek().get() == 7) count + 1 else count)
      }
    loop(from, 0)
  }

  println(sundays((1901, 1, 1), (2000, 12, 31)))
}
