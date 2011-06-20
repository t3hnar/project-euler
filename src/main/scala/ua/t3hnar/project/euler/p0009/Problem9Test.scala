package ua.t3hnar.project.euler.p0009

import org.specs.Specification

/**
 * @author Yaroslav Klymko
 */
class Problem9Test extends Specification {
  "Triplet" should {
    "a2 + b2 = c2" in {
      (math.pow(Triplet.a, 2) + math.pow(Triplet.c, 2)) must_== math.pow(Triplet.c, 2)
    }

    "a + b + c = 1000" in {
      (Triplet.a + Triplet.b + Triplet.c) must_== 1000
    }

    "product 200*375*425" in {
      Triplet.product must_== 200 * 375 * 425
    }
  }
}