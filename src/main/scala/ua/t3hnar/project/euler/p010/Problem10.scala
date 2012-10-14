package ua.t3hnar.project.euler
package p010

import prime.Primes

object Problem10 extends App {
  Primes().takeWhile(_ <= 2000000).sum
}
