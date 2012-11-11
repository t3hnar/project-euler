package ua.t3hnar.project.euler
package p036

/**
 * @author Yaroslav Klymko
 */
object Problem36 extends App {
  def isPalindromic(n: Long, b: Int = 10): Boolean = {
    def loop(x: Long, r: Long): Boolean = {
      if (x > 0) loop(x / b, b * r + x % b)
      else n == r
    }
    loop(n, 0)
  }

  def isPalindromicInBothBases(n: Long): Boolean =
    isPalindromic(n) && isPalindromic(n, 2)

  def sumOfPalindromicInBothBases(range: Seq[Long]): Long =
    (range filter isPalindromicInBothBases).sum

  assert(isPalindromicInBothBases(585))

  printlnMillis {
    assert(sumOfPalindromicInBothBases(0L until 1000000) == 872187)
  }

}
