package ua.t3hnar.project.euler.p0009

/**
 * @author Yaroslav Klymko
 */
object Triplet {
  lazy val (a, b, c): (Int, Int, Int) = {
    val r = row(500)
    println(r.mkString("\n"))
    r.head
  }

  private def row(max: Int) = {
    for {a <- 3 to max
         b <- a + 1 to max
         c <- b + 1 to max
         if (math.pow(a, 2) + math.pow(b, 2) == math.pow(c, 2) && (a + b + c) == 1000)
    } yield (a, b, c)
  }

  lazy val product = a * b * c
}