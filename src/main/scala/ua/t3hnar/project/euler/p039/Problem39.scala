package ua.t3hnar.project.euler
package p039

//import RichNumeric._
/**
 * @author Yaroslav Klymko
 */
object Problem39 extends App {

  def isRightAngled(p: Int, a: Int): Boolean = (p * (p - 2 * a)) % (2 * (p - a)) == 0

  println(Range(2, 1000, 2).toSeq.map {
    p => p -> (2 until p / 3).count(isRightAngled(p, _))
  }.maxBy(_._2)._1)
}
