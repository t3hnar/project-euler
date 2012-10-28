package ua.t3hnar.project.euler.p017

import com.ibm.icu.text.RuleBasedNumberFormat

/**
 * @author Yaroslav Klymko
 */
object Problem17 extends App {

  def letters(n: Long): Long =
    new RuleBasedNumberFormat(RuleBasedNumberFormat.SPELLOUT)
      .format(n)
      .filterNot(c => c == ' ' || c == '-').size

  assert(letters(342) == 23)
  println((1 to 1000).map(letters(_)).sum)
}
