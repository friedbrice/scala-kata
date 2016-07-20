package net.danielbrice.scalakata

object SumsProds {

  /**
   * III. SumsProds
   *
   * Given: a finite list of pairs of doubles,
   *
   * When: your function is called on said list,
   *
   * Then: your function returns a type with shape `(a, b, c, d)`, where `a`
   * is the sum of the first coordinates, `b` is the sum of the second coordinates,
   * `c` is the product of the first coordinates, and `d` is the product of the
   * second coordinates.
   */

  def sumsProds
    : List[(Double, Double)] => (Double, Double, Double, Double)
    = pairs                  => {

      def helper
        : Double => Double => Double => Double => List[(Double, Double)] => (Double, Double, Double, Double)
        = a      => b      => c      => d      => {
          case Nil => (a, b, c, d)
          case x :: xs => helper(a + x._1)(b + x._2)(c * x._1)(d * x._2)(xs)
        }

      helper(0)(0)(1)(1)(pairs)
    }
}
