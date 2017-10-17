package net.danielbrice.scalakata

import net.danielbrice.scalakata.SumsProds._
import org.scalatest.{FlatSpec, Matchers}

class SumsProdsTest extends FlatSpec with Matchers {

  "sumsProds" should "return (0,0,1,1) for empty list" in {
    // given: a list with two elements, the smaller coming first
    lazy val pairs = List()

    // when: smallestTwo is called
    lazy val result = sumsProds(pairs)

    // then: result should be (0,0,1,1)
    result should be ((0.0,0.0,1.0,1.0))
  }

  "sumsProds" should "duplicate the head of a singleton list" in {
    // given: a list with two elements, the smaller coming first
    lazy val pairs = List((3.0,4.0))

    // when: smallestTwo is called
    lazy val result = sumsProds(pairs)

    // then: result should be (3,4,3,4)
    result should be ((3.0,4.0,3.0,4.0))
  }

  "sumsProds" should "work" in {
    // given: a list with two elements, the smaller coming first
    lazy val pairs = List((1.0,2.0),(3.0,4.0),(5.0,6.0))

    // when: smallestTwo is called
    lazy val result = sumsProds(pairs)

    // then: result should be (9,12,15,48)
    result should be ((9.0,12.0,15.0,48.0))
  }
}
