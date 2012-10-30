package ua.t3hnar.project.euler
package p022

import io.Source

/**
 * @author Yaroslav Klymko
 */
object Problem22 extends App {
  val source = Source.fromInputStream(getClass.getResourceAsStream("names.txt"))
  val names = (source.getLines().next().filterNot(_ == '"').split(',')).sorted

  assert(names.indexOf("COLIN") == 937)

  def alphabetPosition(c: Char): Int = c.toLower.toInt - 96

  def nameScore(name: String, idx: Long): Long =
    (idx + 1) * (name map alphabetPosition).sum

  assert(nameScore("COLIN", 937) == 49714)

  def sumOfNameScores = names.zipWithIndex.map {
    case (name, idx) => nameScore(name, idx)
  }.sum

  assert(sumOfNameScores == 871198282)
}