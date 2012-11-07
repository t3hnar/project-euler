package ua.t3hnar.project.euler
package p026

/**
 * @author Yaroslav Klymko
 */
object Problem26 extends App {

  def recurringCycle(n: Int): Int = {
    def loop(xs: Vector[Int]): Int = {
      val x = xs.head * 10 % n
      xs.indexOf(x) match {
        case -1 => loop(x +: xs)
        case idx => idx + 1
      }
    }
    loop(Vector(1 % n))
  }

  case class Inner(n: Int) {
    lazy val rc = recurringCycle(n)
  }

  val slowOrdering = Ordering.by[Inner, Int](_.rc)
  val fastOrdering = new Ordering[Inner] {
    def compare(x: Inner, y: Inner) =
      if (x.rc > y.n) 1 else slowOrdering.compare(x, y)
  }

  def maxRecurringCycle(xs: Seq[Int]): Int =
    xs.reverse.map(Inner.apply).max(fastOrdering).n

  assert(recurringCycle(6) == 1)
  assert(recurringCycle(7) == 6)
  assert(maxRecurringCycle(1 to 1000) == 983)
}


