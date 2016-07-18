package net.danielbrice.scalakata

import net.danielbrice.scalakata.SumsProds._
import org.scalatest.{FlatSpec, Matchers}

class SumsProds$Test extends FlatSpec with Matchers {

  "smallestTwo" should "return ((0,0),(1,1)) for empty list" in {
    // given: a list with two elements, the smaller coming first
    lazy val pairs = List()

    // when: smallestTwo is called
    lazy val result = sumsProds(pairs)

    // then: result should be ((0,0),(1,1))
    result should be (((0,0),(1,1)))
  }

  "smallestTwo" should "duplicate the head of a singleton list" in {
    // given: a list with two elements, the smaller coming first
    lazy val pairs = List((3,4))

    // when: smallestTwo is called
    lazy val result = sumsProds(pairs)

    // then: result should be ((3,4),(3,4))
    result should be (((3,4),(3,4)))
  }

  "smallestTwo" should "work" in {
    // given: a list with two elements, the smaller coming first
    lazy val pairs = List((1,2),(3,4),(5,6))

    // when: smallestTwo is called
    lazy val result = sumsProds(pairs)

    // then: result should be ((9,12),(15,48))
    result should be (((9,12),(15,48)))
  }
}
