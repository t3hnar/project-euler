package ua.t3hnar.project.euler.p011

/**
 * @author Yaroslav Klymko
 */
object Problem11 extends App {
  val matrix = Array(
    Array(8, 2, 22, 97, 38, 15, 0, 4, 0, 75, 4, 5, 7, 78, 52, 12, 5, 77, 91, 8),
    Array(49, 49, 99, 4, 17, 81, 18, 57, 6, 87, 17, 4, 98, 43, 69, 48, 4, 56, 62, 0),
    Array(81, 49, 31, 73, 55, 79, 14, 29, 93, 71, 4, 67, 53, 88, 3, 3, 49, 13, 36, 65),
    Array(52, 7, 95, 23, 4, 6, 11, 42, 69, 24, 68, 56, 1, 32, 56, 71, 37, 2, 36, 91),
    Array(22, 31, 16, 71, 51, 67, 63, 89, 41, 92, 36, 54, 22, 4, 4, 28, 66, 33, 13, 8),
    Array(24, 47, 32, 6, 99, 3, 45, 2, 44, 75, 33, 53, 78, 36, 84, 2, 35, 17, 12, 5),
    Array(32, 98, 81, 28, 64, 23, 67, 1, 26, 38, 4, 67, 59, 54, 7, 66, 18, 38, 64, 7),
    Array(67, 26, 2, 68, 2, 62, 12, 2, 95, 63, 94, 39, 63, 8, 4, 91, 66, 49, 94, 21),
    Array(24, 55, 58, 5, 66, 73, 99, 26, 97, 17, 78, 78, 96, 83, 14, 88, 34, 89, 63, 72),
    Array(21, 36, 23, 9, 75, 0, 76, 44, 2, 45, 35, 14, 0, 61, 33, 97, 34, 31, 33, 95),
    Array(78, 17, 53, 28, 22, 75, 31, 67, 15, 94, 3, 8, 4, 62, 16, 14, 9, 53, 56, 92),
    Array(16, 39, 5, 42, 96, 35, 31, 47, 55, 58, 88, 24, 0, 17, 54, 24, 36, 29, 85, 57),
    Array(86, 56, 0, 48, 35, 71, 89, 7, 5, 44, 44, 37, 44, 6, 21, 58, 51, 54, 17, 58),
    Array(19, 8, 81, 68, 5, 94, 47, 69, 28, 73, 92, 13, 86, 52, 17, 77, 4, 89, 55, 4),
    Array(4, 52, 8, 83, 97, 35, 99, 16, 7, 97, 57, 32, 16, 26, 26, 79, 33, 27, 98, 66),
    Array(88, 36, 68, 87, 57, 62, 2, 72, 3, 46, 33, 67, 46, 55, 12, 32, 63, 93, 53, 69),
    Array(4, 42, 16, 73, 38, 25, 39, 11, 24, 94, 72, 18, 8, 46, 29, 32, 4, 62, 76, 36),
    Array(2, 69, 36, 41, 72, 3, 23, 88, 34, 62, 99, 69, 82, 67, 59, 85, 74, 4, 36, 16),
    Array(2, 73, 35, 29, 78, 31, 9, 1, 74, 31, 49, 71, 48, 86, 81, 16, 23, 57, 5, 54),
    Array(1, 7, 54, 71, 83, 51, 54, 69, 16, 92, 33, 48, 61, 43, 52, 1, 89, 19, 67, 48))

  val matrixSize = 20
  val lineSize = 4

  type Collector = PartialFunction[(Int, Int), List[Int]]


  def collect(enough: List[Int] => Boolean)(x: Int, y: Int)(fx: Int => Int, fy: Int => Int): List[Int] = {
    def loop(ns: List[Int], x: Int, y: Int): List[Int] = {
      if (enough(ns)) ns
      else loop(matrix(y)(x) :: ns, fx(x), fy(y))
    }
    loop(Nil, x, y)
  }

  val z = matrixSize - lineSize
  val collectLine = collect(_.size == lineSize) _


  val horizontal: Collector = {
    case (x, y) if x <= z => collectLine(x, y)(_ + 1, identity)
  }

  val vertical: Collector = {
    case (x, y) if y <= z => collectLine(x, y)(identity, _ + 1)
  }

  val diagonal1: Collector = {
    case (x, y) if (x <= z && y < z) => collectLine(x, y)(_ + 1, _ + 1)
  }

  val diagonal2: Collector = {
    case (x, y) if (x <= z && y >= lineSize - 1) => collectLine(x, y)(_ + 1, _ - 1)
  }

  val collectors = horizontal :: vertical :: diagonal1 :: diagonal2 :: Nil

  val lines = (for {
    y <- (0 until matrixSize)
    x <- (0 until matrixSize)
    c <- collectors
  } yield c.lift(x, y)).flatten

  assert(lines.map(_.product).max == 70600674L)
}