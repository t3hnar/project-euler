package ua.t3hnar.project.euler
package p042

import io.Source

/**
 * @author Yaroslav Klymko
 */
object Problem42 extends App {

  val wordsStream = Source.fromInputStream(getClass.getResourceAsStream("words.txt"), "UTF-8")
  val words = wordsStream.mkString.split(',').map(_.replace("\"", "")).toList

  def numberOfTriangleWords(ws: List[String]) = {

    def alphabetPosition(c: Char): Int = c.toLower.toInt - 96

    def isTriangleWord(word: String): Boolean =
      Triangles.isTriangle((word map alphabetPosition).sum)

    (ws filter isTriangleWord).size
  }

  assert(numberOfTriangleWords(words) == 162)
}
