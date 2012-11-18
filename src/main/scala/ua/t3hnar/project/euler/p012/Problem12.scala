package ua.t3hnar.project.euler
package p012

/**
 * @author Yaroslav Klymko
 */
object Problem12 extends App {

  def numberOfDivisors(n: Long): Int = {
    val sqrt = math.sqrt(n)

    def loop(i: Int, nod: Int): Int =
      if (i > sqrt) nod
      else if (n % i == 0) loop(i + 1, nod + 2)
      else loop(i + 1, nod)

    val nod = loop(1, 0)
    if (sqrt * sqrt == n) nod - 1 else nod
  }


  assert(Triangles.stream(6) == 28)
  assert(Triangles.stream.find(numberOfDivisors(_) > 5).get == 28)
  assert(Triangles.stream.find(numberOfDivisors(_) >  500).get == 76576500)
}
