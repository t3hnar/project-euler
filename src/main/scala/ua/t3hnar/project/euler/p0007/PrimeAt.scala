package ua.t3hnar.project.euler.p0007

import ua.t3hnar.project.euler.p0003.PrimeFactors

/**
 * @author Yaroslav Klymko aka t3hnar
 */
object PrimeAt extends App {


  def calculate(index: Int) = {
    next(3, 2, index)
    //		primes(index * 15)(index-1)
  }


  def primes(max: Long): List[Long] = {
    def calc(i: Int): List[Long] = {
      val c = calculate(i)
      if (c >= max) Nil
      else c :: calc(i + 1)
    }
    calc(4)
  }

  def next(prev: Long, curIndex: Int, targetIndex: Int): Long = {
    if (PrimeFactors.isPrime(prev)) {
      if (curIndex == targetIndex)
        prev
      else
        next(prev + 2, curIndex + 1, targetIndex)
    } else
      next(prev + 2, curIndex, targetIndex)
  }
}