package net.danielbrice.scalakata

import net.danielbrice.scalakata.SumsProds._

object SumsProds {

  /**
   * III. SumsProds
   *
   * Given: a finite list of pairs of doubles,
   *
   * When: your function is called on said list,
   *
   * Then: your function returns a type with shape `((a, b),(c, d))`, where `a`
   * is the sum of the first coordinates, `b` is the sum of the second coordinates,
   * `c` is the product of the first coordinates, and `d` is the product of the
   * second coordinates.
   */

  def sumsProds
    : List[(Double, Double)] => ((Double, Double),(Double, Double))
    = pairs                  => ???
}

object SumsProdsTests extends FlatSpec {

  "smallestTwo" should "return ((0,0),(1,1)) for empty list" in {
    // given: a list with two elements, the smaller coming first
    lazy val pairs = List()

    // when: smallestTwo is called
    lazy val result = sumsProds(ints)

    // then: result should be ((0,0),(1,1))
    result should be (((0,0),(1,1)))
  }

  "smallestTwo" should "duplicate the head of a singleton list" in {
    // given: a list with two elements, the smaller coming first
    lazy val pairs = List((3,4))

    // when: smallestTwo is called
    lazy val result = sumsProds(ints)

    // then: result should be ((3,4),(3,4))
    result should be (((3,4),(3,4)))
  }

  "smallestTwo" should "work" in {
    // given: a list with two elements, the smaller coming first
    lazy val pairs = List((1,2),(3,4),(5,6))

    // when: smallestTwo is called
    lazy val result = sumsProds(ints)

    // then: result should be ((9,12),(15,48))
    result should be (((9,12),(15,48)))
  }
}
